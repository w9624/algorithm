/**
 * 
 */
package sort;

import impl.Tools;
import vo.Node;

/**
 * @author Administrator
 * @since 2018
 */
public class BucketSort {

	public static void bucket(int[] arr) {
		int n = arr.length;
		int[] min_max = Tools.max_min_Value(arr);
		int count = (min_max[1] - min_max[0]) / n + 1;
		int[][] buckets = new int[count][n];
		int[] index = new int[count];
		
		for (int i = 0; i < n; i++) {
			buckets[(arr[i] - min_max[0]) / n][index[count]++] = arr[i];
		}
		
		for (int i = 0; i < buckets.length; i++) {
			InsertionSort.insert(buckets[i], 0, index[i]);
		}
		
		for (int i = 0; i < index[0]; i++) {
			System.out.println(buckets[0][i]);
		}
		
	}
	
}
