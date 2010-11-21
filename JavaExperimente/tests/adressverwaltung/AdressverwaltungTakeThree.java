package adressverwaltung;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;
import static util.AdditionalAssumes.assumeFalse;

import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class AdressverwaltungTakeThree {

	@Test
	public void assignAddressToPerson_1() {
		Person person = new Person("Bob");
		Address address = new Address("Holstenwall 12", "20355 Hamburg");

		person.assign(address);

		assertTrue(person.knows(address));
		assertEquals(1, person.numberOfAddresses());
	}

	// /////////////

	@Test
	public void assignAddressToPerson_2() {
		Person person = new Person("Bob");
		Address address = new Address("Holstenwall 12", "20355 Hamburg");

		assignAddressToPersonTmp_2(person, address);
	}

	private void assignAddressToPersonTmp_2(Person person, Address address) {
		person.assign(address);

		assertTrue(person.knows(address));
		assertEquals(1, person.numberOfAddresses());
	}

	// /////////////

	@Test
	public void assignAddressToPerson_3() {
		Person person = new Person("Bob");
		Address address = new Address("Holstenwall 12", "20355 Hamburg");

		assignAddressToPersonTmp_3(person, address);
	}

	private void assignAddressToPersonTmp_3(Person person, Address address) {
		int previousNumber = person.numberOfAddresses();

		person.assign(address);

		assertTrue(person.knows(address));
		assertEquals(previousNumber + 1, person.numberOfAddresses());
	}

	// /////////////

	@DataPoint
	public static Address address = new Address("Holstenwall 12",
			"20355 Hamburg");

	@DataPoint
	public static Person personWithoutAddresses() {
		return new Person("Bob");
	}

	@DataPoint
	public static Person personWithAnAddress() {
		Person person = new Person("Bob");
		person.assign(address);
		return person;
	}

	@Theory
	public void assignAddressToPersonTheory_1(Person person, Address address) {
		int previousNumber = person.numberOfAddresses();

		person.assign(address);

		assertTrue(person.knows(address));
		assertEquals(previousNumber + 1, person.numberOfAddresses());
	}

	// //////////////

	@Theory
	public void assignUnknownAddressToPerson(Person person, Address address) {
		assumeFalse(person.knows(address));

		int previousNumber = person.numberOfAddresses();

		person.assign(address);

		assertTrue(person.knows(address));
		assertEquals(previousNumber + 1, person.numberOfAddresses());
	}

	@Theory
	public void assignAlreadyKnownAddressToPerson(Person person, Address address) {
		assumeTrue(person.knows(address));

		int previousNumber = person.numberOfAddresses();

		person.assign(address);

		assertTrue(person.knows(address));
		assertEquals(previousNumber, person.numberOfAddresses());
	}
}
