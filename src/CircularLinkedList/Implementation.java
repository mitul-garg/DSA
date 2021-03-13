package CircularLinkedList;

public class Implementation {

	public static void main(String[] args) {
		Node head = new Node(10);
		Node second = new Node(20);
		head.next = second;
		Node third = new Node(30);
		second.next = third;
		third.next = head;
		printCircularLL(head);
		head = insertAtHead(head, 5);
		printCircularLL(head);
	}
	
	public static Node insertAtHead (Node head, int x) {
		Node newNode = new Node(x);
		if (head == null)
			newNode.next = newNode;
		else {
//			O(n) approach
//			Node curr = head;
//			while (curr.next != head) {
//				curr = curr.next;
//			}
//			curr.next = newNode;
//			newNode.next = head;
			int y = head.data;
			head.data = x;
			newNode.data = y;
			newNode.next = head.next;
			head.next = newNode;
			return head;
		}
		return newNode;
	}
	
	public static void printCircularLL (Node head) {
		if (head == null)
			return;
//		for loop implementation
//		System.out.println(head.data);
//		for (Node curr = head.next; curr != head; curr=curr.next) {
//			System.out.println(curr.data);
//		}
		Node curr = head;
		do {
			System.out.println(curr.data);
			curr = curr.next;
		} while (curr != head);
		
	}
	
}
class Node {
	int data;
	Node next;
	Node (int data) {
		this.data = data;
	}
}