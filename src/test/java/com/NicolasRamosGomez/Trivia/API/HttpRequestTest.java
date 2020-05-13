package com.NicolasRamosGomez.Trivia.API;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.sql.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getRandomQuestion() throws Exception{
        assertThat(this.restTemplate.getForObject("http://localhost:" + port +"/randomQuestion", Question.class)).hasNoNullFieldsOrProperties();
    }

    @Test
    public void getQuestion() throws Exception{
        //create correct answer
        Long time  = 1104469200000L;
        final Question answer = new Question(2, 4680,
                "ESPNs TOP 10 ALL-TIME ATHLETES",
                "$200",
                "No. 2: 1912 Olympian; football star at Carlisle Indian School; 6 MLB seasons with the Reds, Giants & Braves",
                "Jim Thorpe",
                "Jeaopardy",
                new Date(time));
        //Create request and Question object
        Question question = this.restTemplate.getForObject("http://localhost:" + port +"/Question/2", Question.class);

        assertThat(question).as("Check question 2" ).isEqualTo(answer);
    }

}
