package junittests;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

import quicksort.QuickSort;

public class QuickSortTest {

	private QuickSort quick = new QuickSort();
	
	@Test
	public void emptyList() throws Exception {
		assertEquals(Collections.emptyList(), quick.sort(new ArrayList<Integer>()));
	}
	
	@Test
	public void sortierteListe() throws Exception {
		assertEquals(asList(1, 2, 3), quick.sort(asList(1, 2, 3)));
	}
	
	@Test
	public void unsortierteListe() throws Exception {
		assertEquals(asList(1, 2, 3), quick.sort(asList(2, 1, 3)));
	}
	
	@Test
	public void mehrereGleicheElemente() throws Exception {
		assertEquals(asList(1, 1, 2, 2, 3, 3), quick.sort(asList(2, 1, 3, 2, 1, 3)));
	}
	
	
	
}
