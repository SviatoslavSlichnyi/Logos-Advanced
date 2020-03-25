package ua.lviv.magazine.controller.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lviv.magazine.controller.response.ForbiddenResponse;
import ua.lviv.magazine.entity.Product;
import ua.lviv.magazine.service.BucketService;
import ua.lviv.magazine.service.ProductService;

import java.util.List;

@Controller
@Slf4j
public class ProductsAdminController {

    private final BucketService bucketService;
    private final ProductService productService;

    public ProductsAdminController(BucketService bucketService, ProductService productService) {
        this.bucketService = bucketService;
        this.productService = productService;
    }

    @GetMapping("/admin/products")
    public String adminProductsPage(Model model) {
        log.info("GET: get products list");

        List<Product> products = productService.findAll();
        model.addAttribute("products", products);

        return "admin/products";
    }

    @DeleteMapping("/admin/products/delete")
    public String deleteProducts(@RequestParam Integer id) {
        log.info("DELETE: remove product from list");

        if (bucketService.existsByProductId(id)) {
            throw new ForbiddenResponse();
        }

        productService.deleteById(id);

        return "redirect:admin/products";
    }

}
