package book_CT.greedy;

public class ex_3_1 {

	public static void main(String[] args) {//�Ž�����
		//500��, 100��, 50��, 10�� ������ ������ �Ž��� ����� ������ �ּ� ����
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
