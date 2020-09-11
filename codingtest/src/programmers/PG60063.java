package programmers;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

class Node {//블록 이동하기

    private int x;
    private int y;
    private int x2;
    private int y2;
    private int move;

    public Node(int x, int y, int x2, int y2, int move) {
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
        this.move = move;
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

   public int getMove() {
	   return move;
	}

   public boolean equals(Object obj) {
		if(obj instanceof Node) {
			Node temp = (Node) obj;
			return x==temp.x && y==temp.y && x2==temp.x2 && y2==temp.y2;
		}
		return false;
	}
	
	public int hashCode() {
		return Objects.hash(x, y, x2, y2);
	}

}


public class PG60063 {

   public static void main(String[] args) {
	   int[][] board1 = {{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}};
		//solution(board1);
		//(output) 7
		
		int[][] board2 = {{0, 0, 0, 0, 0, 0, 1},
				{1, 1, 1, 1, 0, 0, 1},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 1, 1, 1, 1, 0},
				{0, 1, 1, 1, 1, 1, 0},
				{0, 0, 0, 0, 0, 1, 1},
				{0, 0, 1, 0, 0, 0, 0}};
		//solution(board2);
		//(output) 21
		
		int[][] board3 = {{0, 0, 0, 0, 0, 0, 1},
				{1, 1, 1, 1, 0, 0, 1},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 1, 1, 1, 0, 0},
				{0, 1, 1, 1, 1, 1, 0},
				{0, 0, 0, 0, 0, 1, 0},
				{0, 0, 1, 0, 0, 0, 0}};
		//solution(board3);
		//(output) 11
		
		int[][] board4 = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{1, 1, 1, 1, 1, 1, 1, 0, 0},
				{1, 1, 1, 1, 1, 1, 1, 1, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 1, 1, 1, 1, 1, 0, 0},
				{0, 1, 1, 1, 1, 1, 1, 1, 1},
				{0, 0, 1, 1, 1, 1, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{1, 1, 1, 1, 1, 1, 1, 1, 0}};
		solution(board4);
		//(output) 33

   }
   
   public static int solution(int[][] board) {
      int answer = 0;
      Queue<Node> q = new LinkedList<>();
      int N = board.length;
      //int[][] boardChk = new int[N][N];
      //boolean[][] visit = new boolean[N][N];
      Set<Node> visited = new HashSet<>();
      q.add(new Node(0,0,0,1,0));
      /*visit[0][0] = true;
      visit[0][1] = true;*/
      visited.add(new Node(0,0,0,1,0));
      while (!q.isEmpty()) {
         Node temp = q.poll();
         // System.out.print(temp);
         int x = temp.getX();
         int y = temp.getY();
         int x2 = temp.getX2();
         int y2 = temp.getY2();
         int move = temp.getMove();
         System.out.println(x + "---" + y + "/" + x2 + "---" + y2 + " || move : " + move);
         /*visit[x][y] = true;
         visit[x2][y2] = true;*/

         int dx[] = {-1, 0, 1, 0};
         int dy[] = {0, -1, 0, 1};
         for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int nx2 = x2 + dx[i];
            int ny2 = y2 + dy[i];
            
            if (nx >= 0 && nx < N && nx2 >= 0 && nx2 < N && ny >= 0 && ny < N && ny2 >= 0 && ny2 < N) {
               //if (x == x2) {
                  if (board[nx][ny] == 0 && board[nx2][ny2] == 0 && (!visited.contains(new Node(nx,ny,nx2,ny2,0)))) {
                     q.add(new Node(nx, ny, nx2, ny2, move+1));
                     visited.add(new Node(nx,ny,nx2,ny2,0));
                  }
               /*}else if(y == y2) {
                  if (board[nx][ny] == 0 && board[nx2][ny2] == 0 && (!visited.contains(new Node(nx,ny,nx2,ny2,0)))) {
                     q.add(new Node(nx, ny, nx2, ny2, move+1));
                     visited.add(new Node(nx,ny,nx2,ny2,0));

                  }
               }*/
            }
         }
         
         int rot[] = {-1, 1};
         if(x == x2) {
            for (int i = 0; i < 2; i++) {
               int rnx = x + rot[i];
               int rny = y;
               int rnx2 = x2 + rot[i];
               int rny2 = y2;
               
               if(rnx >= 0 && rnx < N && rnx2 >= 0 && rnx2 < N && board[rnx][rny] == 0 && board[rnx2][rny2] == 0) {
            	  if(!visited.contains(new Node(x, y, rnx, rny,0))) {
            		  q.add(new Node(x, y, rnx, rny, move+1));
            		  visited.add(new Node(x, y, rnx, rny, 0));
               	  }
                  /*if(x > rnx) {
                     q.add(new Node(rnx, rny, x, y, move+1));
                  }else {
                     q.add(new Node(x, y, rnx, rny, move+1));
                  }*/
            	  if(!visited.contains(new Node(x2, y2, rnx2, rny2,0))) {
            		  q.add(new Node(x2, y2, rnx2, rny2, move+1));
            		  visited.add(new Node(x2, y2, rnx2, rny2,0));
            	  }
               }
            }
         }
         
         if(y == y2) {
            for (int i = 0; i < 2; i++) {
               int rnx = x;
               int rny = y + rot[i];
               int rnx2 = x2;
               int rny2 = y2 + rot[i];
               
               if(rny >= 0 && rny < N && rny2 >= 0 && rny2 < N && board[rnx][rny] == 0 && board[rnx2][rny2] == 0) {
            	   if(!visited.contains(new Node(x, y, rnx, rny,0))) {
             		  q.add(new Node(x, y, rnx, rny, move+1));
             		  visited.add(new Node(x, y, rnx, rny,0));
            	   }
                  /*if(y > rny) {
                     q.add(new Node(rnx, rny, x, y, move+1));
                  }else {
                     q.add(new Node(x, y, rnx, rny, move+1));
                  }*/
            	   if(!visited.contains(new Node(x2, y2, rnx2, rny2,0))) {
            		   q.add(new Node(x2, y2, rnx2, rny2, move+1));
              		  visited.add(new Node(x2, y2, rnx2, rny2,0));
             	   }
               }
            }
         }
         
         /*for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
               System.out.print(boardChk[i][j]+" ");
            }
            System.out.println();
         }*/
         if ((x == N-1 && y == N-1) || (x2 == N-1 && y2 == N-1)) {
            System.out.println("완료");
            answer = move;
            break;
         }

      }
      /*for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board.length; j++) {
            System.out.print(boardChk[i][j]+" ");
         }
         System.out.println();
      }*/
      //answer = boardChk[N-1][N-1];
      System.out.println(answer);
        return answer;
    }

}