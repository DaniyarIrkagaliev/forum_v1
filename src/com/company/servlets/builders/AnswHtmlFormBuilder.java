package com.company.servlets.builders;

public class AnswHtmlFormBuilder {

    public static String getForm(int top_id) {
        //topic_id;  message; mes_time; user_id;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<input type=\"message\" name=\"message\" placeholder=\"Message\" required><br>");
        return stringBuilder.toString();
    }
}
