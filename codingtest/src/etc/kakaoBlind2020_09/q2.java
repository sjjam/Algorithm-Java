package kakaoBlind2020_09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class q2 {

	public static void main(String[] args) {
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
			//{"XYZ", "XWY", "WXA"};
		int[] course = {2, 3, 4};
		solution(orders, course);
	}
	static List<String> com = new ArrayList<String>();
	public static String[] solution(String[] orders, int[] course) {
        String[] answer;
        List<String> ans = new LinkedList<String>();
        for (int i = 0; i < orders.length; i++) {
			int n = orders[i].length();
			for (int j = 2; j <= n; j++) {
				int r = j;
				int[] comArr = new int[r];
				String[] split = orders[i].split("");
				combination(comArr, n, r, 0, 0, split);
			}
			System.out.println("--------------");
		}
        System.out.println("*****************************");
        for (int i = 0; i < com.size(); i++) {
			System.out.println(com.get(i));
		}
        HashMap<String, Integer> cnt = new HashMap<String, Integer>();
        
        for(int i = 0 ; i < com.size() ; i++){
            if (cnt.containsKey(com.get(i))) {
                cnt.put(com.get(i), cnt.get(com.get(i))  + 1);
            } else {
                cnt.put(com.get(i) , 1);
            }
        }
        System.out.println(cnt);
        
        
        Iterator<String> keys = cnt.keySet().iterator();
        for (int i = 0; i < course.length; i++) {
			int len = course[i];
			HashMap<String, Integer> temp = new HashMap<String, Integer>();
			while (keys.hasNext()){
	            String key = keys.next();
	            //System.out.println("KEY : " + key +" / "+ "VAL : " + cnt.get(key));
	            if(key.length() == len && cnt.get(key) >= 2) {
	            	temp.put(key, cnt.get(key));
	            }
	        }
			Iterator it = sortByValue(temp).iterator();
			int max = 0;
			while (it.hasNext()) {
				String tmp = (String) it.next();
				System.out.println(tmp + " = " + temp.get(tmp));
				if(temp.get(tmp) >= max) {
					max = temp.get(tmp);
					ans.add(tmp);
				}
			}
			keys = cnt.keySet().iterator();
		}
        answer = new String[ans.size()];
        Collections.sort(ans);
        for (int i = 0; i < ans.size(); i++) {
			answer[i] = ans.get(i);
			System.out.println(answer[i]);
		}
        return answer;
    }
	
	public static void combination(int[] combArr, int n, int r, int index, int target, String[] arr){
        if(r == 0){
        	String temp = "";
            for(int i=0; i<index; i++) {
            	System.out.print(arr[combArr[i]] + " ");
            	temp += arr[combArr[i]];
            }
            System.out.println();
            char[] temp2 = temp.toCharArray();
            Arrays.sort(temp2);
            temp = new String(temp2);
            com.add(temp);
        }else if(target == n){ 
             
            return;
         
        }else{
            combArr[index] = target;
            combination(combArr, n, r-1, index+1, target+1, arr);
            combination(combArr, n, r, index, target+1, arr); 
        }
    }
	
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
