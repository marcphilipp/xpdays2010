package adressverwaltung;

public class Address {

	private final String street;
	private final String city;

	public Address(String street, String city) {
		this.street = street;
		this.city = city;
	}

	@Override
	public boolean equals(Object that) {
		return that instanceof Address && equals((Address) that);
	}

	private boolean equals(Address that) {
		return this.street.equals(that.street) & this.city.equals(that.city);
	}

	@Override
	public int hashCode() {
		return street.hashCode();
	}

	@Override
	public String toString() {
		return street + ", " + city;
	}
}
