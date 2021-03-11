package Search;

public class InsertInSortedArray {

	public static void main(String[] args) {
		int[] a = new int[100];
		a[0] = 1; a[1] = 3; a[2] = 4;
		a[3] = 5; a[4] = 6;
		
		int n = 5;
		n = insert(a,2,n);
		System.out.println(binarySearch(a, 2));
		for (int i=0;i<n;i++) {
			System.out.println(a[i]);
		}
	}
	public static int insert(int[] a, int x, int n) {
		int i;
		for (i=n-1; i>=0 && a[i]>x ; i-- ) {
			a[i+1] = a[i];
		}
		a[i+1] = x;
		return ++n;
	}
	public static int binarySearch (int[] a, int x) {
		int low = 0;
		int high = a.length;
		while (low < high) {
			int i = (high + low)/2 ;
			if (a[i] == x) {
				return i;
			}
			else if (a[i] < x) {
				low = i+1;
			}
			else {
				high = i;
			}
		}
		return -1;
	}
}
