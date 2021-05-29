package bitMagic;

public class TwoOddOccuring {

	public static void main(String[] args) {
		int[] arr = {3,4,3,4,5,4,4,6,7,7};
		oddAppearing(arr);
	}

	public static void oddAppearing (int[] arr) {
		int n = arr.length, x = 0, ans1 = 0, ans2 = 0;
		for (int i=0; i<n; i++) {
			x = x ^ arr[i];
		}
		int setBit = x & ~(x-1);	// rightmost set bit
		for (int i=0; i<n; i++) {
			if ((arr[i] & setBit) != 0)
				ans1 = ans1 ^ arr[i];
			else
				ans2 = ans2 ^ arr[i];
		}
		System.out.println(ans1 + " " + ans2);
	}
}
