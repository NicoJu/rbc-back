package com.example.rbc;

import com.example.rbc.web.model.Robot;
import com.example.rbc.web.model.RobotRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class RbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(RbcApplication.class, args);
	}

	@Bean
	ApplicationRunner init(RobotRepository repository) {
		return args -> {
			Stream.of("R2D2", "Le T-800", "Hal-9000", "C-3PO", "Robocop",
					"Goldorak", "Wall-E", "Nono", "Optimus Prime").forEach(name -> {
				Robot robot = new Robot();
				robot.setName(name);
				robot.setPrice(1.0);
				repository.save(robot)
				;
			});

			repository.findAll().forEach(System.out::println);
		};
	}

}
