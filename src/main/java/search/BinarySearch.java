package search;

import impl.Complexity;

/**
 * @author ^_^
 * ���ֲ���
 * ǰ�᣺��С�����ź��������
 */
public class BinarySearch {

	/**
	 * ѭ������
	 * @param arr
	 * @param key
	 * @return 
	 */
	@Complexity(time="log n", space="0")
	public static int search (int[] arr, int key) {
		int low = 0, high = arr.length - 1;
		int mid;
		while (low <= high) { //ִ��n�Σ�ʱ�临�Ӷȣ�n/2^k��>= 1, ����k = log n
			mid = (low + high) / 2;
			if(key > arr[mid]) {
				low = mid + 1;
			}else if (key < arr[mid]) {
				high = mid - 1;
			}else {
				return mid;
			}
		}
		
		return -1;
	}
	
	/**
	 * �ݹ����
	 * @param arr
	 * @param low
	 * @param high
	 * @param key
	 * @return
	 */
	@Complexity(time="log n", space="log n")
	public static int recursive(int[] arr, int low, int high, int key) {
		
		if (low > high) {
			return -1;
		}
		
		int mid = (low + high) / 2; //ÿ��һ��Ϊ2���Ữ��log n�αȽϵĴ���Ϊlog n���ռ临�Ӷ�Ϊ������� log n
		if (key > arr[mid]) {
			return recursive(arr, mid + 1, high, key);
		}else if (key < arr[mid]) {
			return recursive(arr, low, mid - 1, key);
		}else {
			return mid;
		}
	}
	
	/**
	 * ��arr��high֮ǰ����������
	 * ���ظպñ�keyС��ֵ���±꣬���Է��ص��±�����λ�ò������ƶ�
	 * @param arr
	 * @param key
	 * @return 
	 */
	public static int searchForIndex(int[] arr, int key, int high) {
		int low = 0;
		int mid = high;
		while (low <= high) {
			mid = (low + high) / 2;
			if(key > arr[mid]) {
				low = mid + 1;
			}else if (key < arr[mid]) {
				high = mid - 1;
			}else {
				return mid;
			}
		}
		
		return mid;
	}
	
	/**
	 * ѭ������,�����Լ������Լ�������ֵ
	 * @param arr
	 * @param key
	 * @return 
	 */
	public static int searchForBlockSearch (int[] arr, int key) {
		int low = 0, high = arr.length - 1;
		int mid = high;
		while (low <= high) { 
			mid = (low + high) / 2;
			if(key > arr[mid]) {
				low = mid + 1;
			}else if (key < arr[mid]) {
				high = mid - 1;
			}else {
				return mid;
			}
		}
		
		return -1;
	}
}
