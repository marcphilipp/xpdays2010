package adressverwaltung;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AdressverwaltungTest {

	@Test
	public void assignAddressToPerson() {
		Person bob = new Person("Bob");
		Address hamburg = new Address("Holstenwall 12", "20355 Hamburg");

		bob.assign(hamburg);

		assertTrue(bob.knows(hamburg));
		assertEquals(1, bob.numberOfAddresses());
	}
}
