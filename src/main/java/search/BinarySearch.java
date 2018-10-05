package search;

import impl.Complexity;
import impl.Search;

/**
 * @author ^_^
 * 二分查找
 * 前提：顺序存储，关键字大小有序
 */
public class BinarySearch implements Search{

	/**
	 * 循环查找
	 * @param arr
	 * @param key
	 * @return 
	 */
	@Complexity(time="log n", space="0")
	public static int search (int[] arr, int key) {
		int low = 0, high = arr.length - 1;
		
		while (low <= high) { //执行n次，时间复杂度（n/2^k）>= 1, 所以k = log n
			int mid = (low + high) >> 1;
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
	 * 递归实现
	 * @param arr
	 * @param low
	 * @param high
	 * @param key
	 * @return
	 */
	@Complexity(time="log n", space="log n")
	public static int recursive(int[] arr, int low, int high, int key) {
		
		if (low > high) {
			return -1;
		}
		
		int mid = (low + high) >> 1; //每次一分为2，会划分log n次比较的次数为log n，空间复杂度为数的深度 log n
		if (key > arr[mid]) {
			return recursive(arr, mid + 1, high, key);
		}else if (key < arr[mid]) {
			return recursive(arr, low, mid - 1, key);
		}else {
			return mid;
		}
	}
	
	/**
	 * 在arr中high之前的数字有序
	 * 返回刚好比key小的值得下标，所以返回的下标所在位置不发生移动
	 * @param arr
	 * @param key
	 * @return 
	 */
	public static int searchForIndex(int[] arr, int key, int high) {
		int low = 0;
		int mid = high;
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
		
		return mid;
	}
	
	/**
	 * 循环查找,给出自己大于自己的索引值
	 * @param arr
	 * @param key
	 * @return 
	 */
	public static int searchForBlockSearch (int[] arr, int key) {
		int low = 0, high = arr.length - 1;
		int mid = high;
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
}
