package webservice.moneyback.test;


import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;
import webservice.moneyback.dao.LoanRepository;
import webservice.moneyback.entity.Loan;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LoanRepositoryTest {
		
	@Autowired
	private TestEntityManager em;
	
	@Autowired
	private LoanRepository loanRepo;
	
	@Test
	public void findByPerson_method_test() {

		
		Loan l1 = new Loan("Kasia","Marek",23,new Date(),"nothing");
		em.detach(l1);
		em.persist(l1);
		em.flush();
		
		Loan testLoan = loanRepo.findById(1);
		
		
		Assert.assertEquals(testLoan.getForwho(), "Mania");
	}

	
	

}