package Stack;
import java.util.Stack;
public class BalancedParanthesis {

	public static void main(String[] args) {
		String str = "((())";
		System.out.println(check(str));
	}
	public static Boolean check(String str) {
		Stack<Character> s = new Stack<Character>();
		for (int i=0;i<str.length();i++) {
			if (str.charAt(i)=='(' || str.charAt(i)=='{' || str.charAt(i)=='[') { 
				s.push(str.charAt(i));
//				System.out.println(s.peek());
			}
			else { 
				if (s.isEmpty() == true) 
					return false;
				else if (matching(s.peek(),str.charAt(i)) == false)
					return false;
				else
					s.pop();
			}
		}
		return s.isEmpty();
	}
	public static Boolean matching (char a, char b) {
//		System.out.println(a + " " + b);
//		System.out.println((a=='(' && b==')') || (a=='{' && b=='}') || (a=='[' && b==']'));
		return ((a=='(' && b==')') || (a=='{' && b=='}') || (a=='[' && b==']'));
	}
}
