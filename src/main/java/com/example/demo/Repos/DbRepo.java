package com.example.demo.Repos;

import com.example.demo.Classes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class DbRepo implements ProdRepo {

    @Autowired
    DataSource dataSource;

    @Override
    public List<Product> printProductList() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT Product_id, Product_name, Product_price FROM Products")) {
            List<Product> productList = new ArrayList<>();
            while (rs.next()) productList.add(rsProduct(rs));
            return productList;
        } catch (SQLException e){
            return null;
        }
    }

    private Product rsProduct(ResultSet rs) throws SQLException {
        return new Product(rs.getInt("Product_id"),
                rs.getString("Product_name"),
                rs.getDouble("Product_price"));
    }


}
