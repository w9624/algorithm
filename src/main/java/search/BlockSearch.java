package search;

import sort.QuickSort;

/**
 * 无法理解，既然能给他分块，若要是算法时间复杂度足够简单
 * 那么数组应当是有序的，既然数组是有序的，二分查找不是更快？
 * 除非块是自然分好的，一般来说也不可能啊！
 * 除非可进行人为分块，并且时间复杂度比排序好很多，否则得不偿失。。
 * @author Administrator
 *
 */
public class BlockSearch {
	
	/**
	 * 分块查找，默认分为10块
	 * @param arr
	 * @param key
	 * @param index
	 * @return
	 */
	public static int search(int[] arr, int[] index, int step, int key) {
		int idx_1 = BinarySearch.searchForBlockSearch(index, key);
		System.err.println(index);
		int idx_2 = SequenceSearch.search(arr, key, step * idx_1 , step * (idx_1 + 1) - 1);
		return idx_2;
	}
	
	/*public static int[] block(int[] arr, int step){
		int n = arr.length;
		if (step <= 0) {step = n / 10 + 1;}
		int[] tempArr = new int[n / step + 1];
		
		for (int i = 0; i < n / step + 1; i++) {
				int max = Tools.max(arr, i * step , (i + 1) * step - 1);
				tempArr[i] = max;
		}
		
		Tools.display(tempArr);
		
		int index = BinarySearch.searchForBlockSearch(tempArr, key);
		System.err.println(index);
		
		index = SequenceSearch.search(tempArr, key, step * index , step * (index + 1) - 1);
		
		return new int[]{1};
	}*/
	
	public static int[] index(int[] arr, int step) {
		int n = arr.length;
		int len = (n+1) / step;
		int[] index = new int[len];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < len; j++) {
				if (arr[i] > index[0]) {
					index[0] = arr[i];
				}
			}
			
			QuickSort.quick(index);
		}
		return index;
	}

}
