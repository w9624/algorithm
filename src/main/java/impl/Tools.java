package impl;

import java.util.Arrays;

public interface Tools {
	
	/**
	 * 交换数组中两个数
	 * @param arr
	 * @param i
	 * @param j
	 */
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	/**
	 * 输出数组
	 * @param arr
	 */
	static void display(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 判断是否升序
	 * @param arr
	 * @return
	 */
	static boolean isOrderAsc(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				System.out.println(Arrays.toString(arr));
				System.out.println("第" + i + "位：" + arr[i] + " > " +arr[i + 1]);
				return false;
			}
		}
		return true;
	}

}
