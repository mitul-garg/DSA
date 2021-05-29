package bitMagic;

public class PowerSet {

	public static void main(String[] args) {
		String str = "abcf";
		powerSet(str);
	}
	
	public static void powerSet (String str) {
		// thetha (2^n * n) is Time Complexity
		int n = str.length();
		int powSize = (int)Math.pow(2, n);
		for (int counter=0; counter<powSize; counter++) {
			for (int i=0; i<n; i++) {
				if ( (counter & (1<<i)) != 0 )
					System.out.print(str.charAt(i));
			}
			System.out.println();
		}
	}
}
