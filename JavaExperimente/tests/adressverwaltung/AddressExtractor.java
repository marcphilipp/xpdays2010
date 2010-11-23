package adressverwaltung;

import java.util.ArrayList;
import java.util.List;

import com.pholser.junit.parameters.extractors.RandomValueExtractor;
import com.pholser.junit.parameters.random.JDKSourceOfRandomness;
import com.pholser.junit.parameters.random.SourceOfRandomness;

public class AddressExtractor implements RandomValueExtractor<Address> {

	public static final List<Address> ALL_ADDRESSES = generateAddresses(10);

	@Override
	public Address randomValue(SourceOfRandomness randomly) {
		return randomly.oneOf(ALL_ADDRESSES);
	}

	private static List<Address> generateAddresses(int number) {
		List<Address> addresses = new ArrayList<Address>(number);
		for (int count = 0; count < number; count++) {
			addresses.add(randomAddress());
		}
		return addresses;
	}

	public static Address randomAddress() {
		SourceOfRandomness randomly = new JDKSourceOfRandomness();
		return new Address(randomly.nextString(), randomly.nextString());
	}
}
