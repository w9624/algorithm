package sort;

public class ShellSort {

	/**
	 * 步长为length/2的希尔排序
	 * @param arr
	 */
	public static void shell(int[] arr) {
		shell(arr, 2);
	}
	
	/**
	 * 给定步长length/n
	 * 当步长为(2^k - 1)的时候时间复杂度可以达到 2^(1.5)
	 * @param arr
	 * @param step
	 */
	public static void shell(int[] arr, int step) {
		int n = arr.length;
		
		for (int gap = n / step; gap > 0; gap /= step) { //步长我们使用折半的策略
			for (int i = 0; i < gap; i++) {  //获取到分组的数量
				
				for (int j = i + gap; j < n; j += gap) { //对一个分组进行插入排序，下标为i, i+gap, i+2gap...
					if (arr[j] < arr[j - gap]) {
						int index = j, value = arr[j];
						while (index - gap >= 0 && arr[index - gap] > value) {  //犯错，少了一个条件，只有value比较小的时候才交换
							arr[index] = arr[index -  gap];
							index -= gap;
						}
						arr[index] = value;
					}
				}
				
			}
		}
	}
}
