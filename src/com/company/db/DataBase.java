package com.company.db;

import java.sql.*;
import java.util.Properties;

public class DataBase {
    private static DataBase INSTANCE;
    private Connection connection;
    private Statement statement;
    private static final String url = "jdbc:mysql://localhost:3306/forum_db";
    private static final String user = "root";
    private static final String password = "root";

//    @Override
    public static DataBase getINSTANCE() {
        if (INSTANCE == null) {
            try {
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            INSTANCE = new DataBase();
            INSTANCE.connect();
        }
        return INSTANCE;
    }

    public Connection reconnect() {
        try {
            connection.close();
            connection = DriverManager.getConnection(url, user, password);
            statement = createStatement(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public Statement createStatement(Connection connection) {
        try {
            return connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void connect() {
        try {
            Properties properties = new Properties();
            properties.setProperty("autoReconnect", "true");
            properties.setProperty("connectTimeout", "50000");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }


    public ResultSet executSelect(String query) {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public int executeUpdate(String query) {
        int rows = 0;
        try  {
            rows = statement.executeUpdate(query);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return rows;
    }
}
