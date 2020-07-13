package baekjoon;

 

import java.util.Scanner;

 

public class study3_1 {

 

	public static void main(String[] args) {

		Scanner key = new Scanner(System.in);

		int a[] = new int[3];

		int b[] = new int[3];

		int a1[] = new int[3];

		int b1[] = new int[3];

		

		int aa = key.nextInt();

		int bb = key.nextInt();

		

		a[0] = aa/100;

		a[1] = (aa%100)/10;

		a[2] = aa%10;

		

		b[0] = bb/100;

		b[1] = (bb%100)/10;

		b[2] = bb%10;

		

		a1[0] = a[2];

		a1[1] = a[1];

		a1[2] = a[0];	

		b1[0] = b[2];

		b1[1] = b[1];

		b1[2] = b[0];
		
		System.out.print(a1[0]);
		System.out.print(a1[1]);
		System.out.println(a1[2]);
		System.out.print(b1[0]);
		System.out.print(b1[1]);
		System.out.println(b1[2]);
		//System.out.println((b1[0]+b1[1]+b1[2]));
		if(a1[0]>b1[0]) {

			System.out.print(a1[0]);
			System.out.print(a1[1]);
			System.out.println(a1[2]);

		}else if(a1[0]<b1[0]){

			System.out.print(b1[0]);
			System.out.print(b1[1]);
			System.out.println(b1[2]);

		}else {
			if(a1[1]>b1[1]) {
				System.out.print(a1[0]);
				System.out.print(a1[1]);
				System.out.println(a1[2]);
			}else if(a1[1]<b1[1]) {
				System.out.print(b1[0]);
				System.out.print(b1[1]);
				System.out.println(b1[2]);
			}else {
				if(a1[2]>b1[2]) {
					System.out.print(a1[0]);
					System.out.print(a1[1]);
					System.out.println(a1[2]);
				}else {
					System.out.print(b1[0]);
					System.out.print(b1[1]);
					System.out.println(b1[2]);
				}
			}
		}
		
	}

}