package com.project.dao;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.dbutil.DBUtil;
import com.project.pojo.User;

public class UserDao {
    private static final String INSERT_USERS_SQL = "INSERT INTO users (name, password, email, dob, gender) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_USER_SQL = "SELECT * FROM users WHERE email=? AND password=?";

    // Method to register a user
    public void registerUser(User user) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword()); // Consider hashing the password
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setDate(4, new java.sql.Date(user.getDob().getTime()));
            preparedStatement.setString(5, user.getGender());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging this instead
        }
    }

    // Method to validate user login
    public boolean validateUser(String email, String password) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_SQL)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password); // Consider hashing the password
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // Returns true if user exists
        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging this instead
        }
        return false;
    }
}