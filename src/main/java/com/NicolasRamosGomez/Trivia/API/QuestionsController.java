package com.NicolasRamosGomez.Trivia.API;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class QuestionsController {

    @Value("${database.url}")
    private String databaseURL;

    QuestionsController(){}

    /**
     * Generates a random id and returns the associated
     * @return
     */
    @GetMapping("/randomQuestion")
    Question generateRandomQuestion(){
        //generate thread safe random num
        String randomId = ThreadLocalRandom.current().nextInt(0,197706)+"";
        String query =
                "SELECT * FROM questions WHERE id="+randomId+";";
        Question question = null;
        // can throw SQL exception
        try {
            //create connection
            Connection conn = DriverManager.getConnection(databaseURL);
            Statement statement = conn.createStatement();
            statement.execute("USE trivia");//always use trivia database
            ResultSet resultset = statement.executeQuery(query);

            //create question Object
            while (resultset.next()){
                int id = resultset.getInt("id");
                int show_number = resultset.getInt("show_number");
                String category = resultset.getString("category");
                String value = resultset.getString("value");
                String question1 = resultset.getString("question");
                String answer = resultset.getString("answer");
                String round = resultset.getString("round");
                Date date = resultset.getDate("air_date");

                question = new Question(id, show_number, category, value, question1, answer, round, date);
            }




        }catch (Exception e){
            System.out.println("Error in  random Question request");
            e.printStackTrace();
            question = new Question();
        }

    return question;
    }

    @GetMapping("/Question/{id}")
    Question getQuestionByID(@PathVariable int id){
        String query =
                "SELECT * FROM questions WHERE id="+id+";";
        Question question = null;
        // can throw SQL exception
        try {
            //create connection
            Connection conn = DriverManager.getConnection(databaseURL);
            Statement statement = conn.createStatement();
            statement.execute("USE trivia");//always use trivia database
            ResultSet resultset = statement.executeQuery(query);

            //create question Object
            while (resultset.next()){
                id = resultset.getInt("id");
                int show_number = resultset.getInt("show_number");
                String category = resultset.getString("category");
                String value = resultset.getString("value");
                String question1 = resultset.getString("question");
                String answer = resultset.getString("answer");
                String round = resultset.getString("round");
                Date date = resultset.getDate("air_date");

                question = new Question(id, show_number, category, value, question1, answer, round, date);
            }




        }catch (Exception e){
            System.out.println("Error in  getting {id : " + id + "} Question request");
            e.printStackTrace();
            question = new Question();
        }
        return question;
    }


}
