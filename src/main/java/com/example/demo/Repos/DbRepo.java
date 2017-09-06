package com.example.demo.Repos;

import com.example.demo.Classes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
            while (rs.next()) productList.add(rsProduct(rs));
            return productList;
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
}
