package com.example.demo.Controllers;

import com.example.demo.Repos.ProdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
//                .addObject("stock", prodRepo.checkStock(id));

    }

    @GetMapping("/start")
    public ModelAndView startPage() {
        return new ModelAndView("index");
    }
}
