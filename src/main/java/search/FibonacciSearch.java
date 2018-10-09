package search;

import impl.Complexity;
import impl.Search;

/**
 * 
 * @author ^_^
 * 斐波拉契查找
 * 前提：顺序存储，键值有序
 * 步骤：
 * 1. 获取斐波拉契数组
 * 2. 获取比数组长度大的F(k)-1
 * 3. 构造数组temp[f(k) - 1]，将多余部分填充为temp[n-1]
 * 4. 对数组查找进行斐波那契划分
 * F[k]-1:划分的时候去除一个f[k - 1]，左边为f[k - 1] - 1,右边为f[k-2] - 1
 */
public class FibonacciSearch implements Search{
	
	/**
	 * 斐波拉契查找
	 * @param arr
	 * @param key
	 * @return
	 */
	@Complexity(time = "log n", space = "0", ASL="log n")
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
					return mid;
				}else {
					return n - 1;
				}
			}
		}
		return -1;
	}

}
