package impl;

import java.sql.Time;
import java.util.Arrays;
import java.util.Random;

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

	public static void compare() {
		
	}
	
	/**
	 * 获取随机数组
	 * @param num
	 * @return
	 */
	public static int[] randomAray(int num) {
		if (num <= 0) {
			num = 10000;
		}
		
		int[] arr = new int[num];
		Random random = new Random();
		
		for (int i = 0; i < num; i++) {
			arr[i] = random.nextInt(num);
		}
		return arr;
	}
	
	public static void getUsingTime(Type type) {
		switch (type) {
			case BOBBLE:
				break;
			case QUICK:
				break;
			case SELECT:
				break;
			case HEAP:
				break;
			case INSERT:
				break;
			case SHELL:
				break;
	
			default:
				break;
		}
	}
}
 