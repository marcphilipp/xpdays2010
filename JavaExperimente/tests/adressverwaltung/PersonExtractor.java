package adressverwaltung;

import static adressverwaltung.AddressExtractor.ALL_ADDRESSES;

import com.pholser.junit.parameters.extractors.RandomValueExtractor;
import com.pholser.junit.parameters.random.SourceOfRandomness;

public class PersonExtractor implements RandomValueExtractor<Person> {

	@Override
	public Person randomValue(SourceOfRandomness randomly) {
		Person person = new Person(randomly.nextString());
		for (Address address : randomly.pickUpTo(6, ALL_ADDRESSES)) {
			person.assign(address);
		}
		return person;
	}

}
