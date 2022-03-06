package com.company.db.db_utils;

import com.company.db.repository.Answer;
import com.company.db.repository.Items;

import java.sql.SQLException;
import java.util.List;

public interface DataBase_Utiller {

    void add(Items obj);

    void removeByID(Integer id);

    Items getByID(Integer id) throws SQLException;

    List<Items> getAll() throws SQLException;

    void printTable() throws SQLException;
}
