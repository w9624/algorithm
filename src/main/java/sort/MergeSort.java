package sort;

public class MergeSort {
	
	/**
	 * 归并排序的递归实现
	 * @param arr
	 */
	public static void merge(int[] arr) {
		int[] tempArr = new int[arr.length];
		partition(arr, 0, arr.length - 1, tempArr);
	}
	
	/**
	 * 归并排序的递归优化
	 * 但是不知道为什么之后比优化之前慢，无法理解。。。
	 * @param arr
	 */
	public static void merge_one(int[] arr) {
		int[] tempArr = new int[arr.length];
		partition_one(arr, 0, arr.length - 1, tempArr);
	}
	
	/**
	 * 归并排序的循环实现
	 * @param arr
	 */
	public static void merge_two(int[] arr) {
		int[] tempArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			
		}
	}
	
	/**
	 * 划分数组
	 * @param arr
	 * @param low
	 * @param high
	 * @param tempArr
	 */
	private static void partition(int[] arr, int low, int high, int[] tempArr) {
		if (low < high) {
			int mid = (low + high) / 2;
			partition(arr, low, mid, tempArr);
			partition(arr, mid + 1, high, tempArr);
			mergeArray(arr, low, mid, high, tempArr);
		}
	}
	
	private static void partition_one(int[] arr, int low, int high, int[] tempArr) {
		if (high - low < 6) {  //数字较少的时候使用插入排序
			InsertionSort.insert(arr, low, high);
			return;
		} /*if (low < high) */
		else {
			int mid = (low + high) / 2;
			partition(arr, low, mid, tempArr);
			partition(arr, mid + 1, high, tempArr);
			if (arr[mid] <= arr[mid + 1]) {  //减少不必要的合并，也就是 前后都是有序的
				return;
			}
			mergeArray(arr, low, mid, high, tempArr);
		}
	}
	
	/**
	 * 对连个数组进行合并
	 * @param arr
	 * @param low
	 * @param mid
	 * @param high
	 * @param tempArr
	 */
	private static void mergeArray(int arr[], int low, int mid, int high, int[] tempArr) {
		int i = low, j = mid + 1, k = 0;
		while (i <= mid && j <= high) {
			if (arr[i] <= arr[j]) {
				tempArr[k++] = arr[i++];
			}else {
				tempArr[k++] = arr[j++];
			}
		}
		
		while (i <= mid) {
			tempArr[k++] = arr[i++];
		}
		
		while (j <= high) {
			tempArr[k++] = arr[j++];
		}
		
		for(i = low; i <= high; i++) {//犯错，问题是未将位置对应好arr[low]对应的应当是tempArr[i-low]
			arr[i] =tempArr[i - low];
		}		
		
	}

}
