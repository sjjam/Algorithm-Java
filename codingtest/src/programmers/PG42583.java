package programmers;

import java.util.LinkedList;

public class PG42583 {

	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7,4,5,6};
		solution(bridge_length, weight, truck_weights);
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int time = 0;
        LinkedList<Integer> qu = new LinkedList<Integer>();
        int sum = 0;
        int idx = 0;
        int[] timeSave = new int[truck_weights.length];
        while(true) {
        	time++;
        	if(!qu.isEmpty()) {
        		for (int i = 0; i < idx; i++) {
        			if(time == timeSave[i] + bridge_length) {
        				sum -= qu.peek();
                		qu.remove();
                		timeSave[i] = 0;
                		System.out.println(sum +"/"+ time +"/"+ idx + "***********");
                	}
				}
        	}
        	if(idx != truck_weights.length) {
        		sum += truck_weights[idx];
        		System.out.println("ttttttttttt");
	        	if(sum <= weight) {
	        		qu.add(truck_weights[idx]);
	        		timeSave[idx] = time;
	        		idx++;
	        		System.out.println(sum +"/"+ time +"/"+ idx);
	        	}else {
	        		sum -= truck_weights[idx];
	        		System.out.println(sum +"/"+ time +"/"+ idx + "else");
	        	}
        	}
        	if(idx == truck_weights.length && qu.isEmpty()) {
        		break;
        	}
        	System.out.println(sum +"/"+ time +"/"+ idx);
        	System.out.println("---------------------------------");
        }
        for (int i = 0; i < timeSave.length; i++) {
			System.out.println(timeSave[i]);
		}
        answer = time;
        System.out.println(answer);
        return answer;
    }
}