package adressverwaltung;

import static util.AdditionalAssumes.assumeEquals;
import static util.AdditionalAssumes.assumeFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import java.util.Collection;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class AdressverwaltungTheories {

	@DataPoint
	public static Person personWithOneAddress() {
		Person person = new Person("Bob");
		person.assign(address1);
		return person;
	}

	@DataPoint
	public static Person personWithAllAddresses() {
		Person person = new Person("Bob");
		person.assign(address1);
		person.assign(address2);
		person.assign(address3);
		person.assign(address4);
		return person;
	}

	@DataPoint
	public static Person personWithoutAddress() {
		return new Person("Bob");
	}

	@DataPoint
	public static Address address1 = new Address("Holstenwall 12", "20355 Hamburg");

	@DataPoint
	public static Address address2 = new Address("Holstenwall 12", "20355 Hamburg");

	@DataPoint
	public static Address address3 = null;

	@DataPoint
	public static Address address4 = address1;

	@Theory(nullsAccepted = false)
	public void assignNewAddressToPerson(Person person, Address address) {
		assumeFalse(person.knows(address));
		int numberOfKnownAddresses = person.numberOfAddresses();

		person.assign(address);

		assertTrue(person.knows(address));
		assertEquals(numberOfKnownAddresses + 1, person.numberOfAddresses());
	}

	@Theory
	public void assignAlreadyKnownAddressToPerson(Person person, Address address) {
		assumeTrue(person.knows(address));
		int numberOfKnownAddresses = person.numberOfAddresses();

		person.assign(address);

		assertTrue(person.knows(address));
		assertEquals(numberOfKnownAddresses, person.numberOfAddresses());
	}

	@Theory
	public void assignNullAddressToPerson(Person person) {
		int numberOfKnownAddresses = person.numberOfAddresses();

		person.assign(null);

		assertFalse(person.knows(null));
		assertEquals(numberOfKnownAddresses, person.numberOfAddresses());
	}

	@Theory
	public void deleteUnknownAddressFromPerson(Person person, Address address) {
		assumeFalse(person.knows(address));
		int numberOfKnownAddresses = person.numberOfAddresses();

		person.remove(address);

		assertFalse(person.knows(address));
		assertEquals(numberOfKnownAddresses, person.numberOfAddresses());
	}

	@Theory
	public void deleteKnownAddressFromPerson(Person person, Address address) {
		assumeTrue(person.knows(address));
		int numberOfKnownAddresses = person.numberOfAddresses();

		person.remove(address);

		assertFalse(person.knows(address));
		assertEquals(numberOfKnownAddresses - 1, person.numberOfAddresses());
	}

	@Theory
	public void displayNoAddressFromPersonWithoutAddress(Person person) {
		assumeEquals(0, person.numberOfAddresses());

		Collection<Address> addresses = person.displayAddresses();

		assertTrue(addresses.isEmpty());
	}

	@Theory
	public void displayAddressFromPersonWithAdress(Person person) {
		assumeTrue(person.numberOfAddresses() > 0);
		int numberOfKnownAddresses = person.numberOfAddresses();

		Collection<Address> addresses = person.displayAddresses();

		assertEquals(numberOfKnownAddresses, addresses.size());
		for (Address address : addresses) {
			assertTrue(person.knows(address));
		}
	}

}
