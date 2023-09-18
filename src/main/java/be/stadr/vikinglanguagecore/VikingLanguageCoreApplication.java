package be.stadr.vikinglanguagecore;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"be.stadr.vikinglanguagecore.rest_api"})
public class VikingLanguageCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(VikingLanguageCoreApplication.class, args);
	}

}
