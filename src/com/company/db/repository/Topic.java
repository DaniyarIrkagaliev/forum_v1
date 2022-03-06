package com.company.db.repository;

import java.sql.ResultSet;
import java.util.Objects;

public class Topic implements Items {

    protected Integer topic_id, user_id;
    private final String title, description, date;

    public Topic(Integer topic_id, String title, String description, String date, Integer user_id) {
        this.topic_id = topic_id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.user_id = user_id;
    }


//    @Override
    public boolean equels(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Topic topic = (Topic) o;
        return Objects.equals(topic_id, topic.topic_id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(topic_id);
    }

    @Override
    public String toString() {
        return "Topic{" +
                " topic_id = '" + user_id + ", title = " + title + ", description = " + description +
                ", date = " + date +", user_id = '" + user_id +'}';
    }

    public static Topic getByResultSet(ResultSet rs){
        Topic topic1 = null;
        try {
            topic1 = new Topic(
                    rs.getInt("topic_id"), rs.getString("title"), rs.getString("description"),
                    rs.getString("date"), rs.getInt("user_id"));
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        return topic1;
    }

    @Override
    public Integer getID() {
        return topic_id;
    }

    public Integer getUser_id() {
        return user_id;
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
}
