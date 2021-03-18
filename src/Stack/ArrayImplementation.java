package Stack;

public class ArrayImplementation {

	public static void main(String[] args) {
		Stack s = new Stack();
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
class Stack {
	static final int maxSize = 1000;
	int top;
	int arr[] = new int[maxSize];
	
//	default constructor setting value of top as -1 to show that the stack is empty 
	Stack() {
		this.top = -1;
	}
	
	boolean isEmpty() {
		if (top < 0)
			return true;
		else
			return false;
	}
	
	void push(int data) {
		if (top >= maxSize) {
			System.out.println("Stack Full");
		}
		else {
			top++;
			arr[top] = data;
			System.out.println(data + " pushed onto the Stack");
		}
	}
	
	int pop () {
		if (top < 0) {
			System.out.println("Stack is Empty");
			return 0;
		}
		else {
			int x = arr[top];
			top--;
			return x;
		}
	}
	
	int peek() {
		if (top < 0) {
			System.out.println("Stack is Empty");
			return -1;
		}
		else {
			return arr[top];
		}
	}
}