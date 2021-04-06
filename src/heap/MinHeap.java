package heap;

public class MinHeap {
	
	int[] arr;
	int size;
	int capacity;
	MinHeap(int capacity) {
		this.capacity = capacity;
		arr = new int[capacity];
		size = 0;
	}
	int left (int i) {
		return (2*i+1);
	}
	int right (int i) {
		return (2*i+2);
	}
	int parent(int i) {
		return (i-1)/2;
	}
	
	void addItem (int x) {
		// This method is just for filling the array initially for testing
		arr[size++] = x;
	}
	
	void printHeap () {
		for (int i=0;i<size;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	void insertInHeap (int x) {
		if (size == capacity) {
			System.out.println("Heap is Full");
			return;
		}
		arr[size] = x;
		for (int i=size;arr[i]<arr[this.parent(i)];i=this.parent(i)) {
			int temp = arr[i];
			arr[i] = arr[this.parent(i)];
			arr[this.parent(i)] = temp;
		}
		size++;
	}
	
//	void minHeapify (int[] arr) {
//	Iterative approach but corner cases not handled 
//		for (int i=0;(2*i+2)<arr.length;i++) {
//			int x = Math.min(arr[i],Math.min(arr[2*i+1], arr[2*i+2]));
//			if (x == arr[i])
//				continue;
//			else if (x == arr[2*i+1]) {
//				int temp = arr[2*i+1];
//				arr[2*i+1] = arr[i];
//				arr[i] = temp;
//			}
//			else {
//				int temp = arr[2*i+2];
//				arr[2*i+2] = arr[i];
//				arr[i] = temp;
//			}
//		}
//	}
	
	void minHeapify (int i) {
		// Time Complexity O(log n) & Auxiliary Space is O(h)
		int lf = this.left(i), rt = this.right(i);
		int smallest = i;
		if (lf<size && arr[lf]<arr[i])
			smallest = lf;
		if (rt<size && arr[rt]<arr[smallest])
			smallest = rt;
		if (smallest != i) {
			int temp = arr[smallest];
			arr[smallest] = arr[i];
			arr[i] = temp;
			minHeapify(smallest);
		}
	}
	
	int extractMinimum (MinHeap h) {
		// Time Complexity O(n) & Auxiliary Space O(h)
		if (h.size == 0) {
			return Integer.MAX_VALUE;
		}
		if (h.size == 0) {
			h.size--;
			return h.arr[0];
		}
		int x = h.arr[0];
		int temp = h.arr[h.size-1];
		h.arr[h.size-1] = h.arr[0];
		h.arr[0] = temp;
		h.size--;
		h.minHeapify(0);
		return x;
	}
	
	static void decreaseKey (MinHeap h, int i, int x) {
		// Time Complexity is O(log n)
		h.arr[i] = x;
		while (i != 0 && h.arr[h.parent(i)] > h.arr[i]) {
			int temp = h.arr[h.parent(i)];
			h.arr[h.parent(i)] = h.arr[i];
			h.arr[i] = temp;
			i = h.parent(i);
		}
	}
	
	void deleteIndex (MinHeap h, int i) {
		// Time Complexity is O(log n)
		decreaseKey(h, i, Integer.MIN_VALUE);
		h.extractMinimum(h);
	}
	
	void buildHeap () {
		// Time Complexity is O(n), though it looks like O(nLogn) 
		for (int i=(size-2)/2;i>=0;i--) {
			minHeapify(i);
		}
	}
	
	public static void main(String[] args) {
		MinHeap h = new MinHeap(10);
		h.addItem(40);
		h.addItem(50);
		h.addItem(100);
		h.addItem(25);
		h.addItem(45);
		h.addItem(10);
		h.addItem(20);
		h.addItem(15);
		h.printHeap();
		h.buildHeap();
		h.printHeap();
		h.insertInHeap(12);
		h.insertInHeap(0);
		h.printHeap();
		h.minHeapify(0);
		System.out.println(h.extractMinimum(h));
		h.printHeap();
		decreaseKey(h, 7, 5);
		decreaseKey(h, 5, 9);
		h.printHeap();
		h.deleteIndex(h, 8);
		h.printHeap();
		h.deleteIndex(h, 3);
		h.printHeap();
		
		System.out.println("=================================");
		
		MinHeap h1 = new MinHeap(10);
		h1.addItem(40);
		h1.addItem(20);
		h1.addItem(30);
		h1.addItem(35);
		h1.addItem(25);
		h1.addItem(80);
		h1.addItem(32);
		h1.addItem(100);
		h1.addItem(70);
		h1.addItem(60);
		h1.printHeap();
		h1.minHeapify(0);
		h1.printHeap();
	}

}
