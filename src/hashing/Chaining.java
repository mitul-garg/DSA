package hashing;
import java.util.*;

public class Chaining {

	public static void main(String[] args) {
		
	}
	
}
class MyHash {
	int BUCKET;
	LinkedList<Integer>[] table;
	
	@SuppressWarnings("unchecked")
	MyHash (int BUCKET) {
		this.BUCKET = BUCKET;
		table = new LinkedList[BUCKET];
	}
	
	int hash (int key) {
		return key%BUCKET;
	}
	
	boolean search (int key) {
		int i = hash(key);
		for (int j : table[i]) {
			if (j == key)
				return true;
		}
		return false;
	}
	
	void insert (int key) {
		int i = hash(key);
		table[i].add(key);
	}
	
	void remove (int key) {
		int i = hash(key);
		table[i].remove(key);
	}
	
}