package com.musicx.musicx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.server.context.WebServerApplicationContext;
import org.springframework.context.event.EventListener;
// import org.springframework.web.bind.annotation.RestController;

// import com.musicx.musicx.controllers.auth;

@SpringBootApplication
public class MusicxApplication{

	private static final Logger logger = LoggerFactory.getLogger(MusicxApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(MusicxApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void logServerPort(ApplicationReadyEvent event) {
		if (event.getApplicationContext() instanceof WebServerApplicationContext context) {
			logger.info("MusicX started on port {}", context.getWebServer().getPort());
		}
	}

}
