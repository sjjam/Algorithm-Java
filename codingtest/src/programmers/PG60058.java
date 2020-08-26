package programmers;

public class PG60058 {

	public static void main(String[] args) {
		//String p = "()))((()";
		String p = "()))((()";
		solution(p);
	}
	
	public static String solution(String p) {
        String answer = "";
		answer = properW(p);
		System.out.println(answer + "~~~");
        return answer;
    }
	
	public static String properW(String p) {
		if(p.equals("")) {
			return p;
		}
		String[] split = p.split("");
		String u = "";
		String v = "";
		String result = "";
		int pairL = 0;
		int pairR = 0;
		for (int i = 0; i < split.length; i++) {
			if(split[i].equals("(")){
				pairL++;
				u += split[i];
			}else if(split[i].equals(")")){
				pairR++;
				u += split[i];
			}
			
			if(pairL == pairR && pairL != 0) {
				v = p.substring(i + 1);
				break;
			}
		}
		if(u.charAt(0) == '(') {
			v = properW(v);
			result = u + v;
			return result;
		}else {
			String ch = "";
			for (int i = 1; i < u.length()-1; i++) {
				if(u.charAt(i) == '(') {
					ch += ")";
				}else {
					ch += "(";
				}
			}
			v = properW(v);
			ch = "("+ v +")" + ch;
			result = ch;
		}
		System.out.println(u +" --- " + v);
		return result;
	}

}
