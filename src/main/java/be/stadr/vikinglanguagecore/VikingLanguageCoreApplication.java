package be.stadr.vikinglanguagecore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"be.stadr.vikinglanguagecore.rest_api", "be.stadr.vikinglanguagecore.service",
		"be.stadr.vikinglanguagecore.persist"})
public class VikingLanguageCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(VikingLanguageCoreApplication.class, args);
	}

}
