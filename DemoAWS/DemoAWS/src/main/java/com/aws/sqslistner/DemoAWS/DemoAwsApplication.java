package com.aws.sqslistner.DemoAWS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;

@SpringBootApplication
public class DemoAwsApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoAwsApplication.class, args);

	}

}
