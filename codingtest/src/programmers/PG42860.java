package programmers;

public class PG42860 {

	public static void main(String[] args) {
		String name = "BBBBAAAAB";
		String name1 = "BBAAABBBB";
		solution(name1);
	}

	public static int solution(String name) {
        int answer = 0;
        //65~90
        for (int i = 0; i < name.length(); i++) {
        	int count = 0;
			char ch = name.charAt(i);
			if(ch <= 'N') {
				count = ch - 'A';
			}else {
				count = 'Z' - ch + 1;
			}
			System.out.println(count);
			answer += count;
		}
        int length=name.length();
        int min=length-1;

        for(int i=0;i<length;i++){
            int next=i+1;
            while(next<length && name.charAt(next)=='A'){
                next++;
                System.out.println(next+"---------"+i);
            }                
            min=Math.min(min,i+length-next+Math.min(i,length-next));
            System.out.println(min+"~~~");
        }
        answer += min;
        /*if(name.charAt(1) == 'A') {
        	int numA = 0;
        	for (int i = 2; i < name.length(); i++) {
				if(name.charAt(i) == 'A') {
					numA++;
				}else {
					break;
				}
			}
        	answer += name.length() - 2 - numA;
        }else if(name.charAt(2) == 'A') {
        	int numA = 0;
        	for (int i = 2; i < name.length(); i++) {
				if(name.charAt(i) == 'A') {
					numA++;
				}else {
					break;
				}
			}
        	answer += name.length() - numA;
        }else if(name.charAt(name.length() - 1) == 'A') {
        	int numA = 0;
        	for (int i = name.length() - 2; i >= 0; i--) {
        		if(name.charAt(i) == 'A') {
					numA++;
				}else {
					break;
				}
			}
        	answer += name.length() - 2 - numA;
        }else if(name.charAt(name.length() - 2) == 'A') {
        	int numA = 0;
        	for (int i = name.length() - 2; i >= 0; i--) {
        		if(name.charAt(i) == 'A') {
					numA++;
				}else {
					break;
				}
			}
        	answer += name.length() - numA;
        }else {
        	answer += name.length() - 1;
        }*/
        System.out.println(answer);
        return answer;
    }
}
