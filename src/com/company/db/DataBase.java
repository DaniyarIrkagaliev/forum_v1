package com.company.db;

import java.sql.*;

public class DataBase {

    private static final String url = "jdbc:mysql://localhost:3306/forum_db";
    private static final String user = "root";
    private static final String password = "root"; //todo пароль ноут, на компе поменять
    private Statement stmt;


    public void connect() {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            stmt = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ResultSet executSelect(String query) {
        ResultSet resultSet = null;
        try {
            resultSet = stmt.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
}
