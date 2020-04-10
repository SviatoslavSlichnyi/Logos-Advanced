package com.lgs.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class CabinetController {

    @GetMapping("/cabinet")
    public String getCabinetPage(Model model, Principal principal) {
        String name = principal.getName();

        model.addAttribute("userEmail", name);

        return "cabinet";
    }

}
