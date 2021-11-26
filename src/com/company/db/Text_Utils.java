package com.company.db;

public class Text_Utils {

    public static final String TEXT_START = "\nЧто хотите выбрать? \n" +
            "1: Вставить \n" +
            "2: Изменить\n" +
            "3: Удалить\n" +
            "4: Вывести\n" +
            "5: Выйти из программы";

    public static final String TEXT_TABLE = "Имеющиеся таблицы:\n" +
            " \t   chat   |   users  |  topic  |  topic_ans";

    public static final String TEXT_CHAT = "user_id, message, mes_time";
    public static final String TEXT_USERS = "login, username, pass ";
    public static final String TEXT_TOPIC = "title, topic_description, topic_date, user_id ";
    public static final String TEXT_TOPIC_ANSW = "topic_id, message, mes_time, user_id ";

}
