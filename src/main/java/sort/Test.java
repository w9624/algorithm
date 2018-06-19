package sort;

import java.util.Arrays;
import java.util.Random;

import javax.tools.Tool;

import impl.Tools;

public class Test {

	public static void main(String[] args) {
		int[] arr =   new int[20000000];////{44,23,34,33,66,22,23,56,54,32, 45};
		produce(arr);
		//Tools.display(arr);
		int[] arr_one = arr.clone();
		int[] arr_two = arr.clone();
		long start, end;
		
		/*start = System.currentTimeMillis();
		QuickSort.quick(arr_two);
		end = System.currentTimeMillis();
		System.out.println((end - start) + "..." + Tools.isOrderAsc(arr_two));*/
		//Tools.display(arr_two);
		
		/*int[] array = {7, 7, 8, 6, 4, 1, 8, 9, 2, 9};
		MergeSort.merge(array);
		Tools.display(array);*/
		
		start = System.currentTimeMillis();
		int[] temp = {6, 9, 12, 34 ,4 ,12,2,1231212, 7, 4 ,99,98, 0};
		BucketSort.bucket_one(temp);
		end = System.currentTimeMillis();
		System.out.println((end - start) + "..." + Tools.isOrderAsc(temp));
		
		/*start = System.currentTimeMillis();
		//BobbleSort.bobble(arr);
		ShellSort.shell(arr, 3);
		end = System.currentTimeMillis();
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println((end - start) + "...");*/
		/*int[][] nums = new int[48][2];
		int[][] arrs = clone(arr_two, 50);
		for (int i = 2; i < 50; i++) {
			start = System.currentTimeMillis();
			//BobbleSort.bobble(arr);
			ShellSort.shell(arrs[i]);
			end = System.currentTimeMillis();
			nums[i - 2][0] = 10000 / i;
			nums[i - 2][1] = (int) (end - start);
			//System.out.println((10000 / i) + "......" + (end - start));
		}*/
		
		/*for (int i = 0; i < nums.length; i++) {
			if (nums[i][0] % 3 == 0) {
				System.out.println("3......" + nums[i][0] + "......" + nums[i][1]);
			}else if (nums[i][0] % 2 == 0) {
				System.out.println("2......" + nums[i][0] + "......" + nums[i][1]);
			}else {
				System.out.println("1......" + nums[i][0] + "......" + nums[i][1]);
			}
			
		}*/
		
		/*start = System.currentTimeMillis();
		SelectionSort.select_one(arr_two);
		end = System.currentTimeMillis();
		System.out.println((end - start) + "..."+ check(arr_two));*/
		
		/*start = System.currentTimeMillis();
		BobbleSort.bobble_two(arr_one);
		end = System.currentTimeMillis();
		System.out.println((end - start) + "..."+ check(arr));*/
	}
	
	private static int[] produce(int[] arr) {
		
		Random random = new Random();
		
		for (int i = 0; i < 20000000; i++) {
			arr[i] = random.nextInt(20000000);
		}
		return arr;
	}
	
	private static boolean check(int[] arr) {
		
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					System.out.println(Arrays.toString(arr));
					System.out.println(arr[i] + " > " +arr[j]);
					return false;
				}
			}
		}
		return true;
	}
	
	private static int[][] clone(int[] arr, int num) {
		int[][] arrs = new int[num][10000];
		for (int i = 0; i < num; i++) {
			arrs[i] = arr.clone();
		}
		return arrs;
	}

}
