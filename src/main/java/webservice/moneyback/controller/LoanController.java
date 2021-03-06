package webservice.moneyback.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import webservice.moneyback.entity.Loan;
import webservice.moneyback.entity.NewLoanInfo;
import webservice.moneyback.entity.User;
import webservice.moneyback.service.LoanService;


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class LoanController {
	
	
	private LoanService loanService;
	
	public LoanController(LoanService theLoanService) {
		loanService = theLoanService;
	}

	
	
	@GetMapping("/{username}/loans")
	public List getAllLoans(@PathVariable String username){
		System.out.println(username);
		return loanService.findByPerson(username);
	}
	
	@GetMapping("/{username}/friends")
	public List getAllFriends(@PathVariable String username){
		return loanService.findFriends(username);
	}

	
	@PutMapping("/loans/{id}")
	public ResponseEntity<Loan> updateTodo(
			@PathVariable long id, 
			@RequestBody Loan loan){
		
		loanService.save(loan);
		return new ResponseEntity<Loan>(loan,HttpStatus.OK);
		
	}
	
	@GetMapping("/loans/{id}")
	public Loan getLoan(@PathVariable int id){
		return loanService.findById(id);
	}
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return loanService.getUsers();
	}
	
	@PutMapping("/users/add")
	public ResponseEntity<User> addUser(@RequestBody User user){
		
		loanService.addUser(user);
		return new ResponseEntity<User>(user,HttpStatus.OK);
		
	}
	
	@PostMapping("/addloan")
	public ResponseEntity<NewLoanInfo> addLoan(@RequestBody NewLoanInfo loanInfo){
		
		int wholeAmount = Integer.parseInt(loanInfo.getAmount());
		Date date = new Date();
		int amountPerPerson = wholeAmount/loanInfo.getListuser().size();
				
		for(User usr: loanInfo.getListuser()) {
			Loan tempLoan = new Loan(33,loanInfo.getFromWho(),usr.getName(),amountPerPerson,date,loanInfo.getDescription());
			loanService.save(tempLoan);
		}
		
		
		return new ResponseEntity<NewLoanInfo>(loanInfo,HttpStatus.OK);
		
	}
}
