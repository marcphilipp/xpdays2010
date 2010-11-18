package adressverwaltung;

import static util.AdditionalAssumes.assumeFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import com.pholser.junit.parameters.ForAll;

@RunWith(Theories.class)
public class AdressverwaltungTheoriesWithQuickCheck {

	@Theory // (nullsAccepted = false)
	public void assignUnknownAddressToPerson(@ForAll Person person, @ForAll Address address) {
		assumeFalse(person.knows(address));

		int previousNumber = person.numberOfAddresses();

		person.assign(address);

		assertTrue(person.knows(address));
		assertEquals(previousNumber + 1, person.numberOfAddresses());
	}

	@Theory
	public void assignAlreadyKnownAddressToPerson(@ForAll Person person, @ForAll Address address) {
		assumeTrue(person.knows(address));

		int previousNumber = person.numberOfAddresses();

		person.assign(address);

		assertTrue(person.knows(address));
		assertEquals(previousNumber, person.numberOfAddresses());
	}
}
