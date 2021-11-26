package com.company;

import com.company.db.DB_Utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Users {
    public static List<User> users = new ArrayList<User>();

    //todo main каждого класса с бд - вынести в отдельный метод, который будет приготавливать коллекции в начале таска
    public static String getUsernameByID(String us_id) throws SQLException {
        main();
        String username = " ";
        for (int i = 0; i < users.size(); i++) {
            String user_id = users.get(i).getUser_id();
            if (us_id.equals(user_id)) {
                username = users.get(i).getUsername();
                return username;
            }
        }
        return username;
    }

    public static void print_users() throws SQLException {
        System.out.println("--Юзеры--");

        users = main();

        int size = users.size();
        String user_id, login, username, pass;
        StringBuilder myMessage = new StringBuilder();
//        myMessage.append("\t");
        for (int i = 0; i < size; i++) {
            user_id = users.get(i).getUser_id();
            login = users.get(i).getLogin();
            username = users.get(i).getUsername();
            pass = users.get(i).getPass();

            myMessage.append(user_id).append(" | ").append(login).append(" | ").append(username).append(" | " +
                    "").append(pass).append("\n");
        }
        System.out.println(myMessage);
    }

    public static List<User> main() throws SQLException {
        String user_id, login, username, pass;
        List<String> list = DB_Utils.selectFromDB("users", "*", "");
        for (int i = 0; i < list.size(); i++) {
            user_id = (list.get(i));
            login = (list.get(i + 1));
            username = (list.get(i + 2));
            pass = (list.get(i + 3));
            users.add(new User(user_id, login, username, pass));
            i += 3;
        }
        return (users);
    }
}

class User {
    private final String user_id, login, username, pass;

    public User(String user_id, String login, String username, String pass) {
        this.user_id = user_id;
        this.login = login;
        this.username = username;
        this.pass = pass;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getLogin() {
        return login;
    }

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }
}
