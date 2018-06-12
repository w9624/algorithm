package search;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sort.SelectionSort;

class BinarySearchTest {
	
	private static int[] arr = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		arr = new int[] {13, 3, 890, -1, 100, 30, 80};
		SelectionSort.select(arr);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		arr = null;
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("方法开始...");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("方法结束...");
	}

	@Test
	final void testBinSearch() {
		
		assertEquals(5, BinarySearch.binSearch(arr, 100));
	}

	@Test
	final void testRecursive() {
		assertEquals(5, BinarySearch.binSearch(arr, 100));
	}

}
