package ua.lviv.magazine.controller.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lviv.magazine.controller.response.ForbiddenResponse;
import ua.lviv.magazine.entity.Product;
import ua.lviv.magazine.service.ProductService;

@Controller
@Slf4j
public class CreateProductAdminController {

    private final ProductService productService;

    public CreateProductAdminController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/admin/create-product")
    public String createProductPage() {
        log.info("GET: creation product page");

        return "admin/create-product";
    }

    @PostMapping("/admin/create-product")
    public String createProduct(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam String price
    ) {
        log.info("POST: adding the product to general list");

        if (isDataValid(name, description, price)) {
            Product product = Product.builder()
                    .name(name)
                    .description(description)
                    .price(Double.parseDouble(price))
                    .build();
            productService.save(product);

            return  "products";
        } else {
            throw new ForbiddenResponse();
        }
    }

    private boolean isDataValid(String name, String description, String price) {
        return name != null && description != null && price != null;
    }

}
