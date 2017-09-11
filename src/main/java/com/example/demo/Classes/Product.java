package com.example.demo.Classes;

import java.util.ArrayList;
import java.util.List;

public class Product {
    public int productId;
    public String productName;
    public double productPrice;
    public String productColor;
    public int productSize;
    public int productStock;
    public double productWeight;
    public String productImage;
    public String productDescription;

    public Product(int productId, String productName, double productPrice, String productColor, int productSize, int productStock, double productWeight, String productImage, String productDescription) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productColor = productColor;
        this.productSize = productSize;
        this.productStock = productStock;
        this.productWeight = productWeight;
        this.productImage = productImage;
        this.productDescription = productDescription;
    }

    public Product(int productId) {
        this.productId = productId;
    }
}
