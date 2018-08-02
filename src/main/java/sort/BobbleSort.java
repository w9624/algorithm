package sort;

/**
 * 冒泡排序
 * @author wangrz
 * 2018.5.16
 */
public class BobbleSort {

	/**
	 * 简单冒泡排序
	 * @param arr
	 * 
	 */
	public static void bobble(int[] arr) {
		for (int i = 0; i < arr.length - 2; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int k = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = k;
				}
			}
		}
	}
	
	/**
	 * 添加标志位的冒泡法
	 * 如果数组有序，减少循环次数
	 * @param arr
	 */
	public static void bobble_one(int[] arr) {
		for (int i = 0; i < arr.length - 2; i++) {
			boolean flag = true;
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int k = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = k;
					flag = false;
				}
			}
			
			if (flag) {
				break;
			}
		}
	}
	
	/**
	 * 鸡尾酒冒泡
	 * 头尾同时冒泡
	 * @param arr
	 */
	public static void bobble_two(int[] arr) {
		for (int i = 0; i < arr.length / 2; i++) {
			boolean flag = true;
			for (int j = i; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int k = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = k;
					flag = false;
				}
			}
			
			for (int j = arr.length - i - 2; j > i; j--) {
				if (arr[j] > arr[j + 1]) {
					int k = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = k;
					flag = false;
				}
			}
			
			if (flag) {
				break;
			}
		}
	}

}
