package webservice.moneyback.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import webservice.moneyback.aspects.GetRequest;
import webservice.moneyback.dao.LoanRepository;
import webservice.moneyback.dao.UserRepository;
import webservice.moneyback.entity.Loan;
import webservice.moneyback.entity.User;


@Service
@Component
public class LoanServiceImpl implements LoanService {

	@Autowired
	private LoanRepository loanRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	 public List findAll() {
		
		return loanRepository.findAll();

	}

	@Override
	public void save(Loan theLoan) {
		
		loanRepository.save(theLoan);
		
	}

	@Override
	public List findByPerson(String username) {
		return loanRepository.findByPerson(username);
	}

	@Override
	public List findFriends(String username) {
		return loanRepository.findFriends(username);
	}

	@Override
	@GetRequest
	public Loan findById(int id) {
		return loanRepository.findById(id);
	}

	@Override
	@GetRequest
	@Cacheable(cacheNames="getUsers")
	public List getUsers() {
	return userRepository.findAll();
	}

	@Override
	public void addUser(User theUser) {
		userRepository.save(theUser);
		
	}
}
