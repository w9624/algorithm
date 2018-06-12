package sort;

import java.util.Random;

public class QuickSort {
	
	/**
	 * 快速排序
	 * @param arr
	 */
	public static void quick(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}
	
	/**
	 * 快速排序，对一定长度的子序列进行选择排序
	 * @param arr
	 */
	public static void quick_one(int[] arr) {
		sort_one(arr, 0, arr.length - 1);
	}
	
	private static void sort(int[] arr, int low, int high) {
		if (low < high) {
			int pos = partition(arr, low, high); //low-high之间的数完成一次快速排序排序
			sort(arr, low, pos - 1);       //对左边数字序列排序
			sort(arr, pos + 1, high);      //对右边数字序列排序
		}
	}
	
	private static void sort_one(int[] arr, int low, int high) {
		//对数组长度不大于10的时候，采用选择排序
		if (high - low > 11) {
			int pos = partition(arr, low, high); //low-high之间的数完成一次快速排序排序
			sort_one(arr, low, pos - 1);       //对左边数字序列排序
			sort_one(arr, pos + 1, high);      //对右边数字序列排序
		} else {
			SelectionSort.selectWithBoard(arr, low, high);
		}
	}
	
	private static int partition(int[] arr, int low, int high) {
		
		//selectPivot(arr, low, high);
		
	  //直接从最前端获取监视哨兵
	  int temp = arr[low]; 
	  
		while (low < high) {
		  //从high开始与哨兵比较，比哨兵大则指针向前移动,直至找到比哨兵小的数字
			while (low < high && arr[high] > temp) {  
				high--;
			}
			
		  //将比哨兵小的数字，移动到low的位置，low的指针向后移动一位
			if (low < high) {
				arr[low++] = arr[high];  
			}
			
		  //从high开始与哨兵比较，比哨兵大则指针向前移动,直至找到比哨兵大的数字
			while (low < high && arr[low] < temp) {  
				low++;
			}
			
			//将比哨兵小的数字，移动到low的位置，high的指针向前移动一位
			if (low < high) {
				arr[high--] = arr[low];
			}
		}
		//将哨兵放置在，low=high的位置，此时哨兵左侧小于哨兵，有的大于哨兵
		arr[low] = temp;
		
		return low;
	}
	
	@SuppressWarnings("unused")
	private static void selectPivot(int[] arr, int low, int high) {
		//固定哨兵位置位low
		int index = low;	
		//随机获取一个下标
		/*Random random = new Random();
		index = (int) (Math.abs(random.nextInt()) % (high - low + 1)) + low;*/
		//三元法获取下标
		/*int mid = (low + high) / 2;
		if (arr[low] < arr[high]) {
			if (arr[low] > arr[mid]) {
				index = low;
			}else if (arr[high] < arr[mid]){
				index = high;
			}else {
				index = mid;
			}
		}*/
		//交换index位置和哨兵位置
		int temp = arr[index];
		arr[index] = arr[low];
		arr[low] = temp;
	}
}
