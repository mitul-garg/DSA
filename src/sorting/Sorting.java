package sorting;

import java.util.ArrayList;
import java.util.Collections;

// Heap Sort karna hei abhi, yaad rkhna

public class Sorting {

	public static void main(String[] args) {
		int[] arr = {1, 2, 4, 10, 9, 7, 3, 2, 1};
//		int[] arr = {65, 80, 30, 90, 40, 50, 70};
		printArray(arr);
//		bubbleSort(arr);
//		optimisedBubbleSort(arr);
//		selectionSort(arr);
//		insertionSort(arr);
//		int[] arr1 = {1, 2, 4, 7, 10};
//		int[] arr2 = {2, 3, 5, 6, 11};
//		mergeSortedArrays(arr1, arr2);
//		mergeSort(arr, 0, arr.length-1);
//		naivePartition(arr, 5, 0, 8);
//		lomutoPartition(arr, 0, 6, 3);
//		hoarePartition(arr, 0, 6, 1);
//		qSortLomuto(arr, 0, 6);
//		qSortHoare(arr, 0, 6);
//		countingSort(arr, 9, 11);
//		radixSort(arr);
		bucketSort(arr, 4);
		printArray(arr);
	}
	
	public static void bucketSort (int[] arr, int k) {
		int n = arr.length;
		int max_val = arr[0];
		for (int i=1; i<n; i++) 
			max_val = Math.max(max_val, arr[i]);
		max_val++; // so that the appropriate indexes for maximum elements exist
		ArrayList<ArrayList<Integer>> bkt = new ArrayList<>();
		for (int i=0; i<k; i++) {
			bkt.add(new ArrayList<>());
		}
		for (int i=0; i<n; i++) {
			int bi = (k*arr[i])/max_val;
			bkt.get(bi).add(arr[i]);
		}
		for (int i=0; i<k; i++) {
			Collections.sort(bkt.get(i));
		}
		int index = 0;
		for (int i=0; i<k; i++) {
			for (int j=0; j<bkt.get(i).size(); j++) {
				arr[index++] = bkt.get(i).get(j);
			}
		}
	}
	
	public static void radixSort (int[] arr) {
		int n = arr.length;
		int mx = arr[0];
		for (int i=1; i<n; i++) {
			if (arr[i] > mx)
				mx = arr[i];
		}
		for (int exp=1; mx/exp>0; exp*=10) {
			countingSortForRadixSort(arr,n,exp);
		}
	}
	public static void countingSortForRadixSort (int[] arr, int n, int exp) {
		int[] count = new int[10], output = new int[n];
		for (int i=0; i<n; i++) {
			count[(arr[i]/exp)%10]++;
		}
		for (int i=1; i<10; i++) {
			count[i] = count[i] + count[i-1];
		}
		for (int i=n-1; i>=0; i--) {
			output[count[(arr[i]/exp)%10]-1] = arr[i];
			count[(arr[i]/exp)%10]--;
		}
		for (int i=0; i<n; i++) {
			arr[i] = output[i];
		}
	}
	
	public static void countingSort (int[] arr, int n, int k) {
		// Time Complexity and Auxiliary Space of O(n+k)
		int[] count = new int[k];
		for (int i=0; i<n; i++) 
			count[arr[i]]++;
//		printArray(count);
		// number of smaller or equal elements than the current element
		for (int i=1; i<k; i++) 
			count[i] = count[i-1] + count[i];
		int[] output = new int[n];
		// loop is reversed in order to maintain stablitiy of the sort
		for (int i=n-1; i>=0; i--) {
			output[count[arr[i]]-1] = arr[i];
			count[arr[i]]--;
		}
		for (int i=0; i<n; i++) {
			arr[i] = output[i];
		}
	}
	
	public static void qSortHoare (int[] arr, int l, int h) {
		if (l < h) {
			int p = hoarePartition(arr, l, h);
			qSortLomuto(arr, l, p);
			qSortLomuto(arr, p+1, h);
		}
	}
	public static void qSortLomuto (int[] arr, int l, int h) {
		if (l < h) {
			int p = lomutoPartition(arr, l, h);
			qSortLomuto(arr, l, p-1);
			qSortLomuto(arr, p+1, h);
		}
	}
	public static int hoarePartition (int[] arr, int l, int h, int p) {
//		pivot element index is given so we swap it with first element and perform the normal hoare partition
		int temp = arr[l];
		arr[l] = arr[p];
		arr[p] = temp;
		return hoarePartition(arr, l, h);
	}
	public static int hoarePartition (int[] arr, int l, int h) {
		int pivot = arr[l]; //Considering the first element always as pivot
		int i = l-1, j = h+1;
		while (true) {
			do {
				i++;
			} while(arr[i] < pivot);
			do {
				j--;
			} while (arr[j] > pivot);
			if (i >= j) {
				return j;
			}
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
	public static int lomutoPartition (int[] arr, int l, int h, int p) {
//		pivot element index is given so we swap it with last element and perform the normal lomuto partition
		int temp = arr[h];
		arr[h] = arr[p];
		arr[p] = temp;
		return lomutoPartition(arr, l, h);
	}
	public static int lomutoPartition (int[] arr, int l, int h) {
//		O(n) Time and O(1) Aux Space
		int pivot = arr[h]; //Considering the last element always as pivot
		int i = l-1;
		for (int j=l; j<=h-1; j++) {
			if (arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1] = arr[h];
		arr[h] = temp;
		return (i+1);
	}
	public static void naivePartition (int[] arr, int p, int l, int h) {
//		O(nlogn) Time and O(n) Aux Space
		int[] temp = new int[h-l+1];
		int index = 0;
		for (int i=l; i<=h; i++) {
			if (arr[i] <= arr[p]) {
				temp[index++] = arr[i];
			}
		}
		for (int i=l; i<=h; i++) {
			if (arr[i] > arr[p]) {
				temp[index++] = arr[i];
			}
		}
		for (int i=l; i<=h; i++) {
			arr[i] = temp[i];
		}
	}
	
	public static void mergeSort (int[] arr, int low, int high) {
//	O(nlogn) Time and O(n) Aux Space
		if (low < high) {
			int mid = low + (high - low)/2; // this is to avoid overflow on large values
			mergeSort(arr, low, mid);
			mergeSort(arr, mid+1, high);
			merge(arr, low, mid, high);
		}
	}
	public static void merge (int arr[], int low, int mid, int high) {
//		O(n) Time and O(n) Aux Space
		int n1 = mid-low+1, n2 = high-mid;
		int[] left = new int[n1], right = new int[n2];
		for (int i=0; i<n1; i++) {
			left[i] = arr[low+i];
		}
		for (int j=0; j<n2; j++) {
			right[j] = arr[mid+1+j]; 
		}
		int i=0, j=0, k=low;
		while (i<n1 && j<n2) {
			if (left[i]<=right[j]) { //equals sign is important for stability of the algorithm
				arr[k++] = left[i++];
			}
			else {
				arr[k++] = right[j++];
			}
		}
		while (i < n1) {
			arr[k++] = left[i++];
		}
		while (j < n2) {
			arr[k++] = right[j++];
		}
	}
	
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
