package com.company.console.entity_utils;

import com.company.db.repository.items.User;

import java.util.Scanner;

public class UserCreator {

    private static Scanner scan = new Scanner(System.in);

    public static User createUser() {

        int user_id = 0;
        String login = userLogin();
        String username = username();
        String pass = pass();

        User user = new User(user_id, login, username, pass);
        return user;
    }

    private static String userLogin() {
        System.out.println("Login");
        String string = scan.nextLine();
        return string;
    }

    private static String username() {
        System.out.println("username");
        String string = scan.nextLine();
        return string;
    }

    private static String pass() {
        System.out.println("pass");
        String string = scan.nextLine();
        return string;
    }

}
