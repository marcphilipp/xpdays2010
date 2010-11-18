package util;

import org.junit.Assume;

public class AdditionalAssumes extends Assume {

	public static void assumeFalse(boolean value) {
		assumeTrue(!value);
	}

	public static void assumeEquals(int i, int j) {
		assumeTrue(i == j);
	}

}
