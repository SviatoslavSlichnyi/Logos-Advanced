package ua.lviv.magazine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    String homePage() {
        return "redirect:login";
    }
}
