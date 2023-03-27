package com.digisprint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class PostgresRedisPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostgresRedisPocApplication.class, args);
	}

}
