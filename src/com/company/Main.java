package com.company;

import com.company.db.DB_Utils;
import com.company.pages.Password;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static String onlineUsername, onlineLogin, onlineUserID;
    private static int switchInd;

    public static void main(String[] args)
            throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException {

        switchInd = 1;
        int ind = 1;
        while (switchInd != 0) {
            switch (ind) {
                case 1 -> {
                    int value = login();
//                    System.out.println("*** " + value +" " + onlineUsername);
                    if (value == 1) {
                        ind = 2;
                    }
                }
                case 2 -> {
                    index();
                    switchInd = 0;
                }
                case 3 -> {
                    //topic_answ
                }
                case 5 -> {
                    System.out.println("Выход");
                    switchInd = 0;
                    //System.exit(0);
                }
            }
        }

        //login
        //main
        //topics_answ
    }

    public static void index() throws SQLException {
        getCurrentTime();
        Chat.print_chat_message();
        Topics.print_topic();

        System.out.println("\n Написать сообщение в чат (1)     |      Выбрать тему (2)      |      Начать новую тему(3)      |" +
                "      Выйти (4)");

        System.out.println("На данный момент функции:" +
                "\n            не работает   (1)     |      работает (2)      |      не работает(3)     |" +
                "      работает (4)");
        Scanner scn = new Scanner(System.in);
        int sw = scn.nextInt();
        switch (sw) {
            case 1 -> {
            }
            case 2 -> {
                topicsChose();
            }
            case 3 -> {
                //System.out.println();
                newTopic();
            }
            case 4 -> {
                System.exit(0);
            }
        }
        // свитч написать в чат или выбор тем или logout
    }

    public static void newTopic() throws SQLException {
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите название вашей темы");
        String title = scn.next();
        System.out.println("Введите описание темы");
        String description = scn.next();
        String date = getCurrentTime();
        String col = "(title, topic_description, topic_date, user_id)";
        String values = "(" + title +", "+ description + ", "+ date+ ", "+ onlineUserID+")";
        DB_Utils.insertIntoDB(  "topic", "()", values);
        DB_Utils.selectFromDB("topic", "*", "");
    }

    public static void topicsChose() throws SQLException {
        System.out.println("\nВыберите тему по ее номеру из представленных выше");
        Scanner scn = new Scanner(System.in);
        String top_id = scn.next();
        Topics_Answers.printTopicAnswByTopicId(top_id);

        System.out.println("Написать ответ на тему (1)     |      Вернуться к выбору тем (2)     |      Выйти (3)");
        int sw = scn.nextInt();
        switch (sw) {
            case 1 -> {
                System.out.println();
                //написать ответ
                topicsChose();
            }
            case 2 -> {
                topicsChose();
            }
            case 3 -> {
                System.exit(0);
            }
        }
    }

    //todo спросить, как решить проблему доступа в loginpage
    public static int login() throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException {
        System.out.println("Войдите или создайте аккаунт");

        Scanner scn = new Scanner(System.in);
        //todo добавить регистрацию и поделить на методы
        //todo СПРОСИТЬ, ЛУЧШЕ ЛИ вместо кейсов и ифов - FSM юзать
        System.out.println("Вход (1)     |      Регистрация (2)");
        int sw = scn.nextInt();
        int j = 0; //вошел или нет. 1 - вошел. 0 - нет
        String enteredLogin, password;
        switch (sw) {
            case 1 -> {

                System.out.println(" ***ТОЛЬКО НА ВРЕМЯ ПРОВЕРКИ*** ");
                Users.print_users();
                System.out.println("\n");

                System.out.println("Введите логин");
                enteredLogin = scn.next();
                System.out.println("Введите пароль");
                password = scn.next();
                String log;
                int i = 0;
                String originalPassword = "";

                for (int ind = 0; ind < Users.users.size(); ind++) {
                    log = Users.users.get(ind).getLogin();
                    if (log.equals(enteredLogin)) {
                        onlineLogin = log;

                        originalPassword = Users.users.get(ind).getPass();

                        boolean matched = Password.validatePassword(password, originalPassword);
//                        System.out.println(matched);
                        if (matched) {
                            onlineUsername = Users.users.get(ind).getUsername();
                            onlineUserID = Users.users.get(ind).getUser_id();
                            System.out.println("Вы вошли как " + onlineUsername + "\n");
                        } else {
                            System.out.println("Ошибка вход: неверный пароль \n");
                        }
                        i = 1;
                        break;
                    }
                }
                if (i != 1) {
                    System.out.println("Ошибка входа: не существует введенного логина \n");
                    j = 0;
                } else {
                    j = 1;
                }

            }
            case 2 -> {
                System.out.println("Регистрация временно недоступна");
                j = 0;
            }

        }
        return (j);
    }

    public static String getCurrentTime() {
//        2021-07-12 21:50:40
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
//        System.out.println("Текущее время: " + dateFormat.format(date));
        return dateFormat.format(date);
    }
}
