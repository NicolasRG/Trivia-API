package com.NicolasRamosGomez.Trivia.API;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class QuestionList {
    private List<Question> questions;

    public QuestionList(){
        questions = new ArrayList<>();
    }

    public void addQuestion(Question question){
        this.questions.add(question);
    }

    public void deleteQuestion(int id){
        this.questions.removeIf( question -> {
           return question.getId() == id;
        });
    }


}
