package sort;

import impl.Tools;
import vo.Node;

public class BucketSort {
	
	/**
	 * 基于数组的桶排序
	 * @param arr
	 */
	public static void bucket(int[] arr) {
		int maxValue = Tools.maxValue(arr);
		int[] tempArr = new int[maxValue + 1];  //桶
		
		for (int i = 0; i < arr.length; i++) {  //将数字放入桶
			tempArr[arr[i]]++;
		}
		
		for (int i = 0, k = 0; i < tempArr.length; i++) { //按顺序从桶中取出
			
			if (tempArr[i] == 0) {
				continue;
			}
			
			for (int j = 0; j < tempArr[i]; j++) {
				arr[k++] = i;
			}
		}
	}
	
	/**
	 * 基于链表的桶排序,,tmd好麻烦，有时间再写吧
	 */
	public static void bucket_one(int[] arr) {
		
		Node head = new Node();
		head.data = arr[0];
		head.count++;
		Node current = head;
		
		for (int i = 1; i < arr.length; i++) {  //将数字放入桶中
			do {
				if (current.data < arr[i]) {
					
				}
			}while (current.next != null);
			
			if (current.data < arr[i]) {
				current.next = current.next.next;
			}else if (current.data == arr[i]) {
				current.count++;
			}else {
				Node node = new Node();
				node.data = arr[i];
				node.count++;
				node.next = current.next;
				current.next = node;
			}
		}
	
		current = head;
		int i = 0;
		while (current.next != null) {
			for (int j = 0; j < current.next.count; j++) {
				arr[i+j] = current.next.data;
			}
		}
	}

}
