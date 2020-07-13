package baekjoon;

public class baekjoon2667 {

	public static void main(String[] args) {
		int[][] map = {
				{0,1,1,0,1,0,0},
				{0,1,1,0,1,0,1},
				{1,1,1,0,1,0,1},
				{0,0,0,0,1,1,1},
				{0,1,0,0,0,0,0},
				{0,1,1,1,1,1,0},
				{0,1,1,1,0,0,0}
						};
		int[][] ans = new int[map.length][map.length];
		int all = 0;
		int num = 2;
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j]==1) {
					ans[i][j]=num;
					if(j>=1 && map[i][j-1]==1) {
						ans[i][j-1]=num;
					}
					if(j<=map.length-2 && map[i][j+1]==1) {
						ans[i][j+1]=num;
					}
					if(i<=map.length-2 && map[i+1][j]==1) {
						map[i+1][j]=num;
					}
					if(i>=1 && map[i-1][j]==1) {
						ans[i-1][j]=num;
					}
					
					if(j>=1 && map[i][j-1]==0) {
						ans[i][j]=num+1;
					}
					if(j<=map.length-2 && map[i][j+1]==0) {
						ans[i][j+1]=1;
					}
					if(i<=map.length-2 && map[i+1][j]==0) {
						map[i+1][j]=1;
					}
					if(i>=1 && map[i-1][j]==0) {
						ans[i-1][j]=num+1;
					}
				}
				System.out.print(ans[i][j]);
			}
			System.out.println();
		}
	
	
		/*	int res = 1;
			int[] dx = {-1, 0, 1, 0};
			int[] dy = {0, -1, 0, 1};
			map[x][y] = num; //��ǥ �� > ���� ��ȣ�� ����
			for(int i=0;i<4;i++) { //4���� Ž��
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 0 && ny >= 0 && nx < map.length && ny < map.length) { //���� ��ǥ�� �������� ������
					if(map[nx][ny] == 1) { //���� ��ǥ �� == 1
						map[nx][ny] = num; //���� ��ǥ �� > ���� ��ȣ�� ����
						res += findComplex(map, nx, ny, num); //���� ��ǥ���� findComplex �Լ� �ٽ� ����
			// + ���� �� res�� ���ϱ�
		
					}
				}
			}
			return res; //���� ������ ���Ե� �� ����
		*/
	}
}
