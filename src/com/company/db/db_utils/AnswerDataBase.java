package com.company.db.db_utils;

import com.company.db.DataBase;
import com.company.db.repository.Answer;
import com.company.db.repository.Items;
import com.company.db.repository.Message;
import com.company.utils.CurrentTime;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnswerDataBase implements DataBase_Utiller {
//" answ_id,  message, mes_time, user_id;

    private static AnswerDataBase INSTANCE;
    private static DataBase db;

    public static AnswerDataBase getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new AnswerDataBase();
            db = DataBase.getINSTANCE();
        }
        return INSTANCE;
    }

    @Override
    public void add(Items obj) {
        try {
            Answer answer = (Answer) obj;
            String currentTime = CurrentTime.getCurrentTime();
            db.executeUpdate("INSERT INTO topic_answ (topic_id, message, mes_time, user_id) VALUES('" +
                    answer.getTopic_id() + "', '" + answer.getMessage() + "', '" + currentTime + "', '"
                    + answer.getUser_id() + "'); ");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
//2022-03-03 22:00:04
    //2022-03-04 15:59:29
    @Override
    public void removeByID(Integer id) {
        db.executeUpdate("DELETE FROM topic_answ WHERE answ_id = " + id + ";");
    }

    public void removeByTopID(Integer id) {
        db.executeUpdate("DELETE FROM topic_answ WHERE topic_id = " + id + ";");
    }

    public List<Answer> getByTopId(Integer id) {
        List<Answer> items = new ArrayList<>();
        try {
            ResultSet rs = db.executSelect("SELECT * FROM topic_answ WHERE  topic_id = " + id);
            while (rs.next())
                items.add(getByResultSet(rs));
            rs.close();
            return items;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Answer> getByUserId(Integer id) {
        List<Answer> items = new ArrayList<>();
        try {
            ResultSet rs = db.executSelect("SELECT * FROM topic_answ WHERE user_id = " + id);
            while (rs.next())
                items.add(getByResultSet(rs));
            rs.close();
            return items;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Items getByID(Integer id) {
        try {
            ResultSet rs = db.executSelect("SELECT * FROM topic_answ WHERE topic_id = " + id);
            rs.next();
            Answer answer = getByResultSet(rs);
            rs.close();
            return answer;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Items> getAll() {
        List<Items> list = new ArrayList<>();
        try {
            ResultSet rs = db.executSelect("SELECT * FROM topic_answ");
            while (rs.next())
                list.add(getByResultSet(rs));
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void printTable() {
        List<Items> list = getAll();
        System.out.println("DataBase Answ:");
        for (Items answer : list) {
            System.out.println(answer.toString());
        }
    }

    public Answer getByResultSet(ResultSet rs) {
        try {
            return new Answer(
                    rs.getInt("answ_id"),
                    rs.getInt("topic_id"),
                    rs.getString("message"),
                    rs.getString("mes_time"),
                    rs.getInt("user_id")
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Answer getByResultSet");
            return null;
        }
    }

    public int getAnswCount() {
        return getAll().size();
    }

    public int getAnswCountByTop(int id) {
        return getByTopId(id).size();
    }

    public int getAnswCountByUser(int id) {
        return getByUserId(id).size();
    }
}
