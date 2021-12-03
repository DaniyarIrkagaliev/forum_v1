package com.company.db.repository;

import com.company.db.repository.items.Items;
import com.company.db.repository.items.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Users implements Repository{

    private static List<User> users;
    private static Users INSTANCE;

    private Users() {
        users = new ArrayList<>();
    }

    public static Users getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new Users();
        }
        return INSTANCE;
    }


    @Override
    public List<Items> getAll() {
        return new ArrayList<>(users);
    }

    @Override
    public void add(Items user) {
        try {
            users.add((User) user);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void deleteByID(Integer ind) {
        try {
            users.remove(ind);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public User getByID(Integer id){
        return users.stream().filter(var -> var.getID().equals(id)).collect(Collectors.toList()).get(0);
    }
}

