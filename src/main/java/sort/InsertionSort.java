package sort;

import search.BinarySearch;

public class InsertionSort {
	
	/**
	 * 插入排序
	 * @param arr
	 */
	public static void insert(int[] arr) {
		
		for (int i = 1; i < arr.length; i++) { //第0位置默认有序
			int index = i, value = arr[i];  //记录当前位置的值和下标
			for (int j = i; j > 0; j--) {  //与前面有序数列比较，向后移动比自己大的值，确定插入位置
				if (value < arr[j - 1]) { //犯过错，，应该是value和每个值比较~.~
					arr[j] = arr[j - 1]; 
					index = j - 1;
				}
			}
			arr[index] = value;
		}
	}
	
	/**
	 * 使用二分法查找位置
	 * @param arr
	 */
	public static void insert_one(int[] arr) {
		for (int i = 1; i < arr.length; i++) { //第0位置默认有序
			int value = arr[i];  //记录当前位置的值和下标
			int index = BinarySearch.searchForIndex(arr, value, i); //二分法确定待插入的位置，出错是因为index是小于等于value，所以从index+1的位置开始移动
			for (int j = i; j > index + 1; j--) {  //与前面有序数列比较，向后移动比自己大的值，确定插入位置
					arr[j] = arr[j - 1];
			}
			arr[index] = value;
		}
	}
	
	/**
	 * 插入排序
	 * @param arr
	 */
	public static void insert(int[] arr, int low, int high) {
		
		for (int i = low +1; i < high +1; i++) { //第0位置默认有序
			int index = i, value = arr[i];  //记录当前位置的值和下标
			for (int j = i; j > 0; j--) {  //与前面有序数列比较，向后移动比自己大的值，确定插入位置
				if (value < arr[j - 1]) { //犯过错，，应该是value和每个值比较~.~
					arr[j] = arr[j - 1]; 
					index = j - 1;
				}
			}
			arr[index] = value;
		}
	}
	
}
