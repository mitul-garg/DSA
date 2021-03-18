package Stack;

public class LinkedListImplementation {

	public static void main(String[] args) {
		StackLL s = new StackLL();
		s.pop();
		s.peek();
		s.push(50);
		s.push(40);
		s.peek();
		s.push(30);
		while(!s.isEmpty()) {
			System.out.println(s.peek());
			s.pop();
		}
		System.out.println(s.peek());
	}

}
class StackLL {
	Node head = null;
	
	boolean isEmpty() {
		if (head == null)
			return true;
		else 
			return false;
	}
	
	void push (int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		}
		else {
			newNode.next = head;
			head = newNode;
		}
		System.out.println(data + " pushed onto the Stack");
	}
	
	int pop() {
		if (head == null) {
			System.out.println("Stack is Empty");
			return -1;
		}
		else {
			int x = head.data;
			head = head.next;
			return x;
		}
	}
	
	int peek() {
		if (head == null) {
			System.out.println("Stack is Empty");
			return -1;
		}
		else {
			return head.data;
		}
	}
}
class Node {
	int data;
	Node next;
	Node(int data) {
		this.data = data;
	}
}