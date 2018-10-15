package org.exercise.basiclibrary.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages= {
	"org.exercise.basiclibrary.controller"})
@EntityScan({"org.basiclibrary.db.hibernate"}) 
@EnableJpaRepositories(basePackages = {"org.basiclibrary.db.repository"})
public class BasicLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicLibraryApplication.class, args);
	}
}
