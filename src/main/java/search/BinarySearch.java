package search;

/**
 * @author ^_^
 * 二分查找
 * 前提：由小到大排好序的数组
 */
public class BinarySearch {

	/**
	 * 循环查找
	 * @param arr
	 * @param key
	 * @return 
	 */
	public static int binSearch(int[] arr, int key) {
		int low = 0, high = arr.length - 1;
		int mid;
		while (low <= high) {
			mid = (low + high) / 2;
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
	
	/**
	 * 递归查找
	 * @param arr
	 * @param low
	 * @param high
	 * @param key
	 * @return
	 */
	public static int recursive(int[] arr, int low, int high, int key) {
		
		if (low > high) {
			return -1;
		}
		
		int mid = (low + high) / 2;
		if (key > arr[mid]) {
			return recursive(arr, mid + 1, high, key);
		}else if (key < arr[mid]) {
			return recursive(arr, low, mid - 1, key);
		}else {
			return mid;
		}
	}
}
