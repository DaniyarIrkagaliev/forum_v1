package com.company.console.pages;

public class Password {

    public static boolean validatePassword(String originalPassword, String storedPassword) {
        if (originalPassword.equals(storedPassword)) {
            return true;
        } else {
            return false;
        }
    }
}
