package ua.lviv.magazine.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lviv.magazine.entity.Product;
import ua.lviv.magazine.service.BucketService;
import ua.lviv.magazine.service.ProductService;
import ua.lviv.magazine.service.UserService;

import java.util.List;

@Controller
@Slf4j
public class ProductsController {

    private final BucketService bucketService;
    private final UserService userService;
    private final ProductService productService;

    public ProductsController(BucketService bucketService, UserService userService, ProductService productService) {
        this.bucketService = bucketService;
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping("/products")
    public String productsListPage(Model model) {
        log.info("GET: product list");

        List<Product> products = productService.findAll();
        model.addAttribute("products", products);

        return "products";
    }

    @PostMapping("/products/add")
    public String addProduct(@RequestParam Integer productId) {
        log.info("POST: add product to user list");

/*

        int userId = (int) req.getSession().getAttribute("userId");

        log.debug("param \"productId\": " + productId);
        log.debug("param \"userId\": " + userId);

        Optional<User> userOpt = userService.findById(userId);
        Optional<Product> productOpt = productService.findById(productId);

        if (!userOpt.isPresent() || !productOpt.isPresent()) {
            throw new NotFoundException();
        }

        User user = userOpt.get();
        Product product = productOpt.get();

        log.debug("formed bucket: \n" +
                user + "\n" +
                product);


        Bucket bucket = Bucket.builder()
                .user(user)
                .product(product)
                .purchaseDate(LocalDateTime.now())
                .build();

        bucketService.save(bucket);
*/

        return "redirect:products";
    }

}
