package model.entities;

import model.exceptions.DomainException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;

	public Account() {
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		if (balance < 0.0) {
			throw new DomainException("Withdraw error: The inicial balance do not negative number");
		}
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public void deposit(Double amount) {
		balance += amount;
	}

	public void withdraw(Double amount) {
		if (amount > withdrawLimit) {
			throw new DomainException("withdraw error: The amount exceeds withdraw limit" );
		}
		if (amount > getBalance()) {
			throw new DomainException("Withdraw error: Not enough balance");
		}
		if (amount < 0.0) {
			throw new DomainException("Withdraw error: The amount do not negative number");
		}
		balance -= amount;
	}

	@Override
	public String toString() {
		return "New Balance: " + String.format("%.2f", getBalance());
	}

}
