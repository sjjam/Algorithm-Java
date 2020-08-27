package programmers;

public class PG12980 {

	public static void main(String[] args) {
		int n = 5000;
		solution(n);
	}

	public static int solution(int n) {
        int ans = 0;
        while(n != 0) {
        	if(n % 2 == 0) {
        		n /= 2;
        	}else {
        		n--;
        		ans++;
        	}
        }
        System.out.println(ans);
        return ans;
    }
}
