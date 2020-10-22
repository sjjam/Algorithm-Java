package book_CT.bfs_dfs;

import java.util.Scanner;

public class ex_5_1 {//음료수 얼려 먹기

	static int n;
	static int m;
	static int[][] map;
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		n = key.nextInt();
		m = key.nextInt();
		key.nextLine(); //버퍼 지우기
		map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			String str = key.nextLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(dfs(i, j) == true) {
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
	
	public static boolean dfs(int x, int y) {
		if(x <= -1 || x >= n || y <= -1 || y >= m) {
			return false;
		}
		if(map[x][y] == 0) {
			map[x][y] = 1;
			dfs(x - 1, y);
			dfs(x, y - 1);
			dfs(x + 1, y);
			dfs(x, y + 1);
			return true;
		}
		return false;
	}

}
