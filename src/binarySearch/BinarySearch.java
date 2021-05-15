package binarySearch;
import java.util.*;

public class BinarySearch {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		for (int i=0; i<n; i++)
			arr[i] = scan.nextInt();
		int x = scan.nextInt();
		System.out.println(iterativeBinarySearch(arr, n, x));
		System.out.println(recursiveBinarySearch(arr, x, 0, n-1));
//		Iterative is better because recursive requires extra function call overhead
		scan.close();
	}
	
	public static int iterativeBinarySearch (int[] arr, int n,  int x) {
//		Time Complexity O(log n) & Auxiliary Space of O(1)
		int i = 0, j = n-1;
		while (i <= j) {
			int mid = (i+j)/2;
			if (arr[mid] == x) {
				return mid;
			}
			else if (arr[mid] < x) {
				i = mid+1;
			}
			else {
				j = mid-1;
			}
		}
		return -1;
	}
	
	public static int recursiveBinarySearch (int[] arr,int x, int low, int high) {
//		Time Complexity O(log n) & Auxiliary Space of O(log n)
		int mid = (high+low)/2;
		if (low > high)
			return -1;
		else if (arr[mid] == x)
			return mid;
		else if (arr[mid] < x)
			return recursiveBinarySearch(arr, x, mid+1, high);
		else 
			return recursiveBinarySearch(arr, x, low, mid-1);
	}

}
