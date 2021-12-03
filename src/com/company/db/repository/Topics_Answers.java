package com.company.db.repository;

import com.company.db.repository.items.Answer;
import com.company.db.repository.items.Items;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Topics_Answers implements Repository{

    private static List<Answer> answers;
    private static Topics_Answers INSTANCE;

    private Topics_Answers() {
        answers = new ArrayList<>();
    }

    public static Topics_Answers getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new Topics_Answers();
        }
        return INSTANCE;
    }


    @Override
    public List<Items> getAll() {
        return new ArrayList<>(answers);
    }

    @Override
    public void add(Items answer) {
        try {
            answers.add((Answer) answer);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void deleteByID(Integer ind) {
        try {
            answers.remove(ind);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public Answer getByID(Integer id){
        return answers.stream().filter(var -> var.getID().equals(id)).collect(Collectors.toList()).get(0);
    }
}



