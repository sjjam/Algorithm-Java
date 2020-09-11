package programmers;

public class PG12904 {//가장 긴 팰린드롬

	public static void main(String[] args) {
		String s = //"abcdcba";
				//"abacde";
				"abcaacba";
		solution(s);
	}

	public static int solution(String s) {
		int answer = 1;
		int N = s.length();
		/*for (int j = i-1; j >= 0; j--) {
		String part = s.substring(j, i);
		String rev = new StringBuffer(s).reverse().toString();
		System.out.println(part +"---"+ rev.substring(j, i));
		if(rev.substring(j, i).equals(part)) {
			if(answer < part.length()) {
				answer = part.length() * 2;
			}
		}
		}*/
		for (int i = 0; i < N - 1; i++) {
			int L = i;
			int R = i + 1;
			int count = 0;
			if(s.charAt(L) == s.charAt(R)) {
				L--;
				R++;
				count += 2;
				while(L >= 0 && R < N) {
					if(s.charAt(L) == s.charAt(R)) {
						count += 2;
						L--;
						R++;
						System.out.println(count);
					}else {
						break;
					}
				}
			}
			if(answer < count) {
				answer = count;
			}
		}
		for (int i = 1; i < N; i++) {
			int L = i - 1;
			int R = i + 1;
			int count = 1;
			while(L >= 0 && R < N) {
				if(s.charAt(L) == s.charAt(R)) {
					count += 2;
					L--;
					R++;
					System.out.println(count);
				}else {
					break;
				}
			}
			if(answer < count) {
				answer = count;
			}
		}
		System.out.println(answer);
		return answer;
	}
}
