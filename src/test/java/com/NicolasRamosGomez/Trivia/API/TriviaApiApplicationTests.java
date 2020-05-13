package com.NicolasRamosGomez.Trivia.API;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TriviaApiApplicationTests {

	@Autowired
	private QuestionsController questionsController;

	@Test
	void contextLoads() {
		assertThat(questionsController).isNotNull();
	}

}
