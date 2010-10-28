package quicksort;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

	static class Partition {

		private final List<Integer> smaller;
		private final List<Integer> larger;

		Partition(List<Integer> list, Integer pivot) {
			smaller = new ArrayList<Integer>();
			larger = new ArrayList<Integer>();
			for (Integer x : list) {
				if (x.intValue() < pivot.intValue()) {
					smaller.add(x);
				} else {
					larger.add(x);
				}
			}
		}

		public List<Integer> smaller() {
			return smaller;
		}

		public List<Integer> larger() {
			return larger;
		}

	}

	public static List<Integer> sort(List<Integer> list) {
		if (list.isEmpty()) {
			return new ArrayList<Integer>();
		}
		return sortNonEmpty(list);
	}

	private static List<Integer> sortNonEmpty(List<Integer> list) {
		Integer pivot = list.get(0);
		Partition partition = new Partition(list.subList(1, list.size()), pivot);
		return concat(sort(partition.smaller()), pivot, sort(partition.larger()));
	}

	private static <T> List<T> concat(List<T> smaller, T pivot, List<T> larger) {
		List<T> result = new ArrayList<T>();
		result.addAll(smaller);
		result.add(pivot);
		result.addAll(larger);
		return result;
	}

}
