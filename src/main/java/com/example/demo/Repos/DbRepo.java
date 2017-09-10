package com.example.demo.Repos;

import com.example.demo.Classes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DbRepo implements ProdRepo {

    @Autowired
    DataSource dataSource;

    @Override
    public List<Product> getProductList() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT product_id, product_name, " +
                     "product_price, product_color, product_size, stock, product_weight, product_image, " +
                     "product_description FROM Products")) {
            List<Product> productList = new ArrayList<>();
            while (rs.next())
                productList.add(rsProduct(rs));
            return productList;
        } catch (SQLException e){
            return null;
        }
    }


    @Override
    public Product addToCart(int id) {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT product_id, product_name, " +
                     "product_price, product_color, product_size, stock, product_weight, product_image, " +
                     "product_description FROM Products where id=?")) {
            Product product = new Product(id);
            while (rs.next())
                product = (rsProduct(rs));
//                product.product_id = rs.getInt("product_id");
//                product.product_name = rs.getString("product_name");
//                product.product_price = rs.getDouble("product_price");
//                product.product_color = rs.getString("product_color");
//                product.product_size = rs.getInt("product_size");
//                product.stock = rs.getInt("stock");
//                product.product_weight = rs.getInt("product_weight");
//
            return product;
        } catch (SQLException e){
            return null;
        }
    }

    private Product rsProduct(ResultSet rs) throws SQLException {
        return new Product(rs.getInt("product_id"),
                rs.getString("product_name"),
                rs.getDouble("product_price"),
                rs.getString("product_color"),
                rs.getInt("product_size"),
                rs.getInt("stock"),
                rs.getDouble("product_weight"),
                rs.getString("product_image"),
                rs.getString("product_description"));
    }

//    public String checkStock(int id) {
//        int currentStock = 0;
//        String returnStatement = null;
//        try (Connection conn = dataSource.getConnection();
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery("SELECT stock FROM Products Where id=?")) {
//            if(rs.next())
//                currentStock = rs.getInt(1);
//            if(currentStock<1) {
//                returnStatement="Sold out";
//            }
//            else if (currentStock<5){
//                returnStatement="Less than 5 items left";
//            }
//            else {
//                returnStatement="";
//            }
//            return returnStatement;
//        } catch (SQLException e){
//            return null;
//        }
//    }
}
