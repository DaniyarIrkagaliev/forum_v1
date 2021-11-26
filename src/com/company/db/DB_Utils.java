package com.company.db;

import com.company.Main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DB_Utils {

//    1. Приложение, позволяющее посмотреть содержимое основных таблиц (не менее трёх).
//    2. Возможность вставки/изменения/удаления данных как минимум в двух таблицах.
//    3. Должна быть реализована защита от внедрения html-кода, sql-инъекций, XSS и др.


    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/forum_db";
    private static final String user = "root";
    private static final String password = "root";
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;


    public static void main(String args[]) {
        String query = "select count(*) from chat";

        try {
            con = DriverManager.getConnection(url, user, password);
//            Statement stmt = conn.createStatement();
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            System.out.println(Text_Utils.TEXT_TABLE);
            printTable("chat", "*");

            printTable("users", "*");
            printTable("topic", "*");
            printTable("topic_answ", "*");

            Scanner scn = new Scanner(System.in);
            int sw = 1;
            while (sw != 0) {
                System.out.println(Text_Utils.TEXT_START);

                sw = scn.nextInt();
                switch (sw) {
                    case 1 -> {
                        insert();

                    }
                    case 2 -> {
                        update();
                    }
                    case 3 -> {
                        delete();
                    }
                    case 4 -> {
                        select();
                    }
                    case 5 -> {
                        System.out.println("Выход");
                        sw = 0;
                    }
                }
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
    }

    public static void printTable(String table, String columns) throws SQLException {
        String[] arr = switcher(table);
        System.out.println("    ---" + table + "---    ");
        int i = Integer.parseInt(arr[0]);
        List<String> list2 = selectFromDB(table, columns, "");
        int count = 0;
        while (count != list2.size()) {
            System.out.println("\t");
            for (int h = 0; h < i; h++) {
                System.out.print(list2.get(count) + "    \t");
                count++;
            }
        }
        System.out.println("\n");
    }

    public static void select() throws SQLException {
        Scanner scn = new Scanner(System.in);
        System.out.println("Вывод\n" +
                " Введите таблицу");
        String table = scn.nextLine();

        String[] arr = switcher(table);
        String text = arr[1];
        System.out.println("имеющиеся колонки: \n " + text);

        System.out.println("Введите колонку");
        printTable(table, "*");
    }

    public static List<String> selectFromDB(String table, String columns, String where) throws SQLException {
        String query = "select" + columns + "from " + table + " " + where +";";
        List<String> listA = new ArrayList<String>();
        rs = stmt.executeQuery(query);
        String[] arr = switcher(table);
        int i = Integer.parseInt(arr[0]);

        while (rs.next()) {
            for (int j = 1; j < i + 1; j++) {
                listA.add(rs.getString(j));
            }
        }
        return (listA);
    }

    public static void insert() throws SQLException {
        Scanner scn = new Scanner(System.in);
        System.out.println("Вставка" +
                "\n Введите таблицу");
        String table = scn.nextLine();

        String[] arr = switcher(table);
        String text = arr[1];
        System.out.println("имеющиеся колонки: \n " + text);

        String column = text;
        System.out.println("Введите значение " + text);
        String values = scn.nextLine();
        String time = Main.getCurrentTime();
//        values += " '" + time+"'";
//        System.out.println(values);
        insertIntoDB(table, column, values);
        printTable(table, "*");
    }

    public static void insertIntoDB(String table, String columns, String values) throws SQLException {
//        Scanner scn = new Scanner(System.in);
//        String sw = scn.next();
        String query = "INSERT INTO " + table + " ( " + columns + " ) \n" +
                " VALUES ( " + values + " );\n";
        System.out.println(query);
        stmt.executeUpdate(query);
    }

    public static void update() throws SQLException {
        Scanner scn = new Scanner(System.in);
        System.out.println("Изменение" +
                "\n Введите таблицу");
        String table = scn.nextLine();

        String[] arr = switcher(table);
        String text = arr[1];
        System.out.println("имеющиеся колонки: \n " + text);

        System.out.println("Введите значение в запросе set без скобочек");
        String set = scn.nextLine();
        System.out.println("Введите условие where без скобочек");
        String where = scn.nextLine();
        updateDB(table, set, where);
        System.out.println("Результат изменения:\n");
        printTable(table, "*");
    }

    public static void updateDB(String table, String set, String where) throws SQLException {
        String query = "UPDATE " + table + " SET " + set + " " + " WHERE ( " + where + "); \n";
        stmt.executeUpdate(query);
    }

    public static void delete() throws SQLException {
        Scanner scn = new Scanner(System.in);
        System.out.println("Удаление" +
                "\n Введите таблицу");
        String table = scn.nextLine();
//INSERT INTO chat (mes_id, user_id, message, mes_time) VALUES (4, '3', 'Привет. как дела?)', '2021-07-10 19:06:54');
        String[] arr = switcher(table);
        String text = arr[1];
        System.out.println("имеющиеся колонки: \n " + text);


        System.out.println("Введите условие where без скобочек");
        String where = scn.nextLine();
        deleteFromDB(table, where);
        System.out.println("Результат удаления:\n");
        printTable(table, "*");
    }

    public static void deleteFromDB(String table, String where) throws SQLException {
        String query = "delete from " + table + " " + "where (" + where + ");";
        System.out.println(query);
//        query = "delete from chat where(mes_id = 17);";
        stmt.executeUpdate(query);
    }

    //метод, указывающий текст для вывода и кол-во столбцов в выбранной таблице
    public static String[] switcher(String table) {
        int i;
        String text;
        String[] myArray = new String[2];
        switch (table) {
            case "chat" -> {
                i = 4;
                text = Text_Utils.TEXT_CHAT;
            }
            case "users" -> {
                i = 4;
                text = Text_Utils.TEXT_USERS;
            }
            case "topic" -> {
                i = 5;
                text = Text_Utils.TEXT_TOPIC;
            }
            case "topic_answ" -> {
                i = 5;
                text = Text_Utils.TEXT_TOPIC_ANSW;
            }
            default -> throw new IllegalStateException("Unexpected value: " + table);
        }
        myArray[0] = String.valueOf(i);
        myArray[1] = text;
        return (myArray);
    }
}
