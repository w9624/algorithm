package sort;

/**
 * ð������
 * @author wangrz
 * 2018.5.16
 */
public class BobbleSort {

	/**
	 * ��ð������
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
	 * ��ӱ�־λ��ð�ݷ�
	 * ����������򣬼���ѭ������
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
	 * ��β��ð��
	 * ͷβͬʱð��
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
