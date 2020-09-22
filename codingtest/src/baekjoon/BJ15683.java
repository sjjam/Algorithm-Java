package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ15683 {//감시

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int N = key.nextInt();
		int M = key.nextInt();
		int[][] office = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				office[i][j] = key.nextInt();
			}
		}
		int ans = 0;
		// 1:한방향 2:양방향 3:직각두방향 4:세방향 5:네방향  6:벽
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(office[i][j] != 0 && office[i][j] != 6 && office[i][j] != 7) {
					watch(i, j, office);
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(office[i][j]);
				if(office[i][j] == 0) ans++;
			}
			System.out.println();
		}
		System.out.println(ans);
	}
	
	public static void watch(int x, int y, int[][] office) {
		int now = office[x][y];
		if(now == 1) {
			int max = 0;
			int cnt = 0;
			ArrayList<int[]> change = new ArrayList<>();
			for (int i = 0; i < 4; i++) {
				ArrayList<int[]> tmp = new ArrayList<>();
				tmp.addAll(direction(x, y, office, i));
				cnt = tmp.size();
				if(cnt > max) {
					change = new ArrayList<>();
					max = cnt;
					change.addAll(tmp);
				}
			}
			for (int i = 0; i < change.size(); i++) {
				int[] ch = change.get(i);
				office[ch[0]][ch[1]] = 7;
			}
		}else if(now == 2) {
			ArrayList<int[]> change = new ArrayList<>();
			ArrayList<int[]> tmp = new ArrayList<>();
			ArrayList<int[]> tmp2 = new ArrayList<>();
			for (int i = 0; i < 4; i++) {
				if(i <= 1) {
					tmp.addAll(direction(x, y, office, i));
				}else if(i > 1) {
					tmp2.addAll(direction(x, y, office, i));
				}
			}
			if(tmp.size() > tmp2.size()) {
				change.addAll(tmp);
			}else {
				change.addAll(tmp2);
			}
			for (int i = 0; i < change.size(); i++) {
				int[] ch = change.get(i);
				office[ch[0]][ch[1]] = 7;
			}
		}else if(now == 3) {
			int max = 0;
			int cnt = 0;
			ArrayList<int[]> change = new ArrayList<>();
			for (int i = 0; i < 4; i+=2) {
				ArrayList<int[]> tmp = new ArrayList<>();
				ArrayList<int[]> tmp2 = new ArrayList<>();
				tmp.addAll(direction(x, y, office, i));
				tmp2.addAll(direction(x, y, office, i+1));
				if(tmp.size() > tmp2.size()) {
					change.addAll(tmp);
				}else {
					change.addAll(tmp2);
				}
			}
			for (int i = 0; i < change.size(); i++) {
				int[] ch = change.get(i);
				office[ch[0]][ch[1]] = 7;
			}
		}else if(now == 4) {
			int max = office[0].length*office.length;
			int cnt = 0;
			ArrayList<int[]> change = new ArrayList<>();
			if((x == 0) || (y == 0) || (x == office.length) || y == office[0].length) {
				for (int i = 0; i < 4; i++) {
					change.addAll(direction(x, y, office, i));
				}
			}else {
				for (int i = 0; i < 4; i++) {
					ArrayList<int[]> tmp = new ArrayList<>();
					tmp.addAll(direction(x, y, office, i));
					cnt = tmp.size();
					if(cnt < max) {
						max = i;
					}
					change.addAll(tmp);
				}
				change.removeAll(direction(x, y, office, max));
			}
			for (int i = 0; i < change.size(); i++) {
				int[] ch = change.get(i);
				office[ch[0]][ch[1]] = 7;
			}
		}else if(now == 5) {
			ArrayList<int[]> change = new ArrayList<>();
			for (int i = 0; i < 4; i++) {
				change.addAll(direction(x, y, office, i));
			}
			for (int i = 0; i < change.size(); i++) {
				int[] ch = change.get(i);
				office[ch[0]][ch[1]] = 7;
			}
		}
	}

	public static ArrayList<int[]> direction(int x, int y, int[][] office, int way) {
		ArrayList<int[]> tmp = new ArrayList<>();
		switch (way) {
		case 0:
			for (int i = x; i >= 0; i--) {
				if(office[i][y] == 6) {
					break;
				}else {
					if(!(office[i][y] >= 1 && office[i][y] <=5)) {
						tmp.add(new int[] {i, y});
						System.out.println(i+"/"+y+"위");
					}
				}
			}
			break;
		
		case 1:
			for (int i = x; i < office.length; i++) {
				if(office[i][y] == 6) {
					break;
				}else {
					if(!(office[i][y] >= 1 && office[i][y] <=5)) {
						tmp.add(new int[] {i, y});
						System.out.println(i+"/"+y+"아래");
					}
				}
			}
			break;
		
		case 2:
			for (int i = y; i >= 0; i--) {
				if(office[x][i] == 6) {
					break;
				}else {
					if(!(office[x][i] >= 1 && office[x][i] <=5)) {
						tmp.add(new int[] {x, i});
						System.out.println(x+"/"+i+"왼");
					}
				}
			}
			break;
			
		case 3:
			for (int i = y; i < office[0].length; i++) {
				if(office[x][i] == 6) {
					break;
				}else {
					if(!(office[x][i] >= 1 && office[x][i] <=5)) {
						tmp.add(new int[] {x, i});
						System.out.println(x+"/"+i+"오");
					}
				}
			}
			break;
			
		}
		return tmp;
	}
	
}
