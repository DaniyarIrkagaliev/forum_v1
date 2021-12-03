package com.company.db.repository;


import com.company.db.repository.items.Items;

import java.util.List;

public interface Repository {

    List<Items> getAll();

    void add(Items message);

    void deleteByID(Integer ind);

}
