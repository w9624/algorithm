package sort;

import impl.Tools;

public class RadixSort {
	
	public static void radix(int[] arr) {
		int n = arr.length;
		int len = (Tools.max(arr, 0, n - 1) + "").length();
		int[] num = new int[10], pos = new int[10];
		int[] tempArr = arr.clone();
		
		for (int i = 0; i < len; i++) {
			int k = 1;
			for (int j = 0; j < i; j++) {
				k *= 10;
			}
			for (int j = 0; j < n; j++) {
				num[(tempArr[j] / k) % 10]++;
			}
			int temp = 0;
			for (int j = 1; j <= num.length; j++) {
				pos[j-1] = temp;
				if (num[j-1] != 0) {
					temp = temp + num[j - 1];
				}
			}
			
			//写入缓存数组
			/*int p = 0;
			for (int j = 0; j < n; j++) {
				tempArr[j] = arr[p];
				p = pos[i] + num[]
				
			}*/
			/*int po = 0;
			for (int j = 0; j < num.length; j++) {
				if (num[j] != 0) {
					int p = pos[j];
					for (int m = 0; m < num[j]; m++) {
						tempArr[po++] = arr[p + m];
						System.out.println(arr[p + m] + ",");
					}
				}
			}*/
			int[] array = tempArr.clone();
			for (int j = 0; j < n; j++) {
				int t = tempArr[j] % k;
				
			}
			Tools.display(tempArr);
		}
		
	}

}
