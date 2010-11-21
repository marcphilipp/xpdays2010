package adressverwaltung;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AdressverwaltungTestgetrieben {

	@Test
	public void newPersonHasNoAddresses() {
		assertEquals(0, new Person("Bob").numberOfAddresses());
	}

	@Test
	public void personWithoutAddressesDoesNotKnowAnyAddresses() {
		Person person = new Person("Bob");
		Address unknown = new Address("Holstenwall 12", "20355 Hamburg");
		assertFalse(person.knows(unknown));
	}

	@Test
	public void assignAddressToPerson() {
		Person person = new Person("Bob");
		Address address = new Address("Holstenwall 12", "20355 Hamburg");
		
		person.assign(address);

		assertTrue(person.knows(address));
		assertEquals(1, person.numberOfAddresses());
	}

	@Test
	public void assigningNullAddressHasNoEffect() {
		Person person = new Person("Bob");

		person.assign(null);

		assertFalse(person.knows(null));
		assertEquals(0, person.numberOfAddresses());
	}

	@Test
	public void addressIsOnlyAddedOnce() {
		Person person = new Person("Bob");

		Address address = new Address("Holstenwall 12", "20355 Hamburg");
		person.assign(address);
		person.assign(address);

		assertEquals(1, person.numberOfAddresses());
	}

	// /////////////////

	@Test
	public void assignSeveralAddressesToPerson() {
		Person person = new Person("Bob");
		person.assign(new Address("Holstenwall 12", "20355 Hamburg"));
		person.assign(new Address("Holstenwall 12", "20355 Hamburg"));
		assertEquals(2, person.numberOfAddresses());
	}

}
