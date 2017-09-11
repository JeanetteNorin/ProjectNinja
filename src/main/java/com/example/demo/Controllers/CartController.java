package com.example.demo.Controllers;

import com.example.demo.Repos.DbRepo;
import com.example.demo.Repos.ProdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class CartController {

    @Autowired
    private ProdRepo prodRepo;

    @PostMapping("/shoppingcart/{id}")
    public String addToCart(@PathVariable int id) {
        prodRepo.selectProduct(id);
        return "redirect:/start";
    }

    @GetMapping("/shoppingcart")
    String shoppingcart(Principal principal) {
        return principal != null ? "shoppingcart" : "shoppingcart";
    }

    @PostMapping("/addtocart")
    public String newShopper(HttpSession session) {
//        prodRepo.addToCart()
        return "redirect:/products";
    }
}


//Vid nytt tillägg i kundvagn = försök hämta lista, är den null = skapa ny lista, annars = lägg till i lista.
//session.productList...
