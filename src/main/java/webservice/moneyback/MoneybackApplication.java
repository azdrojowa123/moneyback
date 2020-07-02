package webservice.moneyback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"webservice.moneyback"})
public class MoneybackApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoneybackApplication.class, args);
	}

}
