package programmers;

import java.util.LinkedList;
import java.util.Queue;

class Node {

    private int x;
    private int y;
    private int x2;
    private int y2;

    public Node(int x, int y, int x2, int y2) {
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
    }

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getX2() {
		return x2;
	}

	public int getY2() {
		return y2;
	}

}


public class PG60063 {

	public static void main(String[] args) {
		int[][] board = //{{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}};
			//{{0, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 0}, {0, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 1, 1}, {0, 0, 1, 0, 0, 0, 0}};
			{{0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 0, 0}, {0, 1, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 1, 1, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0}};
		solution(board);
	}
	
	public static int solution(int[][] board) {
		int answer = 0;
		Queue<Node> q = new LinkedList<>();
		int N = board.length;
		int[][] boardChk = new int[N][N];
        boolean[][] visit = new boolean[N][N];
        q.add(new Node(0,0,0,1));
        visit[0][0] = true;
        visit[0][1] = true;
		while (!q.isEmpty()) {
			Node temp = q.poll();
			// System.out.print(temp);
			int x = temp.getX();
			int y = temp.getY();
			int x2 = temp.getX2();
			int y2 = temp.getY2();
			System.out.println(x + "---" + y + "/" + x2 + "---" + y2);
			visit[x][y] = true;
			visit[x2][y2] = true;

			int dx[] = {-1, 0, 1, 0};
			int dy[] = {0, -1, 0, 1};
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nx2 = x2 + dx[i];
				int ny2 = y2 + dy[i];
				
				if (nx >= 0 && nx < N && nx2 >= 0 && nx2 < N && ny >= 0 && ny < N && ny2 >= 0 && ny2 < N) {
					if (x == x2) {
						if (board[nx][ny] == 0 && board[nx2][ny2] == 0 && (visit[nx][ny] == false || visit[nx2][ny2] == false)) {
							q.add(new Node(nx, ny, nx2, ny2));
							if(dy[i] == - 1) {
								if(boardChk[x][y] < boardChk[x2][y2]) {
									boardChk[x][y] = boardChk[x2][y2];
								}
								boardChk[nx][ny] = boardChk[x][y] + 1;
							}else {
								boardChk[nx2][ny2] = boardChk[x2][y2] + 1;
							}
						}
					}else if(y == y2) {
						if (board[nx][ny] == 0 && board[nx2][ny2] == 0 && (visit[nx][ny] == false || visit[nx2][ny2] == false)) {
							q.add(new Node(nx, ny, nx2, ny2));
							if(dx[i] == -1) {
								if(boardChk[x][y] < boardChk[x2][y2]) {
									boardChk[x][y] = boardChk[x2][y2];
								}
								boardChk[nx][ny] = boardChk[x][y] + 1;
							}else {
								boardChk[nx2][ny2] = boardChk[x2][y2] + 1;
							}
						}
					}
				}
			}
			
			int rot[] = {-1, 1};
			if(x == x2) {
				for (int i = 0; i < 2; i++) {
					int rnx = x + rot[i];
					int rny = y;
					int rnx2 = x2 + rot[i];
					int rny2 = y2;
					
					if(rnx >= 0 && rnx < N && rnx2 >= 0 && rnx2 < N && board[rnx][rny] == 0 && board[rnx2][rny2] == 0
							&& visit[rnx][rny] == false && visit[rnx2][rny2] == false) {
						//q.add(new Node(x, y, rnx, rny));
						if(x > rnx) {
							q.add(new Node(rnx, rny, x, y));
						}else {
							q.add(new Node(x, y, rnx, rny));
						}
						boardChk[rnx][rny] = boardChk[x][y] + 1;
						q.add(new Node(x2, y2, rnx2, rny2));
						boardChk[rnx2][rny2] = boardChk[x2][y2] + 1;
					}
				}
			}
			
			if(y == y2) {
				for (int i = 0; i < 2; i++) {
					int rnx = x;
					int rny = y + rot[i];
					int rnx2 = x2;
					int rny2 = y2 + rot[i];
					
					if(rny >= 0 && rny < N && rny2 >= 0 && rny2 < N && board[rnx][rny] == 0 && board[rnx2][rny2] == 0
							&& visit[rnx][rny] == false && visit[rnx2][rny2] == false) {
						//q.add(new Node(x, y, rnx, rny2));
						if(y > rny) {
							q.add(new Node(rnx, rny, x, y));
						}else {
							q.add(new Node(x, y, rnx, rny));
						}
						boardChk[rnx][rny] = boardChk[x2][y2] + 1;
						q.add(new Node(x2, y2, rnx2, rny2));
						boardChk[rnx2][rny2] = boardChk[x2][y2] + 1;
					}
				}
			}
			
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					System.out.print(boardChk[i][j]+" ");
				}
				System.out.println();
			}
			if (visit[N - 1][N - 1]) {
				System.out.println("¿Ï·á");
				break;
			}

		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(boardChk[i][j]+" ");
			}
			System.out.println();
		}
		answer = boardChk[N-1][N-1];
		System.out.println(answer);
        return answer;
    }

}
