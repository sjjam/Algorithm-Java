package Line_2020_09;

import java.util.ArrayList;
import java.util.List;

public class q2_202009 {

	public static void main(String[] args) {
		int[] ball = {1, 2, 3, 4, 5, 6};
		int[] order = {6, 2, 5, 1, 4, 3};
		
		int[] ball2 = {11, 2, 9, 13, 24};
		int[] order2 = {9, 2, 13, 24, 11};
		solution(ball2, order2);
	}
	
	public static int[] solution(int[] ball, int[] order) {
        int[] answer;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < ball.length; i++) {
			list.add(ball[i]);
		}
        
        List<Integer> tmp = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < order.length; i++) {
			if(order[i] == list.get(0)) {
				ans.add(list.get(0));
				list.remove(0);
				delay(tmp, list, ans);
			}else if(order[i] == list.get(list.size()-1)) {
				ans.add(list.get(list.size()-1));
				list.remove(list.size()-1);
				delay(tmp, list, ans);
			}else {
				tmp.add(order[i]);
			}
		}
        for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i));
		}
        answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
			answer[i] = ans.get(i);
		}
        return answer;
    }
	
	public static void delay(List<Integer> tmp, List<Integer> list, List<Integer> ans) {
		if(tmp.size() != 0) {
			for (int j = 0; j < tmp.size(); j++) {
				if(tmp.get(j) == list.get(0)) {
					ans.add(list.get(0));
					tmp.remove(j);
					list.remove(0);
					delay(tmp, list, ans);
				}else if(tmp.get(j) == list.get(list.size()-1)) {
					ans.add(list.get(list.size()-1));
					tmp.remove(j);
					list.remove(list.size()-1);
					delay(tmp, list, ans);
				}
			}
		}
	}
}
