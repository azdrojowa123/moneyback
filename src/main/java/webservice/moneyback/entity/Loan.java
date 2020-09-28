package webservice.moneyback.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loans")
public class Loan {

	public Loan() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="from_who")
	private String fromwho;
	
	@Column(name="for_who")
	private String forwho;
	
	@Column(name="how_much")
	private int amount;
	
	@Column(name="date_loan")
	private Date targetDate;
	
	@Column(name="description")
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFromwho() {
		return fromwho;
	}

	public void setFromwho(String fromwho) {
		this.fromwho = fromwho;
	}

	public String getForwho() {
		return forwho;
	}

	public void setForwho(String forwho) {
		this.forwho = forwho;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Loan [id=" + id + ", fromwho=" + fromwho + ", forwho=" + forwho + ", amount=" + amount + ", targetDate="
				+ targetDate + ", description=" + description + "]";
	}

	public Loan(int id, String fromwho, String forwho, int amount, Date targetDate, String description) {
		super();
		this.id = id;
		this.fromwho = fromwho;
		this.forwho = forwho;
		this.amount = amount;
		this.targetDate = targetDate;
		this.description = description;
	}
	
	
}
