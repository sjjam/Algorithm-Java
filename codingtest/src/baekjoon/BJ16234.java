package baekjoon;

import java.util.Scanner;

public class BJ16234 {

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int N = key.nextInt();
		int L = key.nextInt();
		int R = key.nextInt();
		int[][] A = new int[N][N];
		
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				A[i][j] = key.nextInt();
			}
		}
		int ans = 0;
		boolean[][] check = new boolean[N][N];
		
		while(true) {
			int sum = 0;
			int chk = 0;
			boolean[][] checkSub = new boolean[N][N];
			for (int i = 0; i < A.length; i++) {
				for (int j = 0; j < A.length; j++) {
					if(check[i][j] == false) {
						sum = open(i, j, L, R, A, check, checkSub);
						System.out.println(sum+"-----"+check[i][j]);
						chk += movement(check, A, sum, checkSub);
					}
				}
			}
			
			for (int i = 0; i < A.length; i++) {
				for (int j = 0; j < A.length; j++) {
					check[i][j] = false;
					System.out.println(A[i][j]+"---");
				}
			}
			
			if(chk == 0) {
				break;
			}
			ans++;
		}
		
		/*while(true) {
			int sum = 0;
			int num = 0;
			int country = 0;
			int chk = 0;
			for (int i = 0; i < A.length; i++) {
				for (int j = 0; j < A.length; j++) {
					chk += movement(i, j, L, R, A, check);
				}
			}
			
			for (int i = 0; i < A.length; i++) {
				for (int j = 0; j < A.length; j++) {
					if(check[i][j] == true) {
						System.out.println(check[i][j]);
						sum += A[i][j];
						country++;
					}
				}
			}
			System.out.println(sum+"--------");
			if(chk == 0) break;
			num = sum/country;
			System.out.println(num+"num~~~");
			for (int i = 0; i < A.length; i++) {
				for (int j = 0; j < A.length; j++) {
					if(check[i][j] == true) {
						A[i][j] = num;
						//check[i][j] = false;
					}
				}
			}
			ans++;
		}*/
		System.out.println(ans+"´ä~~~~");
	}

	public static int open(int x, int y, int L, int R, int[][] A, boolean[][] check, boolean[][] checkSub) {
		check[x][y] = true;
		int sum = A[x][y];
		System.out.println(sum+"///"+x+"///"+y+check[x][y]);
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, -1, 0, 1};
		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && nx < A.length && ny >= 0 && ny <A.length) {
				int sub = Math.abs(A[x][y] - A[nx][ny]);
				if(sub >= L && sub <= R && check[nx][ny] == false) {
					//A[x][y] = 0;
					checkSub[x][y] = true;
					checkSub[nx][ny] = true;
					sum += open(nx, ny, L, R, A, check, checkSub);
					//A[nx][ny] = 0;
				}
			}
		}
		return sum;
	}
	
	public static int movement(boolean[][] check, int[][] A, int sum, boolean[][] checkSub) {
		int chk = 0;
		int country = 0;
		int pop = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				/*if(A[i][j] == 0) {
					country++;
				}*/
				if(checkSub[i][j] == true) {
					country++;
				}
			}
		}
		if(country != 0) {
			pop = sum/country;
		}
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				/*if(A[i][j] == 0) {
					A[i][j] = pop;
					chk++;
					//check[i][j] = false;
				}*/
				if(checkSub[i][j] == true) {
					A[i][j] = pop;
					chk++;
					//check[i][j] = false;
					checkSub[i][j] = false;
				}
			}
		}
		return chk;
	}
}
