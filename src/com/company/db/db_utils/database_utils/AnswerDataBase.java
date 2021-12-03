package com.company.db.db_utils.database_utils;

import com.company.db.repository.items.Items;

import java.sql.SQLException;
import java.util.List;

public class AnswerDataBase implements  DataBase_Utiller{
    @Override
    public void add(Items obj) {

    }

    @Override
    public void removeByID(Integer id) {

    }

    @Override
    public Items getByID(Integer id) throws SQLException {
        return null;
    }

    @Override
    public List<Items> getAll() throws SQLException {
        return null;
    }

    @Override
    public void printTable() throws SQLException {

    }
}
