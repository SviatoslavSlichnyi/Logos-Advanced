package ua.lviv.magazine.controller.admin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.lviv.magazine.controller.response.ForbiddenResponse;
import ua.lviv.magazine.entity.Product;
import ua.lviv.magazine.service.BucketService;
import ua.lviv.magazine.service.ProductService;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor

@Controller
@Slf4j
public class ProductsAdminController {

    private final BucketService bucketService;
    private final ProductService productService;

    @GetMapping("/admin/products")
    public void adminProductsPage(Principal principal, Model model) {
        log.info("GET: get products list");

        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        model.addAttribute("userEmail", principal.getName());
    }

    @DeleteMapping("/admin/products/delete/{id}")
    public ResponseEntity<Long> deleteProducts(@PathVariable Integer id, Principal principal, Model model) {
        log.info("DELETE: remove product from list");

        if (bucketService.existsByProductId(id)) {
            throw new ForbiddenResponse();
        }

        productService.deleteById(id);

        model.addAttribute("userEmail", principal.getName());

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
