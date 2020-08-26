package programmers;

public class PG17687 {

	public static void main(String[] args) {
		int n = 16;
		int t = 16;
		int m = 2;
		int p = 1;
		solution(n, t, m, p);
	}

	public static String solution(int n, int t, int m, int p) {
        String answer = "";
    	String ch = "";
    	String cnLine = "0";
    	for (int i = 1; i < t*m; i++) {
    		ch = changeN(n, i);
			cnLine += ch;
		}
    	System.out.println(cnLine);
    	for (int i = p-1; i < cnLine.length(); i += m) {
			char word = cnLine.charAt(i);
			answer += word;
			if(answer.length() == t)
				break;
		}
        System.out.println(answer);
        return answer;
    }
	
	public static String changeN(int n, int i) {
		String r = "";
		String ch = "";
		while(i != 0) {
			if(i%n >= 10) {
				char s = (char)(i%n + 55);
				ch = s + ch;
			}else {
				r = i%n + "";
				ch = r + ch;
			}
			i = i/n;
		}
		System.out.println(ch+"***");
		return ch;
	}
}
