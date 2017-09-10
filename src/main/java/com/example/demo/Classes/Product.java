package com.example.demo.Classes;

public class Product {

    public int product_id;
    public String product_name;
    public double product_price;
    public String product_color;
    public int product_size;
    public int product_stock;
    public double product_weight;
    public String product_image;
    public String product_description;


    public Product(int product_id, String product_name, double product_price, String product_color, int product_size, int product_stock, double product_weight, String product_image, String product_description) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_color = product_color;
        this.product_size = product_size;
        this.product_stock = product_stock;
        this.product_weight = product_weight;
        this.product_image = product_image;
        this.product_description = product_description;

    }

    public Product(int product_id) {
        this.product_id = product_id;
    }

}
