package sort;

import java.util.Arrays;
import java.util.Random;

import impl.Tools;

public class Test {

	public static void main(String[] args) {
		int[] arr = new int[1000000];//{7, 7, 8, 6, 4, 1, 8, 9, 2, 9};////{44,23,34,33,66,22,23,56,54,32, 45}; 
		produce(arr);
		Tools.display(arr);
		int[] arr_one = arr.clone();
		int[] arr_two = arr.clone();
		long start, end;
		
		start = System.currentTimeMillis();
		QuickSort.quick(arr_two);
		end = System.currentTimeMillis();
		System.out.println((end - start) + "...");
		
		
		/*start = System.currentTimeMillis();
		int[] temp = {6, 9, 12, 34 ,4 ,12,2,1231212,-1, 7, 4 ,99,98, 0};
		SelectionSort.select_one(temp);
		end = System.currentTimeMillis();
		System.out.println((end - start) + "..."+ check(temp));*/
		
		start = System.currentTimeMillis();
		//BobbleSort.bobble(arr);
		HeapSort.heap(arr);
		end = System.currentTimeMillis();
		
		/*for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}*/
		System.out.println((end - start) + "...");
		//
		
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
		
		for (int i = 0; i < 100000; i++) {
			arr[i] = random.nextInt(1000000);
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
