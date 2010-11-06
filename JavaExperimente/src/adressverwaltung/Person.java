package adressverwaltung;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Person {

	private Set<Address> addresses = new HashSet<Address>();

	public boolean knows(Address address) {
		return addresses.contains(address);
	}

	public void assign(Address address) {
		if (address != null) {
			addresses.add(address);
		}
	}

	public int numberOfAddresses() {
		return addresses.size();
	}

	public void remove(Address address) {
		addresses.remove(address);
	}

	public Collection<Address> displayAddresses() {
		return Collections.unmodifiableSet(addresses);
	}

}
