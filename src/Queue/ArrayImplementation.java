package Queue;

public class ArrayImplementation {

	public static void main(String[] args) {
		ArrayQueue q = new ArrayQueue(4);
		q.deque();
		q.enque(10);
		q.enque(20);
		q.deque();
		q.enque(40);
		q.enque(50);
		q.enque(60);
		q.enque(70);
		System.out.println(q.getFront() + " " + q.getRear() + " " + q.size);
		
		for (int i=0;i<q.capacity;i++) {
			System.out.println(q.arr[i]);
		}
	}

}
class ArrayQueue {
	int size, capacity;
	int[] arr;
	
	int front, rear = -1;
	
	ArrayQueue (int capacity) {
		this.capacity = capacity;
		size = 0;
		arr = new int[capacity]; 
	}
	
	boolean isFull() {
		return (size == capacity);
	}
	
	boolean isEmpty() {
		return (size == 0); 
	}
	
	void enque (int x) {
		if (isFull()) {
			System.out.println("Queue is full");
			return;
		}
//		arr[size] = x;
//		rear is also equal to (front+size-1)%capacity
		rear = (rear+1) % capacity;
		arr[rear] = x;
		size++;
		System.out.println(x + " added to the Queue");
	}
	
	void deque () {
		if (isEmpty()) {
			System.out.println("Queue is Empty");
			return;
		}
		int x = arr[0];
		front = front + 1;
//		for (int i=0;i<size-1;i++) {
//			arr[i] = arr[i+1];
//		}
		size--;
		System.out.println(x + " removed from the Queue");
	}
	
	int getFront() {
		if (isEmpty()) 
			return -1;
		return arr[front];
	}
	
	int getRear() {
		if (isEmpty())
			return -1;
		return arr[rear];
	}
}