package com.company.db.repository;

import com.company.db.repository.items.Message;
import com.company.db.repository.items.Items;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Chat implements Repository{

    private static List<Message> messages;
    private static Chat INSTANCE;

    private Chat() {
        messages = new ArrayList<>();
    }

    public static Chat getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new Chat();
        }
        return INSTANCE;
    }

    @Override
    public List<Items> getAll() {
        return new ArrayList<>(messages);
    }

    @Override
    public void add(Items message) {
        try {
            messages.add((Message) message);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void deleteByID(Integer ind) {
        try {
            messages.remove(ind);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public Message getByID(Integer id){
        return messages.stream().filter(var -> var.getID().equals(id)).collect(Collectors.toList()).get(0);
    }
}