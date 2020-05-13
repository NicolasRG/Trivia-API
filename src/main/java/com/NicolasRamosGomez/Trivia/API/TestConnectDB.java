package com.NicolasRamosGomez.Trivia.API;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@Configuration
public class TestConnectDB{
    @Value("${database.url}")
    private String databaseURL;
    @Bean
    CommandLineRunner connect(){
         return args -> {
             Connection conn;
             Statement sql = null;
             try {
                 conn = DriverManager.getConnection(databaseURL);
                 sql = conn.createStatement();
                 sql.execute("USE trivia");
                 System.out.println("Connect to DB");
             }catch (Exception e){
                 System.out.println("Error");
                 e.printStackTrace();
             }

         };
    }
}
