package search;

import impl.Complexity;

public class SequenceSearch {

	/**
	 * 在任意状态数组查找key
	 * @param arr
	 * @param key
	 * @return
	 */
	@Complexity(time="n", space="0")
	public static int search(int[] arr, int key) {
		
		int n = arr.length;
		for (int i = 0; i < n; i++) {  //最坏情况会执行n次，平均1/n(1+2+...+n)=(n+1)/2
			if (arr[i] == key) {  
				return i;
			}
		}
		
		return -1;
	}
	
	
	/**
	 * 在任意状态数组查找key
	 * @param arr
	 * @param key
	 * @return
	 */
	public static int search(int[] arr, int key, int low, int high) {
		
		int n = arr.length;
		for (int i = low; i <= high; i++) {  //最坏情况会执行n次，平均1/n(1+2+...+n)=(n+1)/2
			if (arr[i] == key) {  
				return i;
			}
		}
		
		return -1;
	}
	
}
