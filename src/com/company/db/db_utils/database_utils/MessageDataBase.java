package com.company.db.db_utils.database_utils;

import com.company.db.DataBase;
import com.company.db.repository.items.Items;
import com.company.db.repository.items.Message;
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
        }
        return INSTANCE;
    }

    @Override
    public void add(Items obj) {
        try {
            Message message = (Message) obj;
            String currentTime = CurrentTime.getCurrentTime();
            String query = "INSERT INTO chat (mes_id,  user_id, message, mes_time) VALUES";
            db.executSelect(query + " (" + message.getID() + " '" + message.getUser_id() + "', '" + message.getMessage() + "', '" +
                    "" + currentTime + "'); ");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void removeByID(Integer id) {
        String query = "DELETE FROM chat WHERE mes_id = ";
        db.executSelect(query + id + ";");
    }

    @Override
    public Items getByID(Integer id) throws SQLException {
        String query = "SELECT * FROM chat WHERE mes_id = ";
        ResultSet rs = db.executSelect(query + id + ";");
        return new Message(rs.getInt("mes_id"), rs.getInt("user_id"),
                rs.getString("message"), rs.getString("mes_time"));
    }


    @Override
    public List<Items> getAll() throws SQLException {
        List<Items> list = new ArrayList<>();
        String query = "SELECT * FROM chat";
        ResultSet rs = db.executSelect(query);
        while (rs.next()) {
            Message message = Message.getByResultSet(rs);
            list.add(message);
        }
        return list;
    }

    @Override
    public void printTable() throws SQLException {
        List<Items> list = getAll();
        System.out.println("Chat table: ");
        for (Items message : list) {
            System.out.println(message.toString());
        }
    }

}
