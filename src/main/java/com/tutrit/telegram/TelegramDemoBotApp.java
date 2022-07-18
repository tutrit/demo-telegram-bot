package com.tutrit.telegram;

import com.tutrit.telegram.util.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TelegramDemoBotApp {
	public static final Logger LOGGER = LoggerFactory.getLogger(Mapper.class);

	public static void main(String[] args) {
		SpringApplication.run(TelegramDemoBotApp.class, args);
	}
}
