package search;

import impl.Tools;

public class BlockSearch {
	
	public static int search(int[] arr, int key) {
		
		int n = arr.length;
		int step = n / 10 + 1;
		int[] tempArr = new int[n / step + 1];
		
		for (int i = 0; i < n / step + 1; i++) {
				int max = Tools.max(arr, i * step , (i + 1) * step - 1);
				tempArr[i] = max;
		}
		
		Tools.display(tempArr);
		
		int index = BinarySearch.searchForBlockSearch(tempArr, key);
		System.err.println(index);
		
		index = SequenceSearch.search(tempArr, key, step * index , step * (index + 1) - 1);
		
		return index;
	}

}
