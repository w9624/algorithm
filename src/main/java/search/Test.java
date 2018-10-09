package search;

import java.util.Random;

import impl.Tools;
import sort.QuickSort;

public class Test {

	static final int size = 10;

	public static void main(String[] args) {
		int[] arr = Tools.randomAray(size);
		long start = 0, index = 0;
		int key = new Random().nextInt(size);
		System.out.println("Key: " + key);
		/*// 顺序查找
		start = System.currentTimeMillis();
		index = LinearSearch.search(arr, key);
		System.out.println("Sequence time: " + (System.currentTimeMillis() - start) + " index: " + index);
		// 哈希查找
		HashSearch.store(arr);
		start = System.currentTimeMillis();
		index = HashSearch.search(key);
		System.out.println("Hash time: " + (System.currentTimeMillis() - start) + " index: " + index);

		QuickSort.quick(arr);
		// 二分查找
		start = System.currentTimeMillis();
		BinarySearch.search(arr, key);
		System.out.println("Binary time: " + (System.currentTimeMillis() - start) + " index: " + index);
		// 插值查找
		start = System.currentTimeMillis();
		InsertSearch.search(arr, key);
		System.out.println("Insert time: " + (System.currentTimeMillis() - start) + " index: " + index);
		// 斐波那契查找
		start = System.currentTimeMillis();
		FibonacciSearch.search(arr, key);
		System.out.println("Fibonacci time: " + (System.currentTimeMillis() - start) + " index: " + index);
		// 分块查找
		BlockSearch blockSearch = new BlockSearch(arr, 6);
		start = System.currentTimeMillis();
		blockSearch.search(key);
		System.out.println("Block time: " + (System.currentTimeMillis() - start) + " index: " + index);
		*/// 分块查找
		BST bst = new BST(arr);
		start = System.currentTimeMillis();
		//bst.inOrder();
		System.out.println(bst.root.val);
		bst.inOrder();
		System.out.println("Block time: " + (System.currentTimeMillis() - start) + " index: " + index);
	}

}
