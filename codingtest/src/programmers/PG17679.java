package programmers;

public class PG17679 {

	public static void main(String[] args) {
		int m = 6;
		int n = 6;
		String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		solution(m, n, board);
	}
	
	public static int solution(int m, int n, String[] board) {
        int answer = 0;
        //Map에 값 저장
        String[][] boardMap = new String[m][n];
        for (int i = 0; i < board.length; i++) {
			String[] split = board[i].split("");
			for (int j = 0; j < split.length; j++) {
				boardMap[i][j] = split[j];
			}
		}
        //map 확인
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(boardMap[i][j]);
			}
			System.out.println();
		}
        System.out.println("---------------------");
        
        boolean[][] boolList = new boolean[m][n];
        int isremove = 1;
        while(isremove != 0) {
        	isremove = 0;
        	//map 돌면서 4개인거 list로 반환
            for (int i = m - 1; i >= 0; i--) {
    			for (int j = n - 1; j >= 0; j--) {
    				boolList = find(boardMap, i, j, boardMap[i][j], boolList);
    			}
    		}
            for (int i = 0; i < m; i++) {
    			for (int j = 0; j < n; j++) {
    				System.out.print(boolList[i][j]);
    			}
    			System.out.println();
    		}
            
            for (int i = 0; i < m; i++) {
    			for (int j = 0; j < n; j++) {
    				if(boolList[i][j] == true) {
    					boardMap[i][j] = "0";
    					boolList[i][j] = false;
    					isremove++;
    				}
    			}
    		}
            
            for (int i = m - 1; i >= 0; i--) {
    			for (int j = n - 1; j >= 0; j--) {
    				if(boardMap[i][j].equals("0")) {
    					for (int k = i - 1; k >= 0; k--) {
    						if(!boardMap[k][j].equals("0")) {
    							boardMap[i][j] = boardMap[k][j];
    							boardMap[k][j] = "0";
    							break;
    						}
    					}
    				}
    			}
    		}
            System.out.println("-----------------------");
            for (int i = 0; i < m; i++) {
    			for (int j = 0; j < n; j++) {
    				System.out.print(boardMap[i][j]);
    			}
    			System.out.println();
    		}
            System.out.println();
        }
        for (int i = 0; i < boardMap.length; i++) {
			for (int j = 0; j < boardMap[0].length; j++) {
				if(boardMap[i][j] == "0") {
					answer++;
				}
			}
		}
        System.out.println(answer + "!!!");
        return answer;
    }
	
	public static boolean[][] find(String[][] boardMap, int x, int y, String pos, boolean[][] boolList) {
		int vx = x - 1;
		int vy = y + 0;
		int hx = x + 0;
		int hy = y - 1;
		int[] dx = {-1, 0, -1};
		int[] dy = {0, -1, -1};
		if(vx >= 0 && vy >=0 && vx < boardMap.length && vy < boardMap[0].length && hx >= 0 && hy >=0 && hx < boardMap.length && hy < boardMap[0].length) {
			if(boardMap[vx][vy].equals(pos)) {
				if(vx >= 0 && vy-1 >=0 && vx < boardMap.length && vy-1 < boardMap[0].length) {
					if(boardMap[hx][hy].equals(pos) && boardMap[vx][vy-1].equals(pos) && !pos.equals("0")) {
						//checkList.add(Integer.toString(x)+Integer.toString(y));
						boolList[x][y] = true;
						for (int i = 0; i < 3; i++) {
							boolList[x + dx[i]][y + dy[i]] = true;
						}
					}
				}
			}
		}
		return boolList;
	}

}
