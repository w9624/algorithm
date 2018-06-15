package search;

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
	public static int binSearch(int[] arr, int key) {
		int low = 0, high = arr.length - 1;
		int mid;
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
	
	/**
	 * �ݹ����
	 * @param arr
	 * @param low
	 * @param high
	 * @param key
	 * @return
	 */
	public static int recursive(int[] arr, int low, int high, int key) {
		
		if (low > high) {
			return -1;
		}
		
		int mid = (low + high) / 2;
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
}
