package com.company;

import com.company.db.DB_Utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Chat {
    public static List<Message> chat = new ArrayList<Message>();;
    //mes_id, user_id, message, mes_time

    public static List<Message> main() throws SQLException {
        String mes_id = "", user_id = "", message = "", mes_time = "";
        List<String> list = DB_Utils.selectFromDB("chat", "*", "");
        for (int i = 0; i < list.size(); i++) {
            mes_id = (list.get(i));
            user_id = (list.get(i + 1));
            message = (list.get(i + 2));
            mes_time = (list.get(i + 3));
            chat.add(new Message(mes_id, user_id, message, mes_time));
            i += 3;
        }
        return (chat);
    }

//    public static void main(String[] args) throws SQLException {
//        print_chat_message();
//    }


    public static void print_chat_message() throws SQLException {
        System.out.println("--Чат-- \n");

        chat = main();
        int size = chat.size();
        String mes_id, user_id, message, mes_time, username;
        StringBuilder myMessage = new StringBuilder();
//        myMessage.append("\t");
        for (int i = 0; i < size; i++) {
//            mes_id = chat.get(i).getMes_id();
            user_id = chat.get(i).getUser_id();
            username = Users.getUsernameByID(user_id);
            message = chat.get(i).getMessage();
            mes_time = chat.get(i).getMes_time();
//            myMessage.append(mes_id).append(" | ").append(user_id).append(" | ").append(message).append(" | ").append(mes_time).append("\n");
            myMessage.append(username).append(" | ").append(message).append(" | ").append(mes_time).append("\n");
        }
        System.out.println(myMessage);
    }

}

class Message {

    private final String mes_id, user_id, message, mes_time;

    public Message(String mes_id, String user_id, String message, String mes_time) {
        this.mes_id = mes_id;
        this.user_id = user_id;
        this.message = message;
        this.mes_time = mes_time;
    }

    public String getMes_id() {
        return mes_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getMessage() {
        return message;
    }

    public String getMes_time() {
        return mes_time;
    }
}
