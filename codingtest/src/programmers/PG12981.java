package programmers;

import java.util.ArrayList;
import java.util.List;

public class PG12981 {//영어 끝말잇기

	public static void main(String[] args) {
		int n = 3;
		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		solution(n, words);
	}

	public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int out = 0;
        List<String> prev = new ArrayList<>();
        prev.add(words[0]);
        for (int i = 1; i < words.length; i++) {
			if(prev.size() == 0) {
				prev.add(words[i]);
			}else {
				if(prev.contains(words[i])) {
					out = i + 1;
					break;
				}else {
					System.out.println(prev.get(i-1) + "***" + words[i]);
					if(prev.get(i-1).charAt(prev.get(i-1).length()-1) != words[i].charAt(0)) {
						out = i + 1;
						break;
					}else {
						prev.add(words[i]);
					}
				}
			}
		}
        System.out.println(prev.size() + "/" + out);
        answer[0] = out % n;
        if(out == 0) {
        	answer[0] = 0;
        	answer[1] = 0;
        }else {
        	if(out % n == 0) {
            	answer[0] = n;
            	answer[1] = out/n;
            }else {
            	answer[0] = out % n;
            	answer[1] = out/n + 1;
            }
        }
        System.out.println(answer[0]+"---"+answer[1]);
        return answer;
    }
}
