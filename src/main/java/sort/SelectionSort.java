package sort;

import impl.Tools;

public class SelectionSort {

	/**
	 * ѡ������
	 * @param arr
	 */
	public static void select(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int temp = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[temp] > arr[j]) {
					temp = j;
				}
			}

			if (i != temp) {
				Tools.swap(arr, i, temp);
			}
		}
	}

	/**
	 * ͷβͬʱ���е�ѡ������
	 * 
	 * @param arr
	 */
	public static void select_one(int[] arr) {

		int len = arr.length;

		for (int i = 0; i < arr.length / 2; i++) {
			// ��ʼ�������Сֵ�±�
			int min = i, max = i;
			// ѡ����Сֵ�����ֵ
			for (int j = i + 1; j < arr.length - i; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
				if (arr[max] < arr[j]) {
					max = j;
				}
			}
			// ���������λ��
			if (arr[max] == arr[min]) { // �����Ѿ�����
				break;
			} else {
				if (min == i && max == len - i - 1) { // �����Сֵλ����ȷ
					continue;
				} else if (min == len - i - 1 && max == i) { // ����������Сֵ��λ�øպöԵ�
					Tools.swap(arr, min, max);
				} else if (max == i) { // ���ֵ����СֵҪ�ƶ�����λ��
					Tools.swap(arr, len - i - 1, max);
					Tools.swap(arr, i, min);
				} else { // ��Сֵ�����ֵҪ�ƶ�����λ�ú��������
					Tools.swap(arr, i, min);
					Tools.swap(arr, len - i - 1, max);
				}
			}
		}
	}

	/**
	 * ѡ�����򣬿�����������
	 * 
	 * @param arr
	 */
	public static void select(int[] arr, int low, int high) {
		for (int i = low; i < high; i++) {
			int temp = i;
			for (int j = i + 1; j <= high; j++) {
				if (arr[temp] > arr[j]) {
					temp = j;
				}
			}

			if (i != temp) {
				Tools.swap(arr, i, temp);
			}
			// Tools.display(arr);
		}
	}

}
