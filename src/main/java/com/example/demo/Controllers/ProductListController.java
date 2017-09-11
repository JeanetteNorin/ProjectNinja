package com.example.demo.Controllers;

import com.example.demo.Repos.ProdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductListController {

    @Autowired
    private ProdRepo prodRepo;

    @ResponseBody
    @GetMapping("/products")
    public ModelAndView printList() {
        return new ModelAndView("ProductPage")
                .addObject("prod", prodRepo.getProductList());
    }

    @GetMapping("/productdetails/{id}")
    public ModelAndView ObjectDetails(@PathVariable int id) {
        return new ModelAndView("productdetails")
                .addObject("prodDetails", prodRepo.selectProduct(id));
    }

    @GetMapping("/start")
    public ModelAndView startPage() {
        return new ModelAndView("index");
    }
}
