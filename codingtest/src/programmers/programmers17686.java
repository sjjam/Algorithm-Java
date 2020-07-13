package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class programmers17686 {

	public static void main(String[] args) {
		//String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		String[] files = {"A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat", "F-010bar020.zip"};
		solution(files);
	}
	
	public static String[] solution(String[] files) {
		String[] answer = {};
		Comparator<String> myComparator = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				System.out.println(o1+"--------------"+o2);
				String Hd1 = o1.split("[0-9]")[0];
				String Hd2 = o2.split("[0-9]")[0];
				String Head1 = (o1.split("[0-9]")[0]).toLowerCase();
				String Head2 = (o2.split("[0-9]")[0]).toLowerCase();
				o1 = o1.replace(Hd1, "");
				o2 = o2.replace(Hd2, "");
				if(Head1.compareTo(Head2) > 0) {
					return 1;
				}else if(Head1.compareTo(Head2) == 0) {
					o1 = o1.replaceAll("[^0-9]", "!");
					o2 = o2.replaceAll("[^0-9]", "!");
					String num1 = "";
					for (int i = 0; i < o1.length(); i++) {
					    char ch = o1.charAt(i);
					    if (48 <= ch && ch <= 57) {
					        num1 += ch;
					    }else {
					    	break;
					    }
					}
					System.out.println(num1+"!!!!!!!!!!!!!!!!!!!1");
					String num2 = "";
					for (int i = 0; i < o2.length(); i++) {
					    char ch = o2.charAt(i);
					    if (48 <= ch && ch <= 57) {
					        num2 += ch;
					    }else {
					    	break;
					    }
					}
					System.out.println(num2+"!!!!!!!!!!!!!!!!!!!1");
					int Number1 = Integer.parseInt(num1);
					int Number2 = Integer.parseInt(num2);
					System.out.println(Number1 + "---------" + Number2);
					return Number1 - Number2;
				}
				return -1;
			}
		};
		
		Arrays.sort(files, myComparator);
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i]);
		}
		answer = files;
		//String array = files[0].split("[0-9]")[0];
		//System.out.println(array);
        return answer;
    }

}