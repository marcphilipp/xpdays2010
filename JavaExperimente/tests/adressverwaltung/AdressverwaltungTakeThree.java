package adressverwaltung;

import static adressverwaltung.AdditionalAssumes.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class AdressverwaltungTakeThree {

	@Test
	public void assignAddressToPerson_1() {
		Person person = new Person();
		Address address = new Address();

		person.assign(address);
		
		assertTrue(person.knows(address));
		assertEquals(1, person.numberOfAddresses());
	}

	// /////////////

	@Test
	public void assignAddressToPerson_2() {
		Person person = new Person();
		Address address = new Address();

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
		Person person = new Person();
		Address address = new Address();

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
	public static Address address1 = new Address();

	@DataPoint
	public static Person personWithoutAddresses() {
		return new Person();
	}

	@DataPoint
	public static Person personWithAnAddress() {
		Person person = new Person();
		person.assign(address1);
		return person;
	}

	@Theory
	public void assignAddressToPersonTheory_1(Person person, Address address) {
		int previousNumber = person.numberOfAddresses();
		
		person.assign(address);

		assertTrue(person.knows(address));
		assertEquals(previousNumber + 1, person.numberOfAddresses());
	}
	
	////////////////

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
