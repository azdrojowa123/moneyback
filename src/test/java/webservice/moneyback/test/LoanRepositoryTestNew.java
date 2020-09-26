package webservice.moneyback.test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.h2.tools.Server;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import webservice.moneyback.dao.LoanRepository;



@DataJpaTest
public class LoanRepositoryTestNew {
		
	@Autowired
	private LoanRepository repo;
	
	@Test
	public void testFindAll() {
		
		List items = repo.findAll();
		assertEquals(1,items.size());
		
	}

}
