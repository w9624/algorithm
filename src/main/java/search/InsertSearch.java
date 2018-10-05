package search;

import impl.Complexity;

/**
 * @author ^_^
 * 插值查找
 * 前提：顺序存储，关键字大小有序
 */
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
		while (low <= high) { //执行n次，时间复杂度（n/2^k）>= 1, 所以k = log n
			//二分查找：low + 1/2(high - low)
			int mid = low + (int)((1.0 * key-arr[low])/(arr[high]-arr[low])*(high-low));
			if(key == arr[mid]) {
				return mid;
			}else if (key < arr[mid]) {
				high = mid - 1;
			}else {
				low = mid + 1;
			}
		}
		return -1;
	}
	
	/**
	 * 递归实现
	 * @param arr
	 * @param low
	 * @param high
	 * @param key
	 * @return
	 */
	@Complexity(time="log n", space="log n")
	public static int recursive(int[] arr, int low, int high, int key) {
		if (low >= high) {
			return -1;
		}
		
		int mid = low + (key-arr[low])/(arr[high] - arr[low])*(high-low);
		if (key == arr[mid]) {
			return mid;
		}else if (key > arr[mid]) {
			return recursive(arr, mid + 1, high, key);
		}else {
			return recursive(arr, low, mid - 1, key);
		}		
	}
}
