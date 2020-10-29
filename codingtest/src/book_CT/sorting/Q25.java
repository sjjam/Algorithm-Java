package book_CT.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Q25 {

	public static void main(String[] args) {
		int N = 5;
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		solution(N, stages);
	}

	public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int length = stages.length;
        HashMap<Integer, Double> result = new HashMap<>();
        
        for (int i = 1; i < N + 1; i++) {
        	double cnt = 0;
        	double per = 0.0;
			for (int j = 0; j < stages.length; j++) {
				if(stages[j] == i) {
					cnt++;
				}
			}
			if(cnt == 0) {
				per = 0.0;
			}else {
				per = (double) (cnt / length);
			}
			result.put(i, per);
			length -= cnt;
		}
        System.out.println(result);
        List<Integer> ans = new ArrayList<>(result.keySet());
        Collections.sort(ans, (o1, o2) -> result.get(o2).compareTo(result.get(o1)));
        for(int i = 0; i < N; i++) {
        	answer[i] = ans.get(i);
        }
        return answer;
    }
}

// Ç®ÀÌ

class Node implements Comparable<Node> {

    private int stage;
    private double fail;

    public Node(int stage, double fail) {
        this.stage = stage;
        this.fail = fail;
    }

    public int getStage() {
        return this.stage;
    }

    @Override
    public int compareTo(Node other) {
        if (this.fail == other.fail) {
            return Integer.compare(this.stage, other.stage);
        }
        return Double.compare(other.fail, this.fail);
    }
}

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        ArrayList<Node> arrayList = new ArrayList<>();
        int length = stages.length;

        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == i) {
                    cnt += 1;
                }
            }

            double fail = 0;
            if (length >= 1) {
                fail = (double) cnt / length;
            }

            arrayList.add(new Node(i, fail));
            length -= cnt;
        }

        Collections.sort(arrayList);

        for (int i = 0; i < N; i++) {
            answer[i] = arrayList.get(i).getStage();
        }
        return answer;
    }
}
