package com.example;

import com.example.config.JerseyConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


@EnableAutoConfiguration
@SpringBootApplication
public class OAuth2ResourceServer {

	public static void main(String[] args) {

		new SpringApplicationBuilder(OAuth2ResourceServer.class).run(args);
	}


}


