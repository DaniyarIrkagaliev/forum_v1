package com.company.db.repository.items;

import java.sql.ResultSet;
import java.util.Objects;

public class Message implements Items {

    protected Integer mes_id, user_id;
    protected String message, mes_time;

    public Message(int mes_id, int user_id, String message, String mes_time) {
        this.mes_id = mes_id;
        this.user_id = user_id;
        this.message = message;
        this.mes_time = mes_time;
    }

    @Override
    public Integer getID() {
        return mes_id;
    }

    //    @Override
    public boolean equels(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Message message = (Message) o;
        return Objects.equals(mes_id, message.mes_id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(mes_id);
    }

    @Override
    public String toString() {
        return "Message{" +
                "mes_id=" + mes_id +
                ", user_id='" + user_id + '\'' +
                ", message=" + message + ", mes_time =" + mes_time + '}';
    }

    public static Message getByResultSet(ResultSet rs){
        Message message1 = null;
        try {
            message1 = new Message(
                    rs.getInt("mes_id"), rs.getInt("user_id"),
                    rs.getString("message"), rs.getString("mes_time"));
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        return message1;
    }

    public int getMes_ID() {
        return mes_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getMessage() {
        return message;
    }

    public String getMes_time() {
        return mes_time;
    }

}
