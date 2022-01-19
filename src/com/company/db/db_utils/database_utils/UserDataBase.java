package com.company.db.db_utils.database_utils;

import com.company.db.DataBase;
import com.company.db.repository.items.Items;
import com.company.db.repository.items.User;
import com.company.utils.CurrentTime;

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
        }
        return INSTANCE;
    }

    @Override
    public void add(Items obj) {
        try {
            User user = (User) obj;
            String currentTime = CurrentTime.getCurrentTime();
            String query = "INSERT INTO users (user_id, login, username, pass) VALUES";
            db.executSelect(query + " (" + user.getID() + " '" + user.getLogin() + "', '" + user.getUsername() + "', '" +
                    "" + user.getPassword() + "'); ");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void removeByID(Integer id) {
        String query = "DELETE FROM users WHERE user_id = ";
        db.executSelect(query + id + ";");
    }

    @Override
    public Items getByID(Integer id) throws SQLException {
        String query = "SELECT * FROM users WHERE user_id = ";
        ResultSet rs = db.executSelect(query + id + ";");
        return new User(rs.getInt("user_id"), rs.getString("login"),
                rs.getString("username"), rs.getString("pass"));
    }


    @Override
    public List<Items> getAll() throws SQLException {
        List<Items> list = new ArrayList<>();
        String query = "SELECT * FROM users";
        ResultSet rs = db.executSelect(query);
        while (rs.next()) {
            User user = User.getByResultSet(rs);
            list.add(user);
        }
        return list;
    }

    @Override
    public void printTable() throws SQLException {
        List<Items> list = getAll();
        System.out.println("users table: ");
        for (Items user : list) {
            System.out.println(user.toString());
        }
    }
}
