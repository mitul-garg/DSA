package Queue;

public class LLImplementation {

	public static void main(String[] args) {
		LLQueue q = new LLQueue();
		q.deque();
		q.enque(10);
		q.enque(20);
		q.deque();
		q.enque(40);
		q.enque(50);
		q.enque(60);
		q.enque(70);
		System.out.println(q.getFront() + " " + q.getRear() + " " + q.size);
		
		for (Node curr=q.front;curr!=null;curr=curr.next) {
			System.out.println(curr.data);
		}
	}

}
class LLQueue {
	Node front, rear;
	int size;
	
	boolean isEmpty() {
		return (front == null);
	}
	
	void enque(int x) {
		if (isEmpty()) {
			front = new Node(x);
			rear = front;
			size++;
			System.out.println(x + " added to the Queue");
			return;
		}
		Node newNode = new Node(x);
		rear.next = newNode;
		rear = newNode;
		size++;
		System.out.println(x + " added to the Queue");
	}
	
	void deque() {
		if (isEmpty()) {
			System.out.println("Queue is Empty");
			return;
		}
		int x = front.data;
		front = front.next;
		System.out.println(x + " removed from the Queue");
	}
	
	int getFront() {
		return front.data;
	}
	int getRear() {
		return rear.data;
	}
}
class Node {
	int data;
	Node next;
	Node(int data) {
		this.data = data;
	}
}