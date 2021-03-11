package Search;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4,5,6};
		System.out.println(binarySearch(a,1));
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
