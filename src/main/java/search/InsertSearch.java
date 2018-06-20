package search;

import impl.Complexity;

public class InsertSearch {

	/**
	 * 循环查找
	 * @param arr
	 * @param key
	 * @return 
	 */
	@Complexity(time="log n", space="0") //最好情况是log log n
	public static int search (int[] arr, int key) {
		int low = 0, high = arr.length - 1;
		int mid;
		while (low <= high) { //执行n次，时间复杂度（n/2^k）>= 1, 所以k = log n
			mid = low + (high-low) * ((key-arr[low])/(arr[high] - arr[low]))	;
			if(key > arr[mid]) {
				low = mid + 1;
			}else if (key < arr[mid]) {
				high = mid - 1;
			}else {
				return mid;
			}
		}
		
		return -1;
	}
}
