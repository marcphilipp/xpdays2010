package theories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static theories.Utils.countAndRemove;
import static theories.Utils.list;
import static theories.Utils.ordered;

import java.util.List;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import quicksort.QuickSort;

@RunWith(Theories.class)
public class QuickSortTheories {

	@DataPoints
	public static final Integer[] VALUES = { 0, 1, 2, 3 };
	
	private QuickSort quick = new QuickSort();

	@Theory
	public void resultIsOrdered(Integer i, Integer j, Integer k) {
		List<Integer> result = quick.sort(list(i, j, k));
		assertTrue(ordered(result));
	}
	
	@Theory
	public void resultHasSameLength(Integer i, Integer j, Integer k) {
		List<Integer> input = list(i, j, k);
		List<Integer> result = quick.sort(input);
		assertEquals(input.size(), result.size());
	}
	
	@Theory
	public void resultHasSameElements(Integer i, Integer j, Integer k) {
		List<Integer> input = list(i, j, k);
		List<Integer> result = quick.sort(input);
		for (Object value : result.toArray()) {
			assertEquals(countAndRemove(value, input), countAndRemove(value, result));
		}
	}

}
