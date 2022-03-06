package com.company;

import com.company.db.db_utils.UserDataBase;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        UserDataBase.getINSTANCE().printTable();
    }

}
