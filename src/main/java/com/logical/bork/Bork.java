package com.logical.bork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.logical.bork.configuration.Configuration;

@SpringBootApplication
@EnableConfigurationProperties(Configuration.class)
public class Bork {

	public static void main(String[] args) {
		SpringApplication.run(Bork.class, args);
	}
}
