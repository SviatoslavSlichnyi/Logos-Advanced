package ua.lviv.magazine.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lviv.magazine.entity.Product;
import ua.lviv.magazine.service.BucketService;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
public class CabinetController {

    private final BucketService bucketService;

    public CabinetController(BucketService bucketService) {
        this.bucketService = bucketService;
    }

    @GetMapping("/cabinet")
    public String cabinetPage(Model model) {
        log.info("GET: get list of user's products");
/*

        Optional<Object> emailObj = Optional.ofNullable(req.getSession().getAttribute("userEmail"));
        Optional<Object> userIdObj = Optional.ofNullable(req.getSession().getAttribute("userId"));

        if (emailObj.isPresent() && userIdObj.isPresent()) {

            String email = String.valueOf(emailObj.get());
            int userId = (Integer) userIdObj.get();
            List<Product> products = bucketService.findProductsByUserId(userId);

            log.debug("email: " + email);
            log.debug("userId: " + userId);

            model.addAttribute("userEmail", email);
            model.addAttribute("products", products);
        }
        else {
            throw new RuntimeException("email or userId attributes are NULL");
        }
*/

        return "cabinet";
    }

    @DeleteMapping("/cabinet/delete")
    public String deleteProductItem(@RequestParam Integer id) {
        log.info("DELETE: remove product from user list");

        log.debug("product_id to delete: " + id);

//        Optional<Object> userIdObj = Optional.ofNullable(req.getSession().getAttribute("userId"));
//
//        if (userIdObj.isPresent()) {
//            int userId = (Integer) userIdObj.get();
//            log.debug("product list of user_id: " + userId);
//
//            bucketService.deleteByUserIdAndProductId(userId, id);
//        } else {
//            log.error("userId is NULL");
//        }

        return "cabinet";
    }

}
