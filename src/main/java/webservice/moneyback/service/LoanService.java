package webservice.moneyback.service;

import java.util.List;
import java.util.Optional;

import webservice.moneyback.entity.Loan;
import webservice.moneyback.entity.User;

public interface LoanService {
	
	
	public List<Loan> findAll();
	public void save(Loan theLoan);
	List findByPerson(String username);
	List findFriends(String username);
	public Loan findById(int id);
	List getUsers();
	public void addUser(User theUser);

}
