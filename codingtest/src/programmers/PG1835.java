package programmers;

import java.util.LinkedList;

public class PG1835 {

	public static void main(String[] args) {
		int n = 2;
		String[] data = {"N~F=0", "R~T>2"};
		solution(n, data);
	}
	
	static char[] line = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
	public static int solution(int n, String[] data) {
		int answer = 0;
		//int leng = 8;
		char[][] ConditionData = new char[n][5];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 5; j++) {
				ConditionData[i][j] = data[i].charAt(j);
			}
		}
		
		//순열 (순서있게 배열)
        LinkedList<Character> perArr = new LinkedList<Character>(); 
        int[] perCheck = new int[8];
        answer = permutation(8, 8, perArr, perCheck, ConditionData);
		System.out.println(answer);
        return answer;
    }
	
	//순열 (순서있게 배열)
    public static int permutation(int n, int r, LinkedList<Character> perArr, int[] perCheck, char[][] ConditionData) {
    	int count = 0;
    	
        if(perArr.size() == r){
            /*for(char i : perArr){
                System.out.print(i+" ");
            }*/
            if(condition(ConditionData, perArr)) {
            	count++;
            }
            return count;
            //System.out.println();
        }
         
        for(int i=0; i<n; i++){
            if(perCheck[i] == 0){
                perArr.add(line[i]);
                perCheck[i] = 1;
                count += permutation(n, r, perArr, perCheck, ConditionData);
                perCheck[i] = 0;
                perArr.removeLast();
            }
        }
        
        return count;
    }
    
    public static boolean condition(char[][] ConditionData, LinkedList<Character> perArr) {
    	boolean con = true;
    	for (int i = 0; i < ConditionData.length; i++) {
			int char1 = perArr.indexOf(ConditionData[i][0]);
			int char2 = perArr.indexOf(ConditionData[i][2]);
			int char5 = ConditionData[i][4] - '0';
			
			if(ConditionData[i][3] == '>') {
				if(Math.abs(char1 - char2) <= char5 + 1) {
					con = false;
				}
			}else if(ConditionData[i][3] == '<') {
				if(Math.abs(char1 - char2) >= char5 + 1) {
					con = false;
				}
			}else if(ConditionData[i][3] == '=') {
				if(Math.abs(char1 - char2) != char5 + 1) {
					con = false;
				}
			}
			
			if(!con) {
				return con;
			}
		}
    	
    	return con;
    }
}
