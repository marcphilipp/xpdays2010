package quicksort;

import static java.util.Collections.nCopies;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.StringUtils;

public class Utils {

	public static void print(Object... arguments) {
		System.out.println(StringUtils.join(arguments, ", "));
	}

	public static <T extends Comparable<T>> boolean ordered(Iterable<T> result) {
		Iterator<T> iterator = result.iterator();
		if (!iterator.hasNext()) {
			return true;
		}
		T previous = iterator.next();
		while (iterator.hasNext()) {
			T current = iterator.next();
			if (previous.compareTo(current) > 0) {
				return false;
			}
			previous = current;
		}
		return true;
	}

	public static int countAndRemove(Object item, List<?> values) {
		int count = 0;
		while (values.remove(item)) {
			count++;
		}
		return count;
	}

	public static List<Integer> list(Integer i, Integer j, Integer k) {
		List<Integer> items = new ArrayList<Integer>();
		Random random = new Random();
		items.addAll(nCopies(random.nextInt(100), i));
		items.addAll(nCopies(random.nextInt(100), j));
		items.addAll(nCopies(random.nextInt(100), k));
		return items;
	}

}
