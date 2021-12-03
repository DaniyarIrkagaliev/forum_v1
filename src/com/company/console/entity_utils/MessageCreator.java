package com.company.console.entity_utils;

import com.company.db.repository.items.Message;

import java.util.Scanner;

public class MessageCreator {

    private static Scanner scan = new Scanner(System.in);

    public static Message createMessage() {

        int mes_id = 0, user_id = 0;
        String text_message = textMessage();
        String mes_time = mesTime();

        Message message = new Message(mes_id, user_id, text_message, mes_time);
        return message;
    }

    private static String textMessage() {
        System.out.println("Text_message");
        String string = scan.nextLine();
        return string;
    }

    private static String mesTime() {
        System.out.println("mes_time");
        String string = scan.nextLine();
        return string;
    }
}
