package sort;

import java.util.Random;

import impl.Tools;

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
		/*//对数组长度不大于10的时候，采用选择排序
		if (high - low > 10) {
			InsertionSort.insert(arr, low, high);
			return;
		} else*/while (low < high) {
			int pos = partition_one(arr, low, high); //low-high之间的数完成一次快速排序排序
			sort_one(arr, low, pos - 1);       //对左边数字序列排序
			low = pos + 1;      //优化尾递归
		}
	}
	
	private static int partition(int[] arr, int low, int high) {
		
	  //直接从最前端获取监视哨兵
	  int temp = arr[low];
	  
		while (low < high) {
		  //从high开始与哨兵比较，比哨兵大则指针向前移动,直至找到比哨兵小的数字
			while (low < high && arr[high] >temp) {
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
	
	private static int partition_one(int[] arr, int low, int high) {
			
		  //直接从最前端获取监视哨兵
	  int temp = selectPivot(arr, low, high, 3); 
	  int left = low, head = low, right = high, tail = high;
	  int leftLen = 0, rightLen = 0;
		while (low < high) {
		  //从high开始与哨兵比较，比哨兵大则指针向前移动,直至找到比哨兵小的数字
			while (low < high && arr[high] >= temp) {
				if (arr[high] == temp) {
					Tools.swap(arr, high, right);
					right--;
					rightLen--;
				}
				high--;
			}
			
		  //将比哨兵小的数字，移动到low的位置，low的指针向后移动一位
			if (low < high) {
				arr[low++] = arr[high];  
			}
			
		  //从high开始与哨兵比较，比哨兵大则指针向前移动,直至找到比哨兵大的数字
			while (low < high && arr[low] <= temp) {
				if (arr[low] == temp) {
					Tools.swap(arr, low, left);
					left++;
					leftLen++;
				}
				low++;
			}
			
			//将比哨兵小的数字，移动到low的位置，high的指针向前移动一位
			if (low < high) {
				arr[high--] = arr[low];
			}
		}
		//将哨兵放置在，low=high的位置，此时哨兵左侧小于哨兵，有的大于哨兵
		arr[low] = temp;
		
		//移动相等的数字在哨兵旁边
		for (int i = 0; i < leftLen; i++) {
			Tools.swap(arr, head, low - i - 1);
			head++;
		}
		for (int i = 0; i < rightLen; i++) {
			Tools.swap(arr, tail, high + i + 1);
			tail++;
		}
		
		return low;
	}
	
	/**
	 * 获取哨兵
	 * @param arr
	 * @param low
	 * @param high
	 * @param id
	 * @return
	 */
	private static int selectPivot(int[] arr, int low, int high,int id) {
		int index = low;
		switch (id) {
			case 0:
				break;
			case 2:
				Random random = new Random();
				index = (int) (Math.abs(random.nextInt()) % (high - low + 1)) + low;  ////随机获取一个下标哨兵位置
				break;
			case 3:
				int mid = (low + high) / 2; //三元法获取下标
				if (arr[low] < arr[high]) {
					if (arr[low] > arr[mid]) {
						index = low;
					}else if (arr[high] < arr[mid]){
						index = high;
					}else {
						index = mid;
					}
				}
				break;
		}
		//交换index位置和哨兵位置
		if (index != low) {
			Tools.swap(arr, index, low);
		}
		
		return arr[low];
	}
}
