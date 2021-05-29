package bitMagic;

public class PowerOf2 {

	public static void main(String[] args) {
		System.out.println(naive(1));
		System.out.println(isPow2(2));
	}
	
	public static boolean isPow2 (int n) {
		return n != 0 && ((n & (n-1)) == 0);
	}
	public static boolean naive (int n) {
		if (n == 0)
			return false;
		while (n != 1) {
			if (n%2 != 0)
				return false;
			n /= 2;
		}
		return true;
	}

}
