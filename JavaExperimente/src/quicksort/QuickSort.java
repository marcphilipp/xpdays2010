package quicksort;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

	protected class Partition<T extends Comparable<T>> {

		private final T pivot;
		private final List<T> smaller, larger;

		public Partition(List<T> all, T pivot) {
			this.pivot = pivot;
			smaller = newList();
			larger = newList();
			split(all, pivot);
		}

		private void split(List<T> all, T pivot) {
			for (T item : all) {
				if (item.compareTo(pivot) < 0) {
					smaller.add(item);
				} else {
					larger.add(item);
				}
			}
		}

		public T pivot() {
			return pivot;
		}

		public List<T> smaller() {
			return smaller;
		}

		public List<T> larger() {
			return larger;
		}
	}

	public <T extends Comparable<T>> List<T> sort(List<T> list) {
		if (list.isEmpty()) {
			return newList();
		}
		return sortNonEmpty(list);
	}

	protected <T> List<T> newList() {
		return new ArrayList<T>();
	}

	protected <T extends Comparable<T>> List<T> sortNonEmpty(List<T> list) {
		Partition<T> partition = split(list);
		return concat(sort(partition.smaller()), partition.pivot(), sort(partition.larger()));
	}

	private <T extends Comparable<T>> Partition<T> split(List<T> list) {
		T pivot = list.get(0);
		List<T> tail = list.subList(1, list.size());
		return new Partition<T>(tail, pivot);
	}

	private <T> List<T> concat(List<T> smaller, T pivot, List<T> larger) {
		List<T> result = new ArrayList<T>();
		result.addAll(smaller);
		result.add(pivot);
		result.addAll(larger);
		return result;
	}
}
