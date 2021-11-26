package com.company;

import com.company.db.DB_Utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Topics_Answers {
    public static List<Answer> answers = new ArrayList<Answer>();


    public static void printTopicAnswByTopicId(String top_id) throws SQLException {
        System.out.println("--Ответы по теме "+ top_id+ "--  \n");
        answers = main();

        int size = answers.size();
        String answ_id, topic_id, message, mes_time, user_id, username, topic;
        StringBuilder myMessage = new StringBuilder();
//        myMessage.append("\t");
        for (int i = 0; i < size; i++) {

            topic_id = answers.get(i).getTopic_id();
            if (topic_id.equals(top_id) ){
                answ_id = answers.get(i).getAnsw_id();
                message = answers.get(i).getMessage();
                mes_time = answers.get(i).getMes_time();
                user_id = answers.get(i).getUser_id();
                username = Users.getUsernameByID(user_id);
                topic = Topics.getTopicTitleByID(topic_id);

                myMessage.append(topic).append(" | ").append(username).append(" | ").append(message).append(" |" +
                        " ").append(mes_time).append("\n");

            }
        }
        System.out.println(myMessage);
    }

    public static void printAllTopicsAnsw() throws SQLException {
        System.out.println("--Ответы-- \n");
        answers = main();

        int size = answers.size();
        String answ_id, topic_id, message, mes_time, user_id, username, topic;
        StringBuilder myMessage = new StringBuilder();
//        myMessage.append("\t");
        for (int i = 0; i < size; i++) {
            answ_id = answers.get(i).getAnsw_id();
            topic_id = answers.get(i).getTopic_id();
            message = answers.get(i).getMessage();
            mes_time = answers.get(i).getMes_time();
            user_id = answers.get(i).getUser_id();
            username = Users.getUsernameByID(user_id);
            topic = Topics.getTopicTitleByID(topic_id);

            myMessage.append(topic).append(" | ").append(username).append(" | ").append(message).append(" |" +
                    " ").append(mes_time).append("\n");
        }
        System.out.println(myMessage);
    }

    public static List<Answer> main() throws SQLException {
        String answ_id, topic_id, message, mes_time, user_id;
        List<String> list = DB_Utils.selectFromDB("topic_answ", "*", "");
        for (int i = 0; i < list.size(); i++) {
            answ_id = (list.get(i));
            topic_id = (list.get(i + 1));
            message = (list.get(i + 2));
            mes_time = (list.get(i + 3));
            user_id = (list.get(i + 4));
            answers.add(new Answer(answ_id, topic_id, message, mes_time, user_id));
            i += 4;
        }
        return (answers);
    }
}

class Answer {
    private final String answ_id, topic_id, message, mes_time, user_id;

    public Answer(String answ_id, String topic_id, String message, String mes_time, String user_id) {
        this.answ_id = answ_id;
        this.topic_id = topic_id;
        this.message = message;
        this.mes_time = mes_time;
        this.user_id = user_id;
    }

    public String getAnsw_id() {
        return answ_id;
    }

    public String getTopic_id() {
        return topic_id;
    }

    public String getMessage() {
        return message;
    }

    public String getMes_time() {
        return mes_time;
    }

    public String getUser_id() {
        return user_id;
    }
}


