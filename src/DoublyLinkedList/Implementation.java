package DoublyLinkedList;

public class Implementation {

	public static void main(String[] args) {
		Node head = null; 
		printLL(head);
		head = insertAtHead(head,20);
		printLL(head);
		head = insertAtHead(head,10);
		printLL(head);
		head = insertAtTail(head, 30);
		printLL(head);
		head = insertAtTail(head, 40);
		printLL(head);
		head = reverseLL(head);
		printLL(head);
		System.out.println(head.data + " Verifies that head is changed");
		System.out.println("=============");
		head = deleteFromHead(head);
		printLL(head);
		head = deleteFromTail(head);
		printLL(head);
	}
	
	public static Node deleteFromTail (Node head) {
		if (head == null || head.next == null)
			return null;
		Node curr;
		for (curr=head; curr.next.next != null; curr=curr.next) {
			
		}
		curr.next = null;
		return head;
	}
	
	public static Node deleteFromHead (Node head) {
		if (head == null || head.next == null) {
			return null;
		}
		head.next.prev = null;
		return head.next;
	}
	
	public static Node reverseLL (Node head) {
		if (head.next == null)
			return head;
		Node curr = head;
		while (curr.next != null) {
			Node temp = curr.next;
			curr.next = curr.prev;
			curr.prev = temp;
			curr = curr.prev;
		}
		Node temp = curr.next;
		curr.next = curr.prev;
		curr.prev = temp;
		return curr;
	}
	
	public static Node insertAtTail (Node head, int x) {
		Node newNode = new Node(x);
		if (head == null) {
			return newNode;
		}
		Node curr;
		for (curr=head; curr.next!=null; curr=curr.next) {	
			
		}
		newNode.prev = curr;
		curr.next = newNode;
		return head;
	}
	
	public static Node insertAtHead (Node head, int x) {
		Node newNode = new Node(x);
		if (head == null) {
			return newNode;
		}
		newNode.next = head;
		head.prev = newNode;
		return newNode;
	}
	
	public static void printLL (Node head) {
		for (Node curr=head; curr!=null; curr=curr.next) {
			System.out.println(curr.data);
		}
		System.out.println("=============");
	}
}
class Node {
	int data;
	Node next;
	Node prev;
	Node (int data) {
		this.data = data;
	}
}

// Circular Doubly Linked List has tail.next = head and head.prev = tail and the operations can
// be done in a similar way.