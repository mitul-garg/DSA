package bitMagic;

public class OddOccurenceCount {

	public static void main(String[] args) {
		int[] arr = {8,8,7,7,2,2,7,7,8};
		System.out.println(findOdd(arr));
		
		// a variation question
		// given an array with values in range [1....n+1]. Every no. appears
		// exactly once. Hence, one no. is missing.
		// find the missing number.
		
		int[] arr1 = {1,4,3};
		int[] arr2 = {1,5,3,2};
		System.out.println(findMissingNumber(arr1));
		System.out.println(findMissingNumber(arr2));
	}
	
	public static int findMissingNumber (int[] arr) {
		int x = 0;
		int n = arr.length;
		for (int i=0; i<n; i++) {
			x = x ^ arr[i] ^ (i+1);
		}
		x ^= (n+1);
		return x;
	}
	
	public static int findOdd (int[] arr) {
		int ans = 0;
		for (int i=0; i<arr.length; i++) {
			ans = ans ^ arr[i];
		}
		return ans;
	}

}
