//package com.company.pages;
//
//import com.company.Users.*;
//
//import java.security.NoSuchAlgorithmException;
//import java.security.spec.InvalidKeySpecException;
//import java.util.Scanner;
//
//public class LoginPage {
//
//    private static String onlineUsername, onlineLogin;
//
//    public static int login() throws NoSuchAlgorithmException, InvalidKeySpecException {
//        System.out.println("Войдите или создайте аккаунт");
//
//        Scanner scn = new Scanner(System.in);
//        //todo добавить регистрацию
//        //todo вместо кейсов и ифов - FSM
//        System.out.println("Вход (1)     |      Регистрация (2)");
//        int sw = scn.nextInt();
//        int j = 0; //вошел или нет. 1 - вошел. 0 - нет
//        String enteredLogin, password;
//        switch (sw) {
//            case 1 -> {
//                System.out.println("Введите логин");
//                enteredLogin = scn.next();
//                System.out.println("Введите пароль");
//                password = scn.next();
//                String log;
//                int i = 0;
//                String originalPassword = "";
//
//                for (int ind = 0; ind < Users.users.size(); ind++) {
//                    log = Users.users.get(ind).getLogin();
//                    if (log.equals(enteredLogin)) {
//                        onlineLogin = log;
//                        System.out.println(onlineLogin + " | " + enteredLogin);
//
//                        originalPassword = Users.users.get(ind).getPass();
//                        String generatedPasswordHash = Password.generatePasswordHash(password);
//                        boolean matched = Password.validatePassword(originalPassword, generatedPasswordHash);
//                        System.out.println(matched);
//                        if (matched) {
//                            onlineUsername = Users.users.get(ind).getUsername();
//                            System.out.println("Вы вошли как " + onlineUsername);
//                        } else {
//                            System.out.println("Ошибка вход: неверный пароль");
//                        }
//                        i = 1;
//                        break;
//                    }
//                }
//                if (i != 1) {
//                    System.out.println("Ошибка входа: не существует введенного логина");
//                    j = 0;
//                }else{
//                    j = 1;
//                }
//
//            }
//            case 2 -> {
//                System.out.println("Регистрация временно недоступна");
//                j = 0;
//            }
//
//        }
//        return(j);
//    }
//
//}
