package com.company.servlets.builders;

public class TopHtmlFormBuilder {

    public static String getForm() {
        // topic_id; title; description; date; user_id;
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("<input type=\"title\" name=\"title\" placeholder=\"title\" required><br>");
        stringBuilder.append("<input type=\"description\" name=\"description\" placeholder=\"Description\" required><br>");
        return stringBuilder.toString();
    }
}
