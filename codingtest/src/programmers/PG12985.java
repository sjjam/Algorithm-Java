package programmers;

public class PG12985 {

	public static void main(String[] args) {
		int n = 8;
		int a = 4;
		int b = 5;
		solution(n, a, b);
	}

	public static int solution(int n, int a, int b) {
        int answer = 0;
        int round = 1;
        int small = 0;
        int big = 0;
        System.out.println(a+"*********"+b);
        small = Math.min(a, b);
        big = Math.max(a, b);
        System.out.println(small+"*********"+big);
        while(big - small != 1 || small%2 == 0) {
        	if(small%2 == 0) {
        		small /= 2;
        	}else {
        		small = small/2 + 1;
        	}
        	if(big%2 == 0) {
        		big /= 2;
        	}else {
        		big = big/2 + 1;
        	}
        	round++;
        	System.out.println(small+"------"+big+"------"+round);
        }
        answer = round;
        System.out.println(answer);
        return answer;
	      //1,2/3,4/5,6/7,8
	      //small = 4, big = 5일 때,
	      // > while문 (X)
	      // > big-samll = 1, samll%2 = 0 -> if문 (O)
	      // > round => 2
	      // > 원래 답은 3
    }
}
