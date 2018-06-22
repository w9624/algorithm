package datastructure.impl;

public interface Sequence {
	boolean insert(int index, int key);
	
	int get(int index);
	
	int delete(int key);
	
	int update(int key);
}
