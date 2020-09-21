package webservice.moneyback.test;


import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import junit.framework.Assert;
import webservice.moneyback.dao.LoanRepository;
import webservice.moneyback.entity.Loan;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureDataJpa
@Transactional
public class LoanRepositoryTest {
		
	
	@Autowired
	private LoanRepository loanRepo;
	
	@Test
	public void findByPerson_method_test() {

		
		Loan l1 = new Loan(1,"Kasia","Marek",23,new Date(),"description21");
		//entityManager.persist(l1);
		//entityManager.flush();
		loanRepo.save(l1);
		
		Loan testLoan = loanRepo.findById(2);
		/*
		assertThat(testLoan.getForwho())
		.isEqualTo(l1.getForwho());*/
		
		Assert.assertEquals(testLoan.getForwho(), "Mania");
	}

	
	

}