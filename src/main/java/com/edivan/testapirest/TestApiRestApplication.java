package com.edivan.testapirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.edivan.testapirest.property.FileProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileProperties.class
})
public class TestApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApiRestApplication.class, args);
	}

}
