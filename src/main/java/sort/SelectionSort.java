package sort;

import impl.Tools;

public class SelectionSort {

	/**
	 * 选择排序
	 * @param arr
	 */
	public static void select(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int temp = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[temp] > arr[j]) {
					temp = j;
				}
			}

			if (i != temp) {
				Tools.swap(arr, i, temp);
			}
		}
	}

	/**
	 * 头尾同时进行的选择排序
	 * 
	 * @param arr
	 */
	public static void select_one(int[] arr) {

		int len = arr.length;

		for (int i = 0; i < arr.length / 2; i++) {
			// 初始化最大最小值下标
			int min = i, max = i;
			// 选出最小值和最大值
			for (int j = i + 1; j < arr.length - i; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
				if (arr[max] < arr[j]) {
					max = j;
				}
			}
			// 交换数组的位置
			if (arr[max] == arr[min]) { // 数组已经有序
				break;
			} else {
				if (min == i && max == len - i - 1) { // 最大最小值位置正确
					continue;
				} else if (min == len - i - 1 && max == i) { // 交换最大和最小值的位置刚好对调
					Tools.swap(arr, min, max);
				} else if (max == i) { // 最大值在最小值要移动到的位置
					Tools.swap(arr, len - i - 1, max);
					Tools.swap(arr, i, min);
				} else { // 最小值在最大值要移动到的位置和其他情况
					Tools.swap(arr, i, min);
					Tools.swap(arr, len - i - 1, max);
				}
			}
		}
	}

	/**
	 * 选择排序，快速排序引用
	 * 
	 * @param arr
	 */
	public static void select(int[] arr, int low, int high) {
		for (int i = low; i < high; i++) {
			int temp = i;
			for (int j = i + 1; j <= high; j++) {
				if (arr[temp] > arr[j]) {
					temp = j;
				}
			}

			if (i != temp) {
				Tools.swap(arr, i, temp);
			}
			// Tools.display(arr);
		}
	}

}
