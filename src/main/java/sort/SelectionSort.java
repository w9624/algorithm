package sort;

import java.util.Arrays;

public class SelectionSort {
	
	/**
	 * ѡ������
	 * @param arr
	 */
	public static void select(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	/**
	 * ͷβͬʱ���е�ѡ������
	 * @param arr
	 */
	public static void select_one(int[] arr) {
		for (int i = 0; i < arr.length / 2; i++) {
			//��ʼ�������Сֵ�������±�
			int min = i, max = i;
			//ѡ����Сֵ�����ֵ
			for (int j = i + 1; j < arr.length - i; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
				
				if (arr[max] < arr[j]) {
					max = j;
				}
			}
			System.out.println(arr[min] + ",,," + arr[max]);
			if (max == min) {
				continue;
			}else {
				System.out.println("\n" + Arrays.toString(arr));
				int temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
				System.out.println(Arrays.toString(arr));
				System.out.println(arr[arr.length - i - 1]);
				System.out.println(arr[max]);
				temp = arr[max];
				arr[max] = arr[arr.length - i - 1];
				arr[arr.length - i - 1] = temp;
				
				System.out.println(Arrays.toString(arr));
			}
		}
	}

}
