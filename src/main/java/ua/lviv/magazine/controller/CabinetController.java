package ua.lviv.magazine.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lviv.magazine.controller.response.NotFoundResponse;
import ua.lviv.magazine.entity.Product;
import ua.lviv.magazine.service.BucketService;
import ua.lviv.magazine.service.UserService;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor

@Controller
@Slf4j
public class CabinetController {

    private final BucketService bucketService;
    private final UserService userService;

    @GetMapping("/cabinet")
    public String cabinetPage(Model model, Principal principal) {
        log.info("GET: get list of user's products");

        String email = principal.getName();
        Long userId = userService.findIdByEmail(email).orElseThrow(
                () -> new NotFoundResponse("User was NOT found"));
        List<Product> products = bucketService.findProductsByUserId(userId);

        model.addAttribute("userEmail", email);
        model.addAttribute("products", products);

        return "cabinet";
    }

    @DeleteMapping("/cabinet/delete/{id}")
    public ResponseEntity<Long> deleteProductItem(@PathVariable Integer id, Principal principal) {
        log.info("DELETE: remove product from user list");

        Long userId = userService.findIdByEmail(principal.getName()).orElseThrow(
                () -> new NotFoundResponse("User was NOT found"));

        log.debug("product_id to delete: " + id);
        log.debug("user_id to delete: " + userId);

        bucketService.deleteByUserIdAndProductId(userId, id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
