package sorting;

public class Sorting {

	public static void main(String[] args) {
		int[] arr = {1, 2, 4, 10, 9, 7, 3, 2, 1};
		printArray(arr);
//		bubbleSort(arr);
//		optimisedBubbleSort(arr);
		selectionSort(arr);
		printArray(arr);
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
