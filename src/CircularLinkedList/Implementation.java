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
		head = insertAtTail(head, 40);
		printCircularLL(head);
		head = deleteFromHead(head);
		printCircularLL(head);
		head = deleteKthNode(head, 3);
		printCircularLL(head);
	}
	
	public static Node deleteKthNode (Node head, int k) {
		if (k == 1) {
			return deleteFromHead(head);
		}
		else {
			Node curr = head;
			for (int i=0; i<k-2; i++) {
				curr = curr.next;
			}
			curr.next = curr.next.next;
			return head;
		}
	}
	
	public static Node deleteFromHead (Node head) {
		if (head.next == head) {
			return null;
		}
		else {
//			Naive solution will be traversing till the end and changing the next pointer
			head.data = head.next.data;
			head.next = head.next.next;
			return head;
		}
	}
	
	public static Node insertAtTail (Node head, int x) {
		Node newNode = new Node(x);
		if (head == null) {
			newNode.next = newNode;
			return newNode;
		}
		else {
//			Naive Solution will be traversing till the end and inserting the newNode there
			int y = head.data;
			head.data = x;
			newNode.data = y;
			newNode.next = head.next;
			head.next = newNode;
			return newNode;
		}
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
		System.out.println("===========");
	}
	
}
class Node {
	int data;
	Node next;
	Node (int data) {
		this.data = data;
	}
}