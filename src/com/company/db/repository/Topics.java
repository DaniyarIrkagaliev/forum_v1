package com.company.db.repository;


import com.company.db.repository.items.Items;
import com.company.db.repository.items.Topic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Topics implements Repository{

    private static List<Topic> topics;
    private static Topics INSTANCE;

    private Topics() {
        topics = new ArrayList<>();
    }

    public static Topics getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new Topics();
        }
        return INSTANCE;
    }


    @Override
    public List<Items> getAll() {
        return new ArrayList<>(topics);
    }

    @Override
    public void add(Items topic) {
        try {
            topics.add((Topic) topic);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void deleteByID(Integer ind) {
        try {
            topics.remove(ind);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public Topic getByID(Integer id){
        return topics.stream().filter(var -> var.getID().equals(id)).collect(Collectors.toList()).get(0);
    }
}