package search;

import static org.hamcrest.CoreMatchers.nullValue;

import sort.QuickSort;

/**
 * Q:无法理解，既然能给他分块，若要是算法时间复杂度足够简单 那么数组应当是有序的，既然数组是有序的，二分查找不是更快？
 * A:分块可以使用平均值的方法或者排序找出值，分块之后可以使用链表进行存储使得插入删除变得简单
 * 
 * @author wangrz
 *
 */
public class BlockSearch {

	// 默认分为4块
	private int bs = 4;
	// 数组
	private int[] arr;
	// 索引表
	private Index[] index;

	/**
	 * @param arr
	 */
	public BlockSearch(int[] arr) {
		this.arr = arr;
		block();
	}

	/**
	 * @param arr
	 * @param bs
	 */
	public BlockSearch(int[] arr, int bs) {
		this(arr);
		this.bs = bs;
		block();
	}

	/**
	 * 进行分块
	 */
	private void block() {
		QuickSort.quick(arr);
		index = new Index[bs];
		int step = (arr.length - 1) / bs;
		for (int i = 0; i < bs - 1; i++) {
			int val = arr[step * (i + 1)];
			index[i] = new Index(val, null);
		}
		index[index.length - 1] = new Index(arr[arr.length - 1], null);
		for (int i : arr) {
			insert(i);
		}
	}

	/**
	 * 插入值
	 * 
	 * @param val
	 */
	public void insert(int val) {
		int mid = find(val);
		if (index[mid].point == null) {
			index[mid].point = new Node(val);
		} else {
			Node p = index[mid].point;
			Node n = new Node(val);
			n.next = p.next;
			p.next = n;
		}
	}

	/**
	 * @return
	 * 
	 */
	private int find(int val) {
		// 对索引进行二分查找
		int low = 0, high = index.length - 1;
		int mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (val == index[mid].val) {
				break;
			} else if (val < index[mid].val) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		if (low >= high) {
			mid = low;
		}
		return mid;
	}

	/**
	 * 分块查找，默认分为4块
	 * 
	 * @param arr
	 * @param key
	 * @param index
	 * @return
	 */
	public int search(int key) {
		int mid = find(key);
		if (index[mid].val == key) {
			return mid;
		}else {
			Node p = index[mid].point;
			while (p != null) {
				if (p.val == key) {
					return index[mid].val; 
				}
				p = p.next;
			}
		}
		return -1;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("分块输出：\n");
		for (int i = 0; i < index.length; i++) {
			Node p = index[i].point;
			sb.append("index: " + index[i].val + "：");
			while (p != null) {
				sb.append(p.val + " ");
				p = p.next;
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}

final class Index {
	int val;
	Node point;

	public Index(int val, Node point) {
		this.val = val;
		this.point = point;
	}
}

class Node {
	int val;
	Node next;

	public Node(int val) {
		this.val = val;
	}
}
