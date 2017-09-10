package com.example.demo.Repos;

import com.example.demo.Classes.Product;
import java.util.List;

public interface ProdRepo {
    List<Product> getProductList();
//    String checkStock(int id);
    Product addToCart(int id);
}
