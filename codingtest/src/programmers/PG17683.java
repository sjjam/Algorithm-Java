package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class PG17683 {//¹æ±Ý±×°î

	public static void main(String[] args) {
		String m = //"ABCDEFG";
			//"ABC";
				//"A#";
				"CCB";
		String[] musicinfos = //{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
			//{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
			//{"13:00,13:02,HAPPY,B#A#"};
			{"03:00,03:10,FOO,CCB#CCB"};
		solution(m, musicinfos);
	}

	public static String solution(String m, String[] musicinfos) {
        String answer = "";
        List<String> play = new ArrayList<String>();
        HashMap<Integer, Integer> anslist = new HashMap<>();
        for (int i = 0; i < musicinfos.length; i++) {
			String[] split = musicinfos[i].split(",");
			int time = 0;
			String[] start = split[0].split(":");
			String[] end = split[1].split(":");
			time = (Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1])) - (Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]));
			String[] code = split[3].split("");
			int plustime = 0;
			for (int j = 0; j < code.length; j++) {
				if(code[j].equals("#")) {
					plustime++;
				}
			}
			String pcode = "";
			int cnt = 0;
			for (int j = 0; j < code.length; j++) {
				if(cnt == time + plustime) {
					break;
				}
				pcode += code[j];
				cnt++;
				if(j == code.length - 1) {
					j = -1;
				}
			}
			play.add(pcode);
			if(play.get(i).contains(m)) {
				if(m.contains("#")) {
					anslist.put(i, time);
				}else {
					String sub = "";
					sub = play.get(i).replaceAll(m+"#", "");
					if(sub.contains(m)) {
						anslist.put(i, time);
					}
				}
			}
		}
        System.out.println(play);
        System.out.println(anslist);
        int longtime = 0;
        if(anslist.size() == 0) {
        	answer = "(None)";
        }else {
        	Iterator<Integer> it = anslist.keySet().iterator();
            while(it.hasNext()){
            	int key = it.next();
                if(longtime < anslist.get(key)) {
					longtime = anslist.get(key);
					String[] split = musicinfos[key].split(",");
					answer = split[2];
				}
            }
        }
        System.out.println(answer);
        return answer;
    }
}
