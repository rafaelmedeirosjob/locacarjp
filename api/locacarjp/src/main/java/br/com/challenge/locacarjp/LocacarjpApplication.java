package br.com.challenge.locacarjp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableSpringDataWebSupport
public class LocacarjpApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocacarjpApplication.class, args);
	}

}
