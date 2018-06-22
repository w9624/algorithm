package search;

import impl.Tools;
import sort.QuickSort;

public class Test {
	public static void main(String[] args) {
		int[] arr = new int[] {13, 3, 890, -1, 100, 30, 80, 44, 33, 33, 0, -10, 55, 54, 6, 4, 6, 6, 7, 0, -1, 3, 2};
		int[] arr_one = Tools.randomAray(100000000);
		//QuickSort.quick(arr_one);
		
		long start, end;
		start = System.currentTimeMillis();
		int[] temp = BlockSearch.index(arr, 2);
		end = System.currentTimeMillis();
		Tools.display(temp);
		System.out.println((end - start) + " ... ");
	}

}
