package sorting;

public class Sorting {

	public static void main(String[] args) {
		int[] arr = {1, 2, 4, 10, 9, 7, 3, 2, 1};
		printArray(arr);
//		bubbleSort(arr);
//		optimisedBubbleSort(arr);
//		selectionSort(arr);
//		insertionSort(arr);
//		int[] arr1 = {1, 2, 4, 7, 10};
//		int[] arr2 = {2, 3, 5, 6, 11};
//		mergeSortedArrays(arr1, arr2);
//		mergeSort(arr, 0, arr.length-1);
		printArray(arr);
	}
	
//	public static void mergeSort (int[] arr, int low, int high) {
//	O(nlogn) Time and O(n) Aux Space
//		if (low < high) {
//			int mid = low + (high - low)/2; // this is to avoid overflow on large values
//			mergeSort(arr, low, mid);
//			mergeSort(arr, mid+1, high);
//			merge(arr, low, mid, high);
//		}
//	}
	
	public static void mergeSortedArrays(int[] arr1, int[] arr2) {
		int n = arr1.length, m = arr2.length, i, j, k;
		int[] ans = new int[n+m];
		for (i=0,j=0,k=0; i<n && j<m;) {
			if (arr1[i]<arr2[j]) {
				ans[k] = arr1[i];
				i++;
				k++;
			}
			else {
				ans[k] = arr2[j];
				j++;
				k++;
			}
		}
		while (i < n) {
			ans[k] = arr1[i];
			i++; 
			k++;
		}
		while (j < m) {
			ans[k] = arr2[j];
			j++; 
			k++;
		}
		printArray(ans);
	}
	
	public static void insertionSort (int[] arr) {
		int n = arr.length;
		for (int i=1; i<n; i++) {
			int key = arr[i];
			int j = i-1;
			while (j>=0 && arr[j]>key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
	}
	
	public static void selectionSort (int[] arr) {
	// Time Complexity of O(n^2)
		int n = arr.length;
		for (int i=0; i<n-1; i++) {
			int min = i;
			for (int j=i+1; j<n; j++) {
				if (arr[j] < arr[min])
					min = j;
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}
	
	public static void optimisedBubbleSort (int[] arr) {
	// When the array is sorted, it will take linear time
		int n = arr.length;
		for (int i=0; i<n-1; i++) {
			boolean swap = false;
			for (int j=0; j<n-i-1; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swap = true;
				}
			}
			if (swap == false) {
				break;
			}
		}
	}
	public static void bubbleSort (int[] arr) {
	// Time Complexity of O(n^2)
		int n = arr.length;
		for (int i=0; i<n-1; i++) {
			for (int j=0; j<n-i-1; j++) {
				if (arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	public static void printArray (int[] arr) {
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
