package webservice.moneyback.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import webservice.moneyback.entity.Loan;



@Repository
public interface LoanRepository extends JpaRepository < Loan, Integer > {

	public List findAll();
	
	@Query("SELECT b FROM Loan b WHERE b.fromwho=:username or b.forwho=:username")
	List findByPerson(@Param("username") String username);
	
	@Query("SELECT SUM(b.amount) as amount, b.fromwho FROM Loan AS b  WHERE b.forwho=:username GROUP BY fromwho ")
	List findFriends(@Param("username") String username);
	
	Loan findById(int id);	
	
	
}
