package Line_2020_09;

public class q4_202009 {

	public static void main(String[] args) {
		int[][] maze= {{0, 1, 0, 1},
				{0, 1, 0, 0},
				{0, 0, 0, 0},
				{1, 0, 1, 0}
				};
		solution(maze);
	}
	
	public static int solution(int[][] maze) {
        int answer = 0;
        boolean[][] chk = new boolean[maze.length][maze.length];
        return answer;
    }

	public static int go(int x, int y, int[][] maze, boolean[][] chk) {
		int time = 0;
		chk[x][y] = true;
		int[] dx = {-1, 0, 1, 0};//ºÏ,¼­,³²,µ¿
		int[] dy = {0, -1, 0, 1};
		//for (int i = 0; i < dx.length; i++) {
			int nx = x;
			int ny = y;
			if(nx >= 0 && nx < maze.length && ny >= 0 && ny <maze.length) {
				if(maze[x-1][y] == 1) {
					
				}else if(maze[x][y-1] == 1) {
					
				}else if(maze[x+1][y] == 1) {
					nx = x;
					ny = y+1;
					time++;
					time += go(x, y, maze, chk);
				}else if(maze[x][y+1] == 1) {
					nx = x+1;
					ny = y;
					time++;
					time += go(x, y, maze, chk);
				}
			}
		//}
		return 0;
	}
}
