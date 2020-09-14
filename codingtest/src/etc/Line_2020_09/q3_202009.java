package Line_2020_09;

public class q3_202009 {

	public static void main(String[] args) {
		int n = 73425;
		int n2 = 10007;
		solution(n2);
	}

	public static int[] solution(int n) {
        int[] answer = new int[2];
        String temp = "";
        temp = Integer.toString(n);
        int cnt = 0;
        int min = n;
        while(temp.length() != 1) {
        	int minL = temp.length();
        	int sum = 0;
        	for (int i = 1; i < temp.length(); i++) {
				String split = temp.substring(0, i);
				String split1 = temp.substring(i, temp.length());
				if(split1.charAt(0) != '0') {
					System.out.println(split+"---"+split1);
					sum = Integer.parseInt(split) + Integer.parseInt(split1);
					if(Integer.toString(sum).length() <= minL) {
						if(sum < min) {
							minL = Integer.toString(sum).length();
							min = sum;
							System.out.println(minL);
							System.out.println(min);
						}
					}
				}
				System.out.println("------------");
			}
        	temp = Integer.toString(min);
			System.out.println(temp);
			cnt++;
			System.out.println("***************");
        }
        System.out.println(cnt);
        answer[0] = cnt;
        answer[1] = Integer.parseInt(temp);
        return answer;
    }
}
