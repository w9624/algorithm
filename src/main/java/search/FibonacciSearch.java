package search;

import impl.Search;

/**
 * 
 * @author ^_^
 * 斐波拉契查找
 * 前提：顺序存储，键值有序
 */
public class FibonacciSearch implements Search{
	
	/**
	 * 斐波拉契查找
	 * @param arr
	 * @param key
	 * @return
	 */
	public static int search(int[] arr, int key) {
		//生成斐波拉契数列
		int[] fib = new int[45];
		int count = 2;
		fib[0] = 1;
		fib[1] = 1;
		while (count < fib.length) {
			fib[count] = fib[count - 1] + fib[count - 2];
			count++;
		}
		
		//获取比数组长度大的斐波那契数fib[pos]
		int pos = 0, n = arr.length;
		while (n > fib[pos] - 1) {
			pos++;
		}
		
		//产生一个fib[pos]长度的数组
		int[] temp = new int[fib[pos] - 1];
		System.arraycopy(arr, 0, temp, 0, n);
		for (int i = n; i < temp.length; i++) {
			temp[i] = arr[n - 1];
		}
		
		long start = System.currentTimeMillis();
		//查找
	  int low = 0, high = n - 1;
	  while (low <= high) {
	  	int mid = low + fib[pos - 1] - 1; 
			if (key < temp[mid]) {
				high = --mid;
				pos -= 1;
			}else if (key > temp[mid]) {
				low = ++mid;
				pos -= 2;
			}else {
				if (mid < n) {
				  System.out.println("F Time :" + (System.currentTimeMillis() - start));
					return mid;
				}else {
				  System.out.println("F Time :" + (System.currentTimeMillis() - start));
					return n - 1;
				}
			}
		}
	  System.out.println("F Time :" + (System.currentTimeMillis() - start));
		return -1;
	}

}
