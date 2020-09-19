package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ16234 {//인구이동
   static int country;
   static ArrayList<int[]> change;
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
      while(true) {
         int sum = 0;
         boolean chk = false;
         boolean[][] check = new boolean[N][N];
         boolean[][] checkSub = new boolean[N][N];
         for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
               if(check[i][j] == false) {
                  country = 0;
                  change = new ArrayList<>();
                  sum = open(i, j, L, R, A, check, checkSub);
                  if(change.size() > 1) {
                	  movement(check, A, sum, checkSub);
                	  chk = true;
                  }
               }
            }
         }
         
         if(!chk) {
            break;
         }
         ans++;
      }
      System.out.println(ans);
   }
   public static int open(int x, int y, int L, int R, int[][] A, boolean[][] check, boolean[][] checkSub) {
      check[x][y] = true;
      change.add(new int[] {x, y});
      int sum = A[x][y];
      int[] dx = {-1, 0, 1, 0};
      int[] dy = {0, -1, 0, 1};
      for (int i = 0; i < dx.length; i++) {
         int nx = x + dx[i];
         int ny = y + dy[i];
         if(nx >= 0 && nx < A.length && ny >= 0 && ny <A.length) {
            int sub = Math.abs(A[x][y] - A[nx][ny]);
            if(sub >= L && sub <= R && check[nx][ny] == false) {
               checkSub[x][y] = true;
               checkSub[nx][ny] = true;
               sum += open(nx, ny, L, R, A, check, checkSub);
            }
         }
      }
      if(checkSub[x][y] == true) {
         country++;
      }
      return sum;
   }
   
   public static int movement(boolean[][] check, int[][] A, int sum, boolean[][] checkSub) {
      int chk = 0;
      int pop = 0;
      if(country != 0) {
         pop = sum/country;
      }
      /*for (int i = 0; i < A.length; i++) {
         for (int j = 0; j < A.length; j++) {
            if(checkSub[i][j] == true) {
               A[i][j] = pop;
               chk++;
               checkSub[i][j] = false;
            }
         }
      }*/
      for(int i=0;i<change.size();i++) {
    	  int[] now = change.get(i);
    	  A[now[0]][now[1]] = pop;
    	  chk++;
      }
      return chk;
   }
}