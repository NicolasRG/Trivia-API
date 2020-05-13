package com.NicolasRamosGomez.Trivia.API;

import lombok.Data;
import lombok.NonNull;

import java.util.Date;


@Data
public class Question {
    @NonNull private int id, show_number;
    @NonNull private String category, value, question, answer, round;
    @NonNull private Date air_date;

    public Question(@NonNull int id, @NonNull int show_number, @NonNull String category, @NonNull String value, @NonNull String question, @NonNull String answer, @NonNull String round, @NonNull Date air_date) {
        this.id = id;
        this.show_number = show_number;
        this.category = category;
        this.value = value;
        this.question = question;
        this.answer = answer;
        this.round = round;
        this.air_date = air_date;
    }
     public Question(){}


}
