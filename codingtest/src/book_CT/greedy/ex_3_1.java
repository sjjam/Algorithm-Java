package book_CT.greedy;

public class ex_3_1 {

	public static void main(String[] args) {//거스름돈
		//500원, 100원, 50원, 10원 무수히 많을때 거슬러 줘야할 동전의 최소 개수
		int n = 1260;
		int[] coin = {500, 100, 50, 10};
		int cnt = 0;
		
		for (int i = 0; i < coin.length; i++) {
			cnt += n/coin[i];
			n %= coin[i];
		}
		System.out.println(cnt);
	}

}
