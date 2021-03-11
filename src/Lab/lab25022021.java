package Lab;

public class lab25022021 {

	public static void main(String[] args) {
		String a = "1111111111111111111111111111111111111111111111";
		String b = "2222222222222222222222222222222222222222222222222222";
		System.out.println(largeNumber.add(a, b));
	}

}
class largeNumber {
	
	// static methods so that we can access them without creating objects 
	
	public static String diff (String a, String b) {
		
		// answer string
		String ans = "";
		
		// considering string a is larger than string b
		
		// storing lengths of strings
//		int n1 = a.length(), n2 = b.length();
		
		//reversing the strings
		a = new StringBuilder(a).reverse().toString();
		b = new StringBuilder(b).reverse().toString();
		
		// carry from side elements
		
		return ans;
	}
	
	public static String add (String a, String b) {
		// answer strings
		String ans = "";
		
		// reversing the strings
		a = new StringBuilder(a).reverse().toString();
		b = new StringBuilder(b).reverse().toString();
		
		int carry = 0, sum;
		
		//length of both the strings
		int n1 = a.length(), n2 = b.length();
		
		for (int i=0;i<n1;i++) {
			sum = ((int)(a.charAt(i)-'0') + (int)(b.charAt(i)-'0') + carry);
			
			// storing the sum after converting it into a character
			ans += (char)(sum%10 + '0');
			
			// changing carry for next digit
			carry = sum/10;
		}
		
		//assuming length of string b greater than string a
		for (int i=n1;i<n2;i++) {
			sum = ((int)(b.charAt(i) - '0') + carry);  
	        ans += (char)(sum%10 + '0');  
	        carry = sum/10; 
		}
		
		// remaining carry
		if (carry > 0) {
			ans += (char)(carry + '0');
		}
		
		ans = new StringBuilder(ans).reverse().toString();
		
		return ans;
	}
}