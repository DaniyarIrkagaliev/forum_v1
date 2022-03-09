package com.company;

import com.company.db.db_utils.TopicDataBase;
import com.company.db.db_utils.UserDataBase;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

import static com.company.utils.Password.generatePasswordHash;

public class Main {

    public static void main(String[] args) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException {

        System.out.println(TopicDataBase.getINSTANCE().getTopCount());
        System.out.println(TopicDataBase.getINSTANCE().getTopCountByUser(11));

//        UserDataBase.getINSTANCE().printTable();
//        String pas1 = "qwerty";
//        System.out.println(generatePasswordHash(pas1));
//        pas1 = "Kazakh";
//        System.out.println(generatePasswordHash(pas1));
//        pas1 = "user";
//        System.out.println(generatePasswordHash(pas1));
//        pas1 = "kaz";
//        System.out.println(generatePasswordHash(pas1));
//        pas1= "Kazakh123";
//        System.out.println(generatePasswordHash(pas1));


    }

}
