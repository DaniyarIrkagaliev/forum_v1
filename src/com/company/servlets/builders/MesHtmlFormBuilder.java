package com.company.servlets.builders;

public class MesHtmlFormBuilder {

    public static String getForm() {
        // mes_id; user_id; message; mes_time;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<input type=\"chat_message\" name=\"chat_message\" placeholder=\"Chat_message\" required><br>");
        return stringBuilder.toString();
    }
}
