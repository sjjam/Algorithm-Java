package baekjoon;

import java.util.Scanner;



public class baekjoon14503 {

 

	public static void main(String[] args) {

		Scanner key = new Scanner(System.in);

		int N = key.nextInt();

		int M = key.nextInt();

		int[] start = new int[3];

		for (int i = 0; i < start.length; i++) {

			start[i] = key.nextInt();

		}

		int[][] mapsize = new int[N][M];

		for(int i=0;i<N;i++) {

			for (int j = 0; j < M; j++) {

				mapsize[i][j] = key.nextInt();

			}

		}

		int answer = 0;
		
		answer = cleansize(start,mapsize);

		System.out.println(answer);

	}
	
	/*public static int cleansize(int[] start,int[][] mapsize) {
		mapsize[start[0]][start[1]] = -1;
		int clean = 1;
		
		//ºÏ 0

		int[] dxn = {0,1,0,-1};
		int[] dyn = {-1,0,1,0};
		
		//µ¿ 1

		int[] dxe = {-1,0,1,0};
		int[] dye = {0,-1,0,1};
		
		//³² 2

		int[] dxs = {0,-1,0,1};
		int[] dys = {1,0,-1,0};
		
		//¼­ 3

		int[] dxw = {1,0,-1,0};
		int[] dyw = {0,1,0,-1};
		
		if(start[2]==0)
		
		return clean;
	}*/

	

	public static int cleansize(int[] start, int[][] mapsize) {
		int clean = 0;
		if(mapsize[start[0]][start[1]] == -1) {
			clean = 0;
		}else if(mapsize[start[0]][start[1]] == 0) {
			clean = 1;
			mapsize[start[0]][start[1]] = -1;
		}

		int[] dir = {3,2,1,0};
		int[] dx = {0,1,0,-1};
		int[] dy = {-1,0,1,0};
		
		int idx = 3-start[2];
		for (int i = 0; i < 4; i++) {
			idx = (idx+1)%4;
			
			int nx = start[0] + dx[idx];

			int ny = start[1] + dy[idx];

			if(nx >= 0 && ny >= 0 && nx < mapsize.length && ny < mapsize[0].length) {

				if(mapsize[nx][ny]==0) {

					clean++;

					mapsize[nx][ny]=-1;
					
					start[0] = nx;
					start[1] = ny;
					start[2] = dir[idx];
					
					clean += cleansize(start, mapsize);
					break;

				/*}else if(mapsize[nx][ny]==1 && i<3|| mapsize[nx][ny]==-1 && i<3) {
					start[2] = dir[idx];*/
				}else if((mapsize[nx][ny]==1 && i==3) || (mapsize[nx][ny]==-1 && i==3)){
					start[2] = dir[idx];
					idx = (idx+2)%4;
					start[0] = start[0] + dx[idx];
					start[1] = start[1] + dy[idx];
					if(mapsize[start[0]][start[1]]==1) {
						return clean;
					}else {
						if(start[0] >= 0 && start[1] >= 0 && start[0] < mapsize.length && start[1] < mapsize[0].length) {
							clean += cleansize(start, mapsize);
						}
					}
				}

			}
			
		}
		return clean;
	}
}
		
		