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

public class MessageDataBase implements DataBase_Utiller {

    //mes_id, user_id, message, mes_time

    private static MessageDataBase INSTANCE;
    private static DataBase db;

    public static MessageDataBase getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new MessageDataBase();
            db = DataBase.getINSTANCE();
        }
        return INSTANCE;
    }

    @Override
    public void add(Items obj) {
        try {
            Message message = (Message) obj;
            String currentTime = CurrentTime.getCurrentTime();
            db.executeUpdate("INSERT INTO chat (mes_id,  user_id, message, mes_time) VALUES('"
                    + message.getUser_id() + "', '" + message.getMessage() + "', '" + currentTime + "')");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void removeByID(Integer id) {
        String query = "DELETE FROM chat WHERE mes_id = ";
        db.executeUpdate(query + id + ";");
    }

    @Override
    public Message getByID(Integer id) {
        try {
            ResultSet rs = db.executSelect("SELECT * FROM chat WHERE mes_id =" + id);
            rs.next();
            Message message = getByResultSet(rs);
            rs.close();
            return message;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Items> getAll(){
        List<Items> list = new ArrayList<>();
        try {
            ResultSet rs = db.executSelect("SELECT * FROM chat");
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
        System.out.println("Chat table: ");
        for (Items message : list) {
            System.out.println(message.toString());
        }
    }

//    @Override
    public Message getByResultSet(ResultSet rs) {
        try {
            return new Message(
                    rs.getInt("mes_id"),
                    rs.getInt("user_id"),
                    rs.getString("message"),
                    rs.getString("mes_time")
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(" Message getByResultSet");
            return null;
        }
    }

}
