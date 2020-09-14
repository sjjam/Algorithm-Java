package Line_2020_09;

public class q1_202009 {

	public static void main(String[] args) {
		int[][] boxes = {{1, 2}, {2, 1}, {3, 3}, {4, 5}, {5, 6}, {7, 8}};
		solution(boxes);
	}

	public static int solution(int[][] boxes) {
        int answer = -1;
        /*for (int i = 0; i < boxes.length; i++) {
			for (int j = 0; j < 2; j++) {
				Arrays.sort(boxes[i]);
				System.out.print(boxes[i][j]);
			}
			System.out.println();
		}*/
        for (int i = 0; i < boxes.length; i++) {
        	if(boxes[i][0] == boxes[i][1]) {
        		boxes[i][0] = 0;
        		boxes[i][1] = 0;
        	}
		}
        for (int i = 0; i < boxes.length; i++) {
			if(boxes[i][0] != boxes[i][1]) {
				for (int j = i+1; j < boxes.length; j++) {
					if(boxes[i][0] == boxes[j][0]) {
						int tmp = 0;
						tmp = boxes[j][0];
						boxes[j][0] = boxes[i][1];
						boxes[i][1] = tmp;
					}else if(boxes[i][0] == boxes[j][1]) {
						int tmp = 0;
						tmp = boxes[j][1];
						boxes[j][1] = boxes[i][1];
						boxes[i][1] = tmp;
					}else if(boxes[i][1] == boxes[j][0]) {
						int tmp = 0;
						tmp = boxes[j][0];
						boxes[j][0] = boxes[i][0];
						boxes[i][0] = tmp;
					}else if(boxes[i][1] == boxes[j][1]) {
						int tmp = 0;
						tmp = boxes[j][1];
						boxes[j][0] = boxes[i][0];
						boxes[i][0] = tmp;
					}
				}
			}
		}
        System.out.println("--------------------------");
        for (int i = 0; i < boxes.length; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(boxes[i][j]);
			}
			System.out.println();
		}
        int cnt = 0;
        for (int i = 0; i < boxes.length; i++) {
        	if(boxes[i][0] != boxes[i][1]) {
        		cnt++;
        	}
		}
        answer = cnt;
        System.out.println(cnt);
        return answer;
    }
}
