package kakaoBlind2020_09;

public class q3 {

	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150",
				"python frontend senior chicken 210",
				"python frontend senior chicken 150",
				"cpp backend senior pizza 260",
				"java backend junior chicken 80",
				"python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200",
				"cpp and - and senior and pizza 250",
				"- and backend and senior and - 150",
				"- and - and - and chicken 100",
				"- and - and - and - 150"};
		solution(info, query);
	}
	
	public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        String[] que = new String[6];
        for (int i = 0; i < query.length; i++) {
        	int match = 0;
        	int cnt = 0;
        	String[] split = query[i].split(" ");
        	que[0] = split[0];
        	que[1] = split[2];
        	que[2] = split[4];
        	que[3] = split[6];
        	que[4] = split[7];
        	for (int j = 0; j < que.length-1; j++) {
				System.out.print(que[j] + " ");
				if(que[j].equals("-")) {
					cnt++;
				}
			}
        	que[5] = Integer.toString(5-cnt);
        	System.out.print(que[5]);
        	System.out.println();
			for (int j = 0; j < info.length; j++) {
				int cnt2 = 0;
				String[] splitIn = info[j].split(" ");
				for (int j2 = 0; j2 < que.length - 2; j2++) {
					System.out.println(info[j]+"***"+ que[j2]);
					if(info[j].contains(que[j2])) {
						cnt2++;
					}
				}
				if(Integer.parseInt(splitIn[4]) >= Integer.parseInt(que[4])) {
	        		cnt2++;
	        		System.out.println(cnt2);
	        	}
	        	if(cnt2 == Integer.parseInt(que[5])) {
	        		match++;
	        	}
			}
			answer[i] = match;
		}
        for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
        return answer;
    }

}
