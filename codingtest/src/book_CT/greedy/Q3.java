package book_CT.greedy;

import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		String s = key.next();
		int ans = 0;
		
		int count0 = 0;
		int count1 = 0;
		
		if(s.charAt(0) == '1') {
			count0++;
		}else {
			count1++;
		}
		
		for (int i = 0; i < s.length() - 1; i++) {
			if(s.charAt(i) != s.charAt(i + 1)) {
				if(s.charAt(i + 1) == '1') {
					count0++;
				}else {
					count1++;
				}
			}
		}
		
		ans = Math.min(count0, count1);
		System.out.println(ans);
	}

}
