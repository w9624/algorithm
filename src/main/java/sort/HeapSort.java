package sort;

import impl.Tools;

public class HeapSort {
	
	public static void heap(int[] arr) {
		
		int n = arr.length - 1;
		//建立初堆
		build(arr, n);
		for (int i = n; i > 0; i--) {
			Tools.swap(arr, 0, i);
			rebuild(arr, 0,  i - 1);
		}
	}
	
	//初始化堆
	private static void build(int[] arr, int n) {
		for (int i = (n - 1) / 2; i >= 0; i--) { //对每一个非叶子节点从后向前开始重建
			rebuild(arr, i, n - 1); 
		}
	}
	
	//重新建立堆
	private static void rebuild(int arr[], int head, int tail) {
		int temp = arr[head]; //存储堆顶元素
		int i = head;
		int j = 2 * i + 1; //j指向左子节点
		
		while (j <= tail) { 
			if (j < tail && arr[j] < arr[j + 1]) {  //存在右子节点并大于左子节点，j指向右子节点
				j++;
			}
			
			if (temp >= arr[j]) { //父节点大于左右子节点，结束
				break;
			} else { 
				arr[i] = arr[j]; //将较大的子节点移动到父节点的位置
				i = j; //更改父节点
				j = 2 * i + 1;
			}
		}
		
		arr[i] = temp;
		
	}

}
