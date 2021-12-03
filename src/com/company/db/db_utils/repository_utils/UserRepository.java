package com.company.db.db_utils.repository_utils;

import com.company.console.entity_utils.UserCreator;
import com.company.db.db_utils.database_utils.UserDataBase;
import com.company.db.repository.Users;
import com.company.db.repository.items.Items;
import com.company.db.repository.items.User;

import java.util.Scanner;

public class UserRepository implements Repository_Utiller {

    private final Scanner scan = new Scanner(System.in);
    private final UserDataBase db = UserDataBase.getINSTANCE();


    @Override
    public void add() {
        User user = UserCreator.createUser();
        Users.getINSTANCE().add(user);
        db.add(user);
    }

    @Override
    public void removeByID() {
        System.out.println("Enter id");
        int val = scan.nextInt();
        Users.getINSTANCE().deleteByID(val);
        db.removeByID(val);
    }

    public void printTable() {
        System.out.println("Users: ");
        for (Items user : Users.getINSTANCE().getAll()) {
            System.out.println(user.toString());
        }
    }

}