package hashing;
public class Chaining {

	public static void main(String[] args) {
		int a[]= {15,11,27,8,12};
		MyHash hash = new MyHash(7);
		for(int i=0;i<5;i++)
		{
			hash.insert(a[i]);
		}
		hash.printHash();
		System.out.println(hash.search(15));
		hash.remove(11);
		hash.printHash();
	}
	
}
class MyHash {
	int BUCKET;
	Node[] table = new Node[BUCKET];
	
	MyHash (int BUCKET) {
		this.BUCKET = BUCKET;
		table = new Node[BUCKET];
	}
	
	int hash (int key) {
		return key%BUCKET;
	}
	
	boolean search (int key) {
		int i = hash(key);
		Node curr = table[i];
		while (curr != null) {
			if (curr.data == key) 
				return true;
			else
				curr = curr.next;
		}
		return false;
	}
	
	void remove (int key) {
		int i = hash(key);
		if (table[i] == null)
			return;
		if (table[i].next == null) {
			table[i] = null;
			return;
		}
		Node curr = table[i];
		while (curr.next.next != null) {
			curr = curr.next;
		}
		curr.next = null;
	}
	
	void insert (int key) {
		int i = hash(key);
		Node newNode = new Node(key);
		if (table[i] == null) {
			table[i] = newNode;
			return;
		}
		Node curr = table[i];
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = newNode;
	}
	
	void printHash () {
		for (int i=0; i<BUCKET; i++) {
			if (table[i] != null) {
				Node curr = table[i];
				while (curr != null) {
					System.out.print(curr.data + " ");
					curr = curr.next;
				}
			}
		}
		System.out.println();
	}
	
}
class Node {
	int data;
	Node next;
	Node (int data) {
		this.data = data;
	}
}