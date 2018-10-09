package search;

import impl.Complexity;
import impl.Search;

/**
 * 
 * @author ^_^
 * 顺序查找
 */
public class LinearSearch implements Search{

	/**
	 * 在任意状态数组查找key
	 * @param arr
	 * @param key
	 * @return
	 */
	@Complexity(time="n", space="0", ASL="(n+1)/2")
	public static int search(int[] arr, int key) {
		for (int i = 0; i < arr.length; i++) {  //ASL=1/n(1+2+...+n)=(n+1)/2
			if (arr[i] == key) {  
				return i;
			}
		}
		return -1;
	}
	
}
