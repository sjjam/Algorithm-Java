package book_CT.implementation;

import java.util.*;

class Combination {
    private int n;
    private int r;
    private int[] now; // ���� ����
    private ArrayList<ArrayList<Position>> result; // ��� ����

    public ArrayList<ArrayList<Position>> getResult() {
        return result;
    }

    public Combination(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<ArrayList<Position>>();
    }

    public void combination(ArrayList<Position> arr, int depth, int index, int target) {
        if (depth == r) {
            ArrayList<Position> temp = new ArrayList<>();
            for (int i = 0; i < now.length; i++) {
                temp.add(arr.get(now[i]));
            }
            result.add(temp);
            return;
        }
        if (target == n) return;
        now[index] = target;
        combination(arr, depth + 1, index + 1, target + 1);
        combination(arr, depth, index, target + 1);
    }
}

class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
public class Q13 {

	public static int n, m;
    public static int[][] arr = new int[50][50];
    public static ArrayList<Position> chicken = new ArrayList<>();
    public static ArrayList<Position> house = new ArrayList<>();

    public static int getSum(ArrayList<Position> candidates) {
        int result = 0;
          for (int i = 0; i < house.size(); i++) {
              int hx = house.get(i).getX();
              int hy = house.get(i).getY();
              int temp = (int) 1e9;
              for (int j = 0; j < candidates.size(); j++) {
                  int cx = candidates.get(j).getX();
                  int cy = candidates.get(j).getY();
                  temp = Math.min(temp, Math.abs(hx - cx) + Math.abs(hy - cy));
              }
              result += temp;
          }
          return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                arr[r][c] = sc.nextInt();
                if (arr[r][c] == 1) house.add(new Position(r, c));
                else if (arr[r][c] == 2) chicken.add(new Position(r, c));
            }
        }

        Combination comb = new Combination(chicken.size(), m);
        comb.combination(chicken, 0, 0, 0);
        ArrayList<ArrayList<Position>> chickenList = comb.getResult();

        int result = (int) 1e9;
        for (int i = 0; i < chickenList.size(); i++) {
            result = Math.min(result, getSum(chickenList.get(i)));
        }

        System.out.println(result);
    }

}
