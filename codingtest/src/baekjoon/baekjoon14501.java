package baekjoon;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class baekjoon14501 {

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int N = key.nextInt();
		int[] T = new int[N];
		int[] P = new int[N];
		List<Integer> result = new ArrayList<>();
		
		for (int i = 0; i < T.length; i++) {
			T[i] = key.nextInt();
			P[i] = key.nextInt();
		}
		
		for (int i = 0; i < T.length; i++) {
			int idx = i;
			int remain = N;
			int sum = 0;
			if(T[i]<N) {
				sum = P[i];
			}
			if(N-T[i]<N) {
				idx = N-T[i]-1;
				remain = N-T[i];
				if(remain-T[idx]<N) {
					sum += P[idx];
					idx = N-P[idx]-1;
				}
			}
		}
	}
	
	public static int plus(int sum, int remain, int idx, int[] T, int[] P) {
		if(remain-T[idx]<=remain) {
			sum += P[idx];
			idx = remain-T[idx]-1;
			remain = remain-T[idx];
			plus(sum,remain,idx,T,P);
		}
		return sum;
	}

}
