package bank;

import static java.math.BigDecimal.ZERO;

import java.math.BigDecimal;

public class Account {

	private final String customer;
	private BigDecimal balance = ZERO;

	public Account(String customer) {
		this.customer = customer;
	}

	public String getCustomer() {
		return customer;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void deposit(BigDecimal amount) {
		if (amount.compareTo(ZERO) < 0) {
			throw new IllegalArgumentException("Negative deposits are not allowed: " + amount);
		}
		balance = balance.add(amount);
	}

	public void withdraw(BigDecimal amount) {
		if (amount.compareTo(balance) > 0) {
			throw new IllegalArgumentException("Insufficient balance");
		}
		balance = balance.subtract(amount);
	}

}
