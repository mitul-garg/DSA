import java.util.*;
public class Ayush {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		char[] arr = str.toCharArray();
		int count = 0;
		for (int i=0;i<arr.length;i++) {
			if (arr[i] == 32) {
				count++;
			}
		}
		char[] arr1 = new char[20];
		String[] ans = new String[count+1];
		int j = 0, l = count; 
		for (int i=0;i<arr.length;i++) {
			if (arr[i] != 32) {
				arr1[j] = arr[i];
				j++;
			}
			else {
				String str1 = "";
				for (int k=0;k<j;k++) {
					str1 += arr1[k];
				}
				ans[l] = str1;
				l--;
				j = 0;
			}
		}
		String str1 = "";
		for (int k=0;k<j;k++) {
			str1 += arr1[k];
		}
		ans[l] = str1;
		String finalAnswer = "";
		for (int i=0;i<ans.length;i++) {
			finalAnswer += ans[i] + " ";
		}
		System.out.println(finalAnswer);
		scan.close();
	}

}
