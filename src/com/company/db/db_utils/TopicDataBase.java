package com.company.db.db_utils;

import com.company.db.DataBase;
import com.company.db.repository.Answer;
import com.company.db.repository.Items;
import com.company.db.repository.Topic;
import com.company.db.repository.User;
import com.company.utils.CurrentTime;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TopicDataBase implements DataBase_Utiller {
//Integer topic_id, String title, String description, String date, Integer user_id
    private static TopicDataBase INSTANCE;
    private static DataBase db;

    public static TopicDataBase getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new TopicDataBase();
            db = DataBase.getINSTANCE();
        }
        return INSTANCE;
    }

    @Override
    public void add(Items obj) {
        try {
            Topic topic = (Topic) obj;
            String currentTime = CurrentTime.getCurrentTime();
            String query = "";
            db.executeUpdate("INSERT INTO topic ( title, topic_description, topic_date, user_id) VALUES('"
                    + topic.getTitle() + "', '" + topic.getDescription() + "', '" + topic.getDate() +
                    "', '"+ topic.getUser_id() +"')");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @Override
    public void removeByID(Integer id) {
        db.executeUpdate("DELETE FROM topic WHERE topic_id = " + id + ";");
    }

    @Override
    public Items getByID(Integer id){
        return null;
    }

    public List<Topic> getByTopID(Integer id){
        List <Topic> items = new ArrayList<>();
        try {
            ResultSet rs = db.executSelect("SELECT * FROM topic WHERE topic_id=" + id);
            while (rs.next())
                items.add(getByResultSet(rs));
            rs.close();
            return items;
        }catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }

    public List<Topic> getByUserID(Integer id){
        List <Topic> items = new ArrayList<>();
        try {
            ResultSet rs = db.executSelect("SELECT * FROM topic WHERE user_id=" + id);
            while (rs.next())
                items.add(getByResultSet(rs));
            rs.close();
            return items;
        }catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Items> getAll(){
        List<Items> list = new ArrayList<>();
        try {
            ResultSet rs = db.executSelect("SELECT * FROM topic");
            while (rs.next())
                list.add(getByResultSet(rs));
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void printTable(){
        List<Items> list = getAll();
        System.out.println("DataBase topic:");
        for (Items topic : list) {
            System.out.println(topic.toString());
        }
    }

    public Topic getByResultSet(ResultSet rs) {
        try {
            return new Topic(
                    rs.getInt("topic_id"),
                    rs.getString("title"),
                    rs.getString("topic_description"),
                    rs.getString("topic_date"),
                    rs.getInt("user_id")
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Topic getByResultSet");
            return null;
        }
    }

    public int getTopCount(){
        return getAll().size();
    }
    public int getTopCountByUser(int id){
        return getByUserID(id).size();
    }
}
