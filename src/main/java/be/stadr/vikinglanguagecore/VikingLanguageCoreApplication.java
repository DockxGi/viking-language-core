package be.stadr.vikinglanguagecore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"be.stadr.vikinglanguagecore.rest_api"})
public class VikingLanguageCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(VikingLanguageCoreApplication.class, args);
	}

}
