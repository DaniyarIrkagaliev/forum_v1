package com.company.db.db_utils;

import com.company.db.DataBase;
import com.company.db.repository.Items;
import com.company.db.repository.Topic;
import com.company.db.repository.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDataBase implements DataBase_Utiller {

    //user_id, login, username, pass
    private static UserDataBase INSTANCE;
    private static DataBase db;

    public static UserDataBase getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new UserDataBase();
            db = DataBase.getINSTANCE();
        }
        return INSTANCE;
    }

    @Override
    public void add(Items obj) {
        try {
            User user = (User) obj;
            db.executeUpdate("INSERT INTO users (login, username, pass) VALUES ('" +
                    user.getLogin() + "', '" + user.getUsername() + "', '" + user.getPassword() + "')");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void removeByID(Integer id) {
        String query = "DELETE FROM users WHERE user_id = ";
        db.executeUpdate(query + id + ";");
    }

    @Override
    public Items getByID(Integer id) throws SQLException {
        String query = "SELECT * FROM users WHERE user_id = ";
        ResultSet rs = db.executSelect(query + id + ";");
        return new User(rs.getInt("user_id"), rs.getString("login"),
                rs.getString("username"), rs.getString("pass"));
    }

    public List<User> getByUserID(Integer id){
        List <User> items = new ArrayList<>();
        try {
            ResultSet rs = db.executSelect("SELECT * FROM users WHERE user_id=" + id);
            while (rs.next())
                items.add(getByResultSet(rs));
            rs.close();
            return items;
        }catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Items> getAll() {
        List<Items> list = new ArrayList<>();
        try {
            ResultSet rs = db.executSelect("SELECT * FROM users");
            while (rs.next())
                list.add(getByResultSet(rs));
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void printTable(){
        List<Items> list = getAll();
        System.out.println("users table: ");
        for (Items user : list) {
            System.out.println(user.toString());
        }
    }

    //    @Override
    public User getByResultSet(ResultSet rs) throws SQLException {
        try {
            return new User(
                    rs.getInt("user_id"),
                    rs.getString("login"),
                    rs.getString("username"),
                    rs.getString("pass")
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(" User getByResultSet");
            return null;
        }
    }

    public User selectBylogin(String login) throws SQLException {
        String query = ("SELECT * FROM users WHERE username = '" + login+ "'");
        ResultSet rs = db.executSelect(query);
        User user = null;
        if (rs.next()) {
            user = getByResultSet(rs);
        }
        return user;
    }

    public String getUsernameByID(int id){
        User user = (User) getByUserID(id);
        String username = user.getUsername();
        return username;
    }
}
