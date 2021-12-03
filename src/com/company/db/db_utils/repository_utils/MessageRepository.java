package com.company.db.db_utils.repository_utils;

import com.company.console.entity_utils.MessageCreator;
import com.company.db.db_utils.database_utils.MessageDataBase;
import com.company.db.repository.Chat;
import com.company.db.repository.items.Items;
import com.company.db.repository.items.Message;

import java.util.Scanner;

public class MessageRepository implements Repository_Utiller {

    private final Scanner scan = new Scanner(System.in);
    private final MessageDataBase db = MessageDataBase.getINSTANCE();


    @Override
    public void add() {
        Message message = MessageCreator.createMessage();
        Chat.getINSTANCE().add(message);
        db.add(message);
    }

    @Override
    public void removeByID() {
        System.out.println("Enter id");
        int val = scan.nextInt();
        Chat.getINSTANCE().deleteByID(val);
        db.removeByID(val);
    }

    public void printTable() {
        System.out.println("Chat: ");
        for (Items message : Chat.getINSTANCE().getAll()) {
            System.out.println(message.toString());
        }
    }

}
