package com.in28minutes.spring.learn_spring_framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.in28minutes.spring.learn_spring_framework.game.GameRunner;
import com.in28minutes.spring.learn_spring_framework.game.MarioGame;
import com.in28minutes.spring.learn_spring_framework.game.SuperContraGame;
import com.in28minutes.spring.learn_spring_framework.game.enterprise.example.web.MyWebController;
import com.in28minutes.spring.learn_spring_framework.game.GamingConsole;


@SpringBootApplication
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context= SpringApplication.run(LearnSpringFrameworkApplication.class, args);
		
		
		
		// GamingConsole game = new MarioGame();

		// GameRunner runner = new GameRunner(game);
		
		GameRunner runner= context.getBean(GameRunner.class);

		
		runner.run();

		System.out.println("\nWeb Controller class");
		MyWebController webController= context.getBean(MyWebController.class);
		
		
		System.out.println(webController.returnValueFromBusinessService());

	}

}
