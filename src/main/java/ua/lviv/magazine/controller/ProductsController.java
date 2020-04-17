package ua.lviv.magazine.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.security.provider.certpath.OCSPResponse;
import ua.lviv.magazine.entity.Bucket;
import ua.lviv.magazine.entity.Product;
import ua.lviv.magazine.entity.User;
import ua.lviv.magazine.service.BucketService;
import ua.lviv.magazine.service.ProductService;
import ua.lviv.magazine.service.UserService;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor

@Controller
@Slf4j
public class ProductsController {

    private final BucketService bucketService;
    private final UserService userService;
    private final ProductService productService;

    @GetMapping("/products")
    public String productsListPage(Model model, Principal principal) {
        log.info("GET: product list");

        List<Product> products = productService.findAll();

        model.addAttribute("products", products);
        model.addAttribute("userEmail", principal.getName());

        return "products";
    }

    @PostMapping("/products/add")
    public String addProduct(@RequestParam Integer productId, Principal principal, Model model) {
        log.info("POST: add product to user list");


        String email = principal.getName();
        User user = userService.findByEmail(email);
        Product product = productService.findById(productId);

        log.debug("param \"productId\": " + productId);
        log.debug("param \"userId\": " + user.getId());

        Bucket bucket = Bucket.builder()
                .user(user)
                .product(product)
                .purchaseDate(LocalDateTime.now())
                .build();

        bucketService.save(bucket);

        model.addAttribute("userEmail", email);

        return "/products";
    }

}
