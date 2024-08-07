package bank.domain;

import jakarta.persistence.*;

@Entity
public class Account {
	@Id
	@GeneratedValue
	private long id;
	private String accountNumber;

	public Account() {
	}

	public Account(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

}
