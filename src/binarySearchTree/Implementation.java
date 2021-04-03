package binarySearchTree;

import java.util.Stack;

public class Implementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(15);
		root.left = new Node(5);
		root.left.left = new Node(3);
		root.right = new Node(20);
		root.right.left = new Node(18);
		root.right.right = new Node(80);
		root.right.left.left = new Node(16);
		
		System.out.println(bstSearch(root, 16));
		
		System.out.println(recursiveBSTSearch(root, 26));
		
		iterativeInorder(root);
		root = insertInBST(root, 90);
		root = recursiveInsertInBST(root, 10);
		iterativeInorder(root);
		deleteInBST(root, 20);
		iterativeInorder(root);
		System.out.println(root.right.key);
	}
	
	static void iterativeInorder (Node root) {
		// Time Complexity O(n) and Auxiliary Space O(h)
		Stack<Node> s = new Stack<Node>();
		Node curr = root;
		while ((curr!=null) || (s.isEmpty()==false)) {
			while (curr != null) {
				s.push(curr);
				curr = curr.left;
			}
			curr = s.pop();
			System.out.print(curr.key + " ");
			curr = curr.right;
		}
		System.out.println();
	}
	
	static Node deleteInBST (Node root, int x) {
		// Time Complexity is O(h) and Auxiliary Space is O(h)
		if (root == null)
			return null;
		else if (root.key < x) 
			root.right = deleteInBST(root.right, x);
		else if (root.key > x)
			root.left = deleteInBST(root.left, x);
		else {
			if (root.right == null)
				return root.left;
			else if (root.left == null)
				return root.right;
			else {
				Node succ = getSucc(root);
				root.key = succ.key;
				root.right = deleteInBST(root.right, succ.key);
			}
			return root;
		}
		return root;
	}
	static Node getSucc (Node root) {
		Node curr = root.right;
		while (curr.left!=null) {
			curr = curr.left;
		}
		return curr;
	}
	
	static Node recursiveInsertInBST (Node root, int x) {
		// Insertions always happen at the bottom
		// Time Complexity is O(h) & Auxiliary Space is O(h) & requires extra function call overhead
		// Therefore, Iterative Approach is better
		if (root == null)
			return new Node(x);
		if (root.key < x)
			root.right = recursiveInsertInBST(root.right, x);
		else if (root.key > x)
			root.left = recursiveInsertInBST(root.left, x);
		return root;
	}
	
	static Node insertInBST (Node root, int x) {
		// Insertions always happen at the bottom
		// Time Complexity is O(h) and Auxiliary Space is O(1)
		Node newNode = new Node(x);
		if (root == null) {
			return newNode;
		}
		Node curr = root, prev = curr;
		while (curr != null) {
			prev = curr;
			if (curr.key == x) {
				return root;
			}
			else if (curr.key < x) {
				curr = curr.right;
			}
			else {
				curr = curr.left;
			}
		}
		if (prev.key < x) {
			prev.right = newNode;
		}
		else {
			prev.left = newNode;
		}
		return root;
	}
	
	static boolean recursiveBSTSearch (Node root, int x) {
		// Time Complexity is O(h) & Auxiliary Space is O(h) & requires extra function call overhead
		// Therefore, Iterative Approach is better
		if (root == null)
			return false;
		else if (root.key == x)
			return true;
		else if (x < root.key)
			return recursiveBSTSearch(root.left, x);
		else
			return recursiveBSTSearch(root.right, x);
	}
	
	static boolean bstSearch (Node root, int x) {
		// Time Complexity is O(h) & Auxiliary Space is O(1) 
		Node curr = root;
		while (curr != null) {
			if (curr.key == x) 
				return true;
			else if (x < curr.key)
				curr = curr.left;
			else 
				curr = curr.right;
		}
		return false;
	}

}
class Node {
	Node left, right;
	int key;
	Node (int key) {
		this.key = key;
	}
}