package bitMagic;

public class NumberOfSetBits {
	
	public static void main(String[] args) {
		System.out.println(naiveApproach(7));
		System.out.println(brianKerningam(7));
		initialize();
		System.out.println(lookUpTableBased(7));
	}
	
	
	// preprocessing for lookup table
	static int[] table = new int[256];
	static void initialize () {
			table[0] = 0;
			for (int i=1; i<256; i++) {
				table[i] = (i&1) + table[i/2];
			}
	}
	public static int lookUpTableBased (int n) {
		// thetha(1)
		// 0xff is eight set bits
		int ans = table[(n & 0xff)];
		n = (n>>8);
		ans += table[(n & 0xff)];
		n = (n>>8);
		ans += table[(n & 0xff)];
		n = (n>>8);
		ans += table[(n & 0xff)];
		return ans;
	}
	public static int brianKerningam (int n) {
		// Time Complexity is thetha(no. of set bits in n)	
		int ans = 0;
		while (n > 0) {
			n = (n & (n-1));
			ans++;
		}
		return ans;
	}
	
	public static int naiveApproach (int n) {
		// Time Complexity is thetha(no. of bits in n)		
		int ans = 0;
		while (n > 0) {
			ans += (n&1);
			n = (n>>1);
		}
		return ans;
	}

}
