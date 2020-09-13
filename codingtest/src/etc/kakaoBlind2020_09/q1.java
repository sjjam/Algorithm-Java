package kakaoBlind2020_09;

public class q1 {

	public static void main(String[] args) {
		String new_id = "...!@BaT#*..y.abcdefghijklm";
				//"z-+.^.";
				//"=.=";
		solution(new_id);
	}
	
	public static String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase();
        System.out.println(new_id);
        
        String match = "[^0-9a-z-_.]";
        new_id = new_id.replaceAll(match, "");
        System.out.println(new_id);
        
        String dot2 = "..";
        while(new_id.contains(dot2)) {
        	new_id = new_id.replace("..", ".");
        }
        System.out.println(new_id);
        
        char dot = '.';
        while(new_id.charAt(0) == dot) {
        	if(new_id.length() == 1) {
        		new_id = "";
        		break;
        	}else {
        		new_id = new_id.substring(1,new_id.length());
        	}
        }
        System.out.println(new_id);
        if(new_id.length() >= 1) {
        	while(new_id.charAt(new_id.length() - 1) == dot) {
            	new_id = new_id.substring(0,new_id.length() - 1);
            }
        }
        System.out.println(new_id);
        if(new_id.length() == 0) {
        	new_id = new_id + "a";
        }
        System.out.println(new_id+"//aa");
        if(new_id.length() > 15) {
        	new_id = new_id.substring(0, 15);
        	while(new_id.charAt(0) == dot) {
            	new_id = new_id.substring(1,new_id.length());
            }
            System.out.println(new_id);
            while(new_id.charAt(new_id.length() - 1) == dot) {
            	new_id = new_id.substring(0,new_id.length() - 1);
            }
            System.out.println(new_id);
        }
        if(new_id.length() < 3) {
        	while(new_id.length() < 3) {
        		new_id = new_id + new_id.substring(new_id.length() - 1, new_id.length());
        	}
        }
        System.out.println(new_id+"888");
        answer = new_id;
        return answer;
    }

}
