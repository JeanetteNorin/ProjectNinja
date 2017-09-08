package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.Principal;

@Controller
public class CartController {

    @GetMapping("/shoppingcart")
    String shopingcart(Principal principal) {
        return principal != null ? "shoppingcart" : "shoppingcart";
    }
}
