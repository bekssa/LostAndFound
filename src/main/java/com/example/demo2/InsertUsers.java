package com.example.demo2;
import java.sql.*;
import com.example.demo2.Check.*;
public class InsertUsers {
    public void insert(String name,String lastname,String password,String email) {
        try (Connection connection = DriverManager.getConnection(DatabaseInfo.DB_URL, DatabaseInfo.DB_USER,DatabaseInfo.DB_PASSWORD)) {
            String insertQuery = "INSERT INTO users (name,lastname,password,email)\n" +
                    "VALUES('"+name+"','"+lastname+"','"+password+"','"+email+"');";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            new alertException().setAlert();
            e.printStackTrace();

        }
    }
}