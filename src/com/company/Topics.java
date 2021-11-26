package com.company;

import com.company.db.DB_Utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Topics {
    public static List<Topic> topics = new ArrayList<Topic>();


    //todo main каждого класса с бд - вынести в отдельный метод, который будет приготавливать коллекции в начале таска
    public static String getTopicTitleByID(String top_id) throws SQLException {
        main();
        String topicTitle = " ";
        for (int i = 0; i < topics.size(); i++) {
            String topi_id = topics.get(i).getUser_id();
            if (top_id.equals(topi_id)) {
                topicTitle = topics.get(i).getTitle();
                return topicTitle;
            }
        }
        return topicTitle;
    }

    public static void print_topic() throws SQLException {
        System.out.println("--Темы-- \n");

        topics = main();
        //TODO вместо user_id - username
        int size = topics.size();
        String topic_id = "", title, description, date, user_id, username;
        StringBuilder myMessage = new StringBuilder();
//        myMessage.append("\t");
        for (int i = 0; i < size; i++) {
            topic_id = topics.get(i).getTopic_id();
            title = topics.get(i).getTitle();
            description = topics.get(i).getDescription();
            date = topics.get(i).getDate();
            user_id = topics.get(i).getUser_id();
            username = Users.getUsernameByID(user_id);
            myMessage.append(topic_id).append(" | ").append(title).append(" | ").append(description).append(" | ").append(date).append("" +
                    " | Автор: \t").append(username).append("\n");
        }
        System.out.println(myMessage);
    }

    public static List<Topic> main() throws SQLException {
        String topic_id = "", title = "", description = "", date = "", user_id = "";
        List<String> list = DB_Utils.selectFromDB("topic", "*", "");
        for (int i = 0; i < list.size(); i++) {
            topic_id = (list.get(i));
            title = (list.get(i + 1));
            description = (list.get(i + 2));
            date = (list.get(i + 3));
            user_id = (list.get(i + 4));
            topics.add(new Topic(topic_id, title, description, date, user_id));
            i += 4;
        }
        return (topics);
    }
}

class Topic {
    private final String topic_id, title, description, date, user_id;

    public Topic(String topic_id, String title, String description, String date, String user_id) {
        this.topic_id = topic_id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.user_id = user_id;
    }
    public String getTopic_id() {
        return topic_id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getUser_id() {
        return user_id;
    }
}
