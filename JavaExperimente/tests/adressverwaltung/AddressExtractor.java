package adressverwaltung;

import com.pholser.junit.parameters.extractors.RandomValueExtractor;
import com.pholser.junit.parameters.random.SourceOfRandomness;

public class AddressExtractor implements RandomValueExtractor<Address> {
	
	public static final Address FIRST_ADDRESS = new Address();
	public static final Address SECOND_ADDRESS = new Address();
	public static final Address[] ADDRESSES = {null, FIRST_ADDRESS, SECOND_ADDRESS};

	@Override
	public Address randomValue(SourceOfRandomness random) {
		return random.oneOf(ADDRESSES);
	}
}
