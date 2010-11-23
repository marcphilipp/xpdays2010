package adressverwaltung;

import static adressverwaltung.AddressExtractor.ALL_ADDRESSES;

import java.util.List;

import com.pholser.junit.parameters.extractors.RandomValueExtractor;
import com.pholser.junit.parameters.random.SourceOfRandomness;

public class PersonExtractor implements RandomValueExtractor<Person> {

	@Override
	public Person randomValue(SourceOfRandomness randomly) {
		String name = randomly.nextString();
		List<Address> addresses = randomly.pickUpTo(6, ALL_ADDRESSES);
		return new Person(name, addresses);
	}

}
