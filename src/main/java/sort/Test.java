package sort;

import java.util.Arrays;
import java.util.Random;

public class Test {

	public static void main(String[] args) {
		int[] arr = new int[500000];// {33,32,48,55,9,33,40,84};
		produce(arr);
		int[] arr_one = new int[500000];
		System.arraycopy(arr, 0, arr_one, 0, arr.length);
		int[] arr_two = new int[500000];
		System.arraycopy(arr, 0, arr_two, 0, arr.length);
		long start, end;
		
		/*start = System.currentTimeMillis();
		InsertionSort.insert(arr_two);
		end = System.currentTimeMillis();
		System.out.println((end - start) + "..." + check(arr_one));*/
		
		
		
		/*start = System.currentTimeMillis();
		int[] temp = {6, 9, 12, 34 ,4 ,12,2,1231212,-1, 7, 4 ,99,98, 0};
		SelectionSort.select_one(temp);
		end = System.currentTimeMillis();
		System.out.println((end - start) + "..."+ check(temp));*/
		
		start = System.currentTimeMillis();
		//BobbleSort.bobble(arr);
		QuickSort.quick(arr);
		end = System.currentTimeMillis();
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println((end - start) + "..."+ check(arr));
		//
		
		start = System.currentTimeMillis();
		QuickSort.quick_one(arr_two);
		end = System.currentTimeMillis();
		System.out.println((end - start) + "..."+ check(arr));
		
		/*start = System.currentTimeMillis();
		BobbleSort.bobble_two(arr_one);
		end = System.currentTimeMillis();
		System.out.println((end - start) + "..."+ check(arr));*/
	}
	
	private static int[] produce(int[] arr) {
		
		Random random = new Random();
		
		for (int i = 0; i < 500000; i++) {
			arr[i] = random.nextInt(500000);
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

}
