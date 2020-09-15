package programmers;

import java.util.ArrayList;
import java.util.List;

public class PG42842 {

	public static void main(String[] args) {
		int brown = 10;
		int yellow = 2;
		solution(brown, yellow);
	}

	public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int N = 0;
        int M = 0;
        int sum = brown + yellow;
        List<Integer> divisor = new ArrayList<Integer>();
        for (int i = 1; i <= sum; i++) {
			if(sum % i == 0) {
				divisor.add(i);
				System.out.println(i);
			}
		}
        System.out.println("-------------------");
        
        for (int i = 0; i < divisor.size(); i++) {
			for (int j = 0; j < divisor.size(); j++) {
				if(divisor.get(i) * divisor.get(j) == sum) {
					int tmp = (divisor.get(i)-2) * (divisor.get(j)-2);
					System.out.println(divisor.get(i) + "-------" + divisor.get(j) + "-------" + tmp);
					if(tmp == yellow) {
						N = divisor.get(i);
						M = divisor.get(j);
						break;
					}
				}
			}
		}
        answer[0] = N;
        answer[1] = M;
        System.out.println(answer[0]+"---"+answer[1]);
        return answer;
    }
	
}
