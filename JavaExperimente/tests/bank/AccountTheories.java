package bank;

import static java.math.BigDecimal.ZERO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

import java.math.BigDecimal;

import org.junit.Rule;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import com.pholser.junit.parameters.ForAll;

@RunWith(Theories.class)
public class AccountTheories {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	private Account account = new Account("Keith");

	@Theory
	public void placingADepositIncreasesBalance(@ForAll BigDecimal amount) {
		assumeTrue(amount.compareTo(ZERO) >= 0);
		
		account.deposit(amount);
		assertEquals(amount, account.getBalance());
	}

	@Theory
	public void negativeDepositsAreNotAllowed(@ForAll BigDecimal amount) {
		assumeTrue(amount.compareTo(ZERO) < 0);
		
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Negative deposit");
		account.deposit(amount);
	}

	@Theory
	public void withdrawingWithInsufficientBalance(@ForAll BigDecimal balance, @ForAll BigDecimal amount) {
		assumeTrue(balance.compareTo(ZERO) > 0);
		assumeTrue(amount.compareTo(balance) > 0);
		
		account.deposit(balance);
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Insufficient balance");
		account.withdraw(amount);
	}

	@Theory
	public void withdrawingDecreasesBalance(@ForAll BigDecimal balance, @ForAll BigDecimal amount) {
		assumeTrue(amount.compareTo(ZERO) > 0);
		assumeTrue(amount.compareTo(balance) <= 0);
		
		account.deposit(balance);
		account.withdraw(amount);
		assertEquals(balance.subtract(amount), account.getBalance());
	}

}
