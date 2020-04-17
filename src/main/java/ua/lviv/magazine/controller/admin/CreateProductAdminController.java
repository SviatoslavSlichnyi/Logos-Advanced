package ua.lviv.magazine.controller.admin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lviv.magazine.controller.response.ForbiddenResponse;
import ua.lviv.magazine.entity.Product;
import ua.lviv.magazine.service.ProductService;

import java.security.Principal;

@RequiredArgsConstructor

@Controller
@Slf4j
public class CreateProductAdminController {

    private final ProductService productService;

    @GetMapping("/admin/create-product")
    public String createProductPage(Principal principal, Model model) {
        log.info("GET: creation product page");

        model.addAttribute("userEmail", principal.getName());

        return "admin/create-product";
    }

    @PostMapping("/admin/create-product")
    public String createProduct(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam String price,
            Principal principal,
            Model model
    ) {
        log.info("POST: adding the product to general list");

        if (!isDataValid(name, description, price)) {
            throw new ForbiddenResponse();
        }

        Product product = Product.builder()
                .name(name)
                .description(description)
                .price(Double.parseDouble(price))
                .build();

        productService.save(product);

        model.addAttribute("userEmail", principal.getName());

        return  "products";
    }

    private boolean isDataValid(String name, String description, String price) {
        return name != null && description != null && price != null;
    }

}
