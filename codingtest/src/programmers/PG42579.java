package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PG42579 {//베스트앨범

	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		String[] genres1 = {"classic","classic","classic","classic","pop"};
		int[] plays1 = {500,150,800,800,2500};
		solution(genres1, plays1);
	}

	public static int[] solution(String[] genres, int[] plays) {
        int[] answer;
        
        HashMap<Integer, Integer> numPlay = new HashMap<>();
        HashMap<Integer, String> numGen = new HashMap<>();
        for (int i = 0; i < plays.length; i++) {
			numPlay.put(i, plays[i]);
			numGen.put(i, genres[i]);
			System.out.println(i+"---"+numGen.get(i)+"---"+numPlay.get(i));
		}
        
        HashMap<String, Integer> genSum = new HashMap<>();        
        for (int i = 0; i < plays.length; i++) {
        	if(!genSum.containsKey(genres[i])) {
        		genSum.put(genres[i], plays[i]);
        	}else {
        		genSum.put(genres[i], genSum.get(genres[i])+plays[i]);
        	}
		}
        
        List<Integer> ans = new ArrayList<>();
        Iterator<String> keys = sortByValue(genSum).iterator();
        while (keys.hasNext()){
            String key = keys.next();
            System.out.println("KEY : " + key +" / "+ "VAL : " + genSum.get(key));
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < numGen.size(); i++) {
				if(numGen.get(i).equals(key)) {
					temp.add(plays[i]);
					Collections.sort(temp, Collections.reverseOrder());
				}
			}
            int cnt = 0;
            for (int i = 0; i < temp.size(); i++) {
				System.out.println(temp.get(i));
				for (int j = 0; j < numPlay.size(); j++) {
					if(temp.get(i).equals(numPlay.get(j))) {
						if(numGen.get(j).equals(key)) {
							ans.add(j);
							cnt++;
							System.out.println(cnt+"***");
						}
					}
					if(cnt == 2) break;
				}
				if(cnt == 2) break;
			}
        }
        
        answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i));
			answer[i] = ans.get(i);
		}
        return answer;
    }
	
	// 별도의 스태틱 함수로 구현
	public static List sortByValue(final Map map) {
		List<String> list = new ArrayList();
		list.addAll(map.keySet());

		Collections.sort(list, new Comparator() {

			public int compare(Object o1, Object o2) {
				Object v1 = map.get(o1);
				Object v2 = map.get(o2);

				return ((Comparable) v2).compareTo(v1);
			}

		});
		//Collections.reverse(list); // 주석시 오름차순
		return list;

	}
}
