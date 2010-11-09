package adressverwaltung;

import static adressverwaltung.AdditionalAssumes.assumeEquals;
import static adressverwaltung.AdditionalAssumes.assumeFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import java.util.Collection;

import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import com.pholser.junit.parameters.ForAll;

@RunWith(Theories.class)
public class AdressverwaltungTheoriesWithQuickCheck {

	@Theory(nullsAccepted = false)
	public void assignNewAddressToPerson(@ForAll Person person, @ForAll Address address) {
		assumeFalse(person.knows(address));
		int numberOfKnownAddresses = person.numberOfAddresses();

		person.assign(address);

		assertTrue(person.knows(address));
		assertEquals(numberOfKnownAddresses + 1, person.numberOfAddresses());
	}

	@Theory
	public void assignAlreadyKnownAddressToPerson(@ForAll Person person, @ForAll Address address) {
		assumeTrue(person.knows(address));
		int numberOfKnownAddresses = person.numberOfAddresses();

		person.assign(address);

		assertTrue(person.knows(address));
		assertEquals(numberOfKnownAddresses, person.numberOfAddresses());
	}

	@Theory
	public void assignNullAddressToPerson(@ForAll Person person) {
		int numberOfKnownAddresses = person.numberOfAddresses();

		person.assign(null);

		assertFalse(person.knows(null));
		assertEquals(numberOfKnownAddresses, person.numberOfAddresses());
	}

	@Theory
	public void deleteUnknownAddressFromPerson(@ForAll Person person, @ForAll Address address) {
		assumeFalse(person.knows(address));
		int numberOfKnownAddresses = person.numberOfAddresses();

		person.remove(address);

		assertFalse(person.knows(address));
		assertEquals(numberOfKnownAddresses, person.numberOfAddresses());
	}

	@Theory
	public void deleteKnownAddressFromPerson(@ForAll Person person, @ForAll Address address) {
		assumeTrue(person.knows(address));
		int numberOfKnownAddresses = person.numberOfAddresses();

		person.remove(address);

		assertFalse(person.knows(address));
		assertEquals(numberOfKnownAddresses - 1, person.numberOfAddresses());
	}

	@Theory
	public void displayNoAddressFromPersonWithoutAddress(@ForAll Person person) {
		assumeEquals(0, person.numberOfAddresses());

		Collection<Address> addresses = person.displayAddresses();

		assertTrue(addresses.isEmpty());
	}

	@Theory
	public void displayAddressFromPersonWithAdress(@ForAll Person person) {
		assumeTrue(person.numberOfAddresses() > 0);
		int numberOfKnownAddresses = person.numberOfAddresses();

		Collection<Address> addresses = person.displayAddresses();

		assertEquals(numberOfKnownAddresses, addresses.size());
		for (Address address : addresses) {
			assertTrue(person.knows(address));
		}
	}
}
