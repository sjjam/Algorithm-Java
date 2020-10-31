package book_CT.banary_search;

import java.util.*;

public class sequantialSearch {

    // ���� Ž�� �ҽ��ڵ� ����
    public static int sequantialSearch(int n, String target, String[] arr) {
        // �� ���Ҹ� �ϳ��� Ȯ���ϸ�
        for (int i = 0; i < n; i++) {
        	System.out.println(arr[i]);
            // ������ ���Ұ� ã���� �ϴ� ���ҿ� ������ ���
            if (arr[i].equals(target)) {
                return i + 1; // ������ ��ġ ��ȯ (�ε����� 0���� �����ϹǷ� 1 ���ϱ�)
            }
        }
        return -1; // ���Ҹ� ã�� ���� ��� -1 ��ȯ
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("������ ���� ������ �Է��� ���� �� ĭ ��� ã�� ���ڿ��� �Է��ϼ���.");
        // ������ ����
        int n = sc.nextInt();
        // ã���� �ϴ� ���ڿ�
        String target = sc.next();

        System.out.println("�ռ� ���� ���� ������ŭ ���ڿ��� �Է��ϼ���. ������ ���� �� ĭ���� �մϴ�.");
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        // ���� Ž�� ���� ��� ���
        System.out.println(sequantialSearch(n, target, arr));
    }

}