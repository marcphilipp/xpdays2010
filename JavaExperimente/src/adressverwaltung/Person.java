package adressverwaltung;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Person {

	private final Set<Address> addresses = new HashSet<Address>();
	private final String name;

	public Person(String name) {
		this.name = name;
	}

	public Person(String name, List<Address> addresses) {
		this(name);
		for (Address address : addresses) {
			assign(address);
		}
	}

	public String getName() {
		return name;
	}

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

	@Override
	public String toString() {
		return addresses.toString();
	}
}
