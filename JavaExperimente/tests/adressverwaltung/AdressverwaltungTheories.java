package adressverwaltung;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;
import static util.AdditionalAssumes.assumeFalse;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class AdressverwaltungTheories {

	@DataPoint
	public static Person bob() {
		return new Person("Bob");
	}

	@DataPoint
	public static Person alice() {
		Person person = new Person("Alice");
		person.assign(hamburg);
		return person;
	}

	@DataPoint
	public static Address hamburg = new Address("Holstenwall 12", "20355 Hamburg");

	@DataPoint
	public static Address karlsruhe = new Address("Kaiserstr. 1", "76133 Karlsruhe");

	@Theory
	public void assignUnknownAddressToPerson(Person person, Address address) {
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

		assertEquals(numberOfKnownAddresses, person.numberOfAddresses());
	}
}
