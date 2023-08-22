package com.conneqt.channelsubscriptions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
public class ChannelsubscriptionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChannelsubscriptionsApplication.class, args);
	}

}
