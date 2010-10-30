package bank;

import java.math.BigDecimal;

import com.pholser.junit.parameters.extractors.RandomValueExtractor;
import com.pholser.junit.parameters.random.SourceOfRandomness;

public class BigDecimalExtractor implements RandomValueExtractor<BigDecimal> {

	@Override
	public BigDecimal randomValue(SourceOfRandomness random) {
		return new BigDecimal(((double) random.nextLong()) / 100);
	}
}
