package webservice.moneyback.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EntityScan("webservice.moneyback")
public class MoneybackApplication {
	
	@Test
	void contextLoads() {
	}

}
