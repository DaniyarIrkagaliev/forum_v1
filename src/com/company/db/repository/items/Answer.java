package com.company.db.repository.items;

import java.sql.ResultSet;
import java.util.Objects;

public class Answer implements Items {
    protected Integer answ_id,topic_id, user_id;
    private final String  message, mes_time;

    public Answer(Integer answ_id, Integer topic_id, String message, String mes_time, Integer user_id) {
        this.answ_id = answ_id;
        this.topic_id = topic_id;
        this.message = message;
        this.mes_time = mes_time;
        this.user_id = user_id;
    }


    public boolean equels(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Answer answer = (Answer) o;
        return Objects.equals(answ_id, answer.answ_id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(answ_id);
    }

    @Override
    public String toString() {
        return "Answer{" +
                ", answ_id='" + answ_id + ", topic_id='" + topic_id +", message='" + message +
                ", mes_time='" + mes_time + ", user_id='" + user_id +'}';
    }

    public static Answer getByResultSet(ResultSet rs){
        Answer answer1 = null;
        try {
            answer1 = new Answer(
                    rs.getInt("answ_id"), rs.getInt("topic_id"),
                    rs.getString("message"), rs.getString("mes_time"), rs.getInt("user_id"));
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        return answer1;
    }



    @Override
    public Integer getID() {
        return answ_id;
    }
    public Integer getTopic_id() {
        return topic_id;
    }

    public String getMessage() {
        return message;
    }

    public String getMes_time() {
        return mes_time;
    }

    public Integer getUser_id() {
        return user_id;
    }


}
