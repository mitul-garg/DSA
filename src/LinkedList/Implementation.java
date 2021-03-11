package LinkedList;

import java.util.Scanner;

public class Implementation {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long start = System.currentTimeMillis();
		Node head = null;
		for (int i=0;i<100000;i++) {
			Node newNode = new Node(i);
			newNode.next = head;
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start + "ms is the time taken by Linked List Insertion");
		long arrStart = System.currentTimeMillis();
		int[] arr = new int[100000];
		for (int i=0;i<100000;i++) {
			arr[i] = i;
		}
		long arrEnd = System.currentTimeMillis();;
		System.out.println(arrEnd - arrStart + "ms is the time taken by Array Insertion");
		scan.close();
	}
	public static Node reverseLL (Node head) {
		Node curr = head, prev = null;
		while (curr != null) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	public static void findNthTermFromEnd(Node head, int x) {
		if (head == null)
			return;
		Node slow = head, fast = head;
		for (int i=0;i<x;i++) {
			fast = fast.next;
			if (fast == null)
				return;
		}
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		System.out.println(slow.data);
	}
	public static void findMiddle (Node head) {
		if (head == null)
			return;
		Node slow = head, fast = head;
		while ((fast != null) && (fast.next != null)) {
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println(slow.data);
	}
	public static Node insertInSortedLL (Node head, int x) {
		Node newNode = new Node(x), curr = head;
		if (curr == null)
			return newNode;
		if (x < head.data) {
			newNode.next = head;
			return newNode;
		}
		if (curr.next == null) {
			if (curr.data <= newNode.data) {
				curr.next = newNode;
				return curr;
			}
			newNode.next = curr;
			return newNode;
		}
		while (curr.next != null && curr.next.data<x) {
			curr = curr.next;
		}
		newNode.next = curr.next;
		curr.next = newNode;
		return head;
	}
	public static Node insertAtGivenPosition (Node head, int pos, int x) {
		Node newNode = new Node(x);
		if (pos == 1) {
			newNode.next = head;
			return newNode;
		}
		Node curr = head;
		while (pos-2>0 && curr!=null) {
			curr = curr.next;
			pos--;
		}
		if (curr == null)
			return curr;
		newNode.next = curr.next;
		curr.next = newNode;
		return head;
	}
	public static Node deleteFromTail (Node head) {
		if (head == null)
			return head;
		if (head.next == null)
			return head;
		Node curr = head;
		while (curr.next.next != null) {
			curr = curr.next;
		}
		curr.next = null;
		return head;
	}
	public static Node deleteFromFront (Node head) {
		if (head == null)
			return head;
		return head.next;
	}
	public static Node insertAtTail (Node head, int x) {
		Node newNode = new Node(x);
		if (head == null) {
			return newNode;
		}
		Node curr = head;
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = newNode;
		return head;
	}
	public static Node insertAtHead (Node head, int x) {
		Node newNode = new Node(x);
		newNode.next = head;
		return newNode;
	}
	public static void printLinkedList(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
	}
	public static void printLinkedListRecursively (Node head) {
		if (head == null) {
			return;
		}
		System.out.print(head.data + " "); 
		printLinkedList(head.next);
	}
	public static int searchLL (Node head, int x) {
		Node curr = head;
		int pos = 1;
		while (curr != null) {
			if (curr.data == x) 
				return pos;
			else {
				pos++;
				curr = curr.next;
			}
		}
		return -1;
	}
	public static int searchLLRecursively (Node head, int x) {
		if (head == null)
			return -1;
		if (head.data == x)
			return 1;
		if (searchLLRecursively(head.next, x) == -1)
			return -1;
		return searchLLRecursively(head.next, x) + 1;
	}
}
class Node {
	int data;
	Node next;
	Node (int data) {
		this.data = data;
	}
}
