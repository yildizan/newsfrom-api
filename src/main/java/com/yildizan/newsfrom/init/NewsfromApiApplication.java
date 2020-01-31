package com.yildizan.newsfrom.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.yildizan.newsfrom.controller"})
@EntityScan({"com.yildizan.newsfrom.entity"})
@EnableJpaRepositories({"com.yildizan.newsfrom.repository"})
public class NewsfromApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsfromApiApplication.class, args);
	}

}
