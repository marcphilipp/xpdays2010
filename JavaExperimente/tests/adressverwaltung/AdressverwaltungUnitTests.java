package adressverwaltung;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AdressverwaltungUnitTests {

	private Person personWithTwoAddresses() {
		Person personWithTwoAddresses = new Person();
		personWithTwoAddresses.assign(new Address());
		personWithTwoAddresses.assign(new Address());
		return personWithTwoAddresses;
	}

	private Person personWithoutAddresses() {
		return new Person();
	}

	@Test
	public void personWithoutAddressesDoesNotKnowAnyAddresses() {
		Person person = personWithoutAddresses();
		Address unknown = new Address();
		assertFalse(person.knows(unknown));
	}

	@Test
	public void assignNewAddressToPersonWithoutAddresses() {
		Person person = personWithoutAddresses();
		Address address = new Address();

		person.assign(address);

		assertTrue(person.knows(address));
		assertEquals(1, person.numberOfAddresses());
	}

	@Test
	public void personWithAddressOnlyKnowsItsAddress() {
		Person person = new Person();
		Address known = new Address();
		Address unknown = new Address();

		person.assign(known);

		assertTrue(person.knows(known));
		assertFalse(person.knows(unknown));
	}

	@Test
	public void personCountsItsAddresses() {
		assertEquals(0, personWithoutAddresses().numberOfAddresses());
		assertEquals(2, personWithTwoAddresses().numberOfAddresses());
	}

	@Test
	public void assignNewAddressToPersonWithAddresses() {
		Person person = personWithTwoAddresses();
		Address address = new Address();

		person.assign(address);

		assertTrue(person.knows(address));
		assertEquals(3, person.numberOfAddresses());
	}

	@Test
	public void assignAlreadyKnownAddressToPersonWithOneAddress() {
		Person person = personWithoutAddresses();
		Address address = new Address();
		person.assign(address);
		assertTrue(person.knows(address));

		person.assign(address);

		assertTrue(person.knows(address));
		assertEquals(1, person.numberOfAddresses());
	}

	@Test
	public void assignAlreadyKnownAddressToPersonWithSeveralAddresses() {
		Person person = personWithTwoAddresses();
		Address address = new Address();
		person.assign(address);
		assertTrue(person.knows(address));

		person.assign(address);

		assertTrue(person.knows(address));
		assertEquals(3, person.numberOfAddresses());
	}

	@Test
	public void assignNullAddressToPersonWithoutAddresses() {
		Person person = personWithoutAddresses();

		person.assign(null);

		assertFalse(person.knows(null));
		assertEquals(0, person.numberOfAddresses());
	}

	@Test
	public void assignNullAddressToPersonWithAddresses() {
		Person person = personWithTwoAddresses();

		person.assign(null);

		assertFalse(person.knows(null));
		assertEquals(2, person.numberOfAddresses());
	}

}
