package adressverwaltung;

import com.pholser.junit.parameters.extractors.RandomValueExtractor;
import com.pholser.junit.parameters.random.SourceOfRandomness;

public class PersonExtractor implements RandomValueExtractor<Person> {

	public final Person alice = new Person();
	public final Person bob = new Person();

	public PersonExtractor() {
		bob.assign(AddressExtractor.FIRST_ADDRESS);
		bob.assign(new Address());
	}

	@Override
	public Person randomValue(SourceOfRandomness random) {
		return random.oneOf(alice, bob);
	}
}
