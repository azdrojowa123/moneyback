package webservice.moneyback.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import webservice.moneyback.dao.LoanRepository;
import webservice.moneyback.entity.Loan;
import webservice.moneyback.service.LoanServiceImpl;

@ExtendWith(MockitoExtension.class)
class LoanServiceTestMock {
	
	@InjectMocks
	LoanServiceImpl service = new LoanServiceImpl();
	
	@Mock
	LoanRepository repo ;

	@Test
	void findByPerson_test() {
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		
		when(repo.findByPerson(captor.capture())).thenReturn(
				Arrays.asList(new Loan(1,"Ola","Kamil",130,new Date(),"description")
				));
		
				
		List<Loan> result = service.findByPerson("Kamil");
		
		assertThat(result.get(0).getForwho()).isEqualTo("Kamil");
		
		
	}
	

}
