package book_CT.bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ex_5_2 {//πÃ∑Œ ≈ª√‚

	static int n;
	static int m;
	static int[][] map;
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		n = key.nextInt();
		m = key.nextInt();
		map = new int[n][m];
		key.nextLine();
		
		for (int i = 0; i < n; i++) {
			String str = key.nextLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		System.out.println(bfs(0, 0));
	}
	
	public static int bfs(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(x, y));
		while(!q.isEmpty()) {
			Point p = q.poll();
			x = p.getX();
			y = p.getY();
			int[] dx = {-1, 1, 0, 0};
			int[] dy = {0, 0, -1, 1};
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
					continue;
				}
				if(map[nx][ny] == 0) {
					continue;
				}
				if(map[nx][ny] == 1) {
					q.offer(new Point(nx, ny));
					map[nx][ny] = map[x][y] + 1;
				}
			}
		}
		return map[n - 1][m - 1];
	}

}

class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
}