package bitMagic;

public class KthBitSetOrNot {

	public static void main(String[] args) {
		System.out.println(KthBitLeftShift(13, 3));
		System.out.println(KthBitRightShift(13, 3));
	}
	
	public static boolean KthBitLeftShift (int n, int k) {
		if ((n & (1<<(k-1))) != 0)
			return true;
		else
			return false;
	}
	public static boolean KthBitRightShift (int n, int k) {
		if ((1 & (n>>(k-1))) == 1)
			return true;
		else
			return false;
	}
}
