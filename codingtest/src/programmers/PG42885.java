package programmers;

import java.util.Arrays;

public class PG42885 {

	public static void main(String[] args) {
		//int[] people = {70, 50, 80, 50};
		int[] people = {10, 20, 50, 60, 80, 90};
		int limit = 100;
		solution(people, limit);
	}

	public static int solution(int[] people, int limit) {
        int answer = 0;
        int idx = 0;
        int count = 0;
        Arrays.sort(people);
        for (int i = people.length - 1; i > idx; i--) {
			/*if(people[idx] + people[i] > limit) {
				answer++;
			}else {
				answer++;
				idx++;
			}
			System.out.println(idx);*/
			if(people[idx] + people[i] <= limit) {
				System.out.println(idx+"------"+i);
				count++;
				idx++;
			}
        }
        answer = people.length - count;
        System.out.println(answer+"~~~~~~~");
        return answer;
    }
}
