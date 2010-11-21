package adressverwaltung;

import java.util.Arrays;
import java.util.List;

import com.pholser.junit.parameters.extractors.RandomValueExtractor;
import com.pholser.junit.parameters.random.JDKSourceOfRandomness;
import com.pholser.junit.parameters.random.SourceOfRandomness;

public class AddressExtractor implements RandomValueExtractor<Address> {

	public static final List<Address> ALL_ADDRESSES = Arrays.asList(
			randomAddress(), randomAddress(), randomAddress(), randomAddress(),
			randomAddress(), randomAddress(), randomAddress(), randomAddress(),
			randomAddress(), randomAddress());

	@Override
	public Address randomValue(SourceOfRandomness randomly) {
		return randomly.oneOf(ALL_ADDRESSES);
	}

	public static Address randomAddress() {
		SourceOfRandomness randomly = new JDKSourceOfRandomness();
		return new Address(randomly.nextString(), randomly.nextString());
	}
}
