package com.melashvili.userend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class UserEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserEndApplication.class, args);
	}

}
