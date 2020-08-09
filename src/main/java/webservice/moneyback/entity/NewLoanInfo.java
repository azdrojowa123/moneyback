package webservice.moneyback.entity;

import java.util.List;



public class NewLoanInfo {

	List<User> listuser;
	String amount;
	String fromWho;
	String description;
	
	
	public NewLoanInfo(List<User> listuser, String amount, String fromWho, String description) {
		super();
		this.listuser = listuser;
		this.amount = amount;
		this.fromWho = fromWho;
		this.description = description;
	}


	
	public NewLoanInfo() {}
	
	@Override
	public String toString() {
		return "NewLoanInfo [listuser=" + listuser + ", amount=" + amount + ", fromWho=" + fromWho + ", description="
				+ description + "]";
	}




	public List<User> getListuser() {
		return listuser;
	}


	public void setListuser(List<User> listuser) {
		this.listuser = listuser;
	}


	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}


	public String getFromWho() {
		return fromWho;
	}


	public void setFromWho(String fromWho) {
		this.fromWho = fromWho;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
}
