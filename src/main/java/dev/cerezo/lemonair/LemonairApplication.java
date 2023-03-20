package dev.cerezo.lemonair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Lemonair API REST", version = "1.0.0"))
public class LemonairApplication {

	public static void main(String[] args) {
		SpringApplication.run(LemonairApplication.class, args);
	}

}
