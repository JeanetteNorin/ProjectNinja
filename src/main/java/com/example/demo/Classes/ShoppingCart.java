package com.example.demo.Classes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    double totalCost;
    private List<Product> shoppingCart = new ArrayList<>();

    public List<Product> getShoppingCart() {
        return shoppingCart;
    }

    public List<Product> addToCart(Product product) {
        shoppingCart.add(product);
        return shoppingCart;
    }
}
