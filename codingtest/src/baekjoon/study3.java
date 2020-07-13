package baekjoon;

 

import java.util.Scanner;

 

public class study3 {

 

	public static void main(String[] args) {

		Scanner key = new Scanner(System.in);

		int num1 = key.nextInt();
		int num2 = key.nextInt();
		int numa = 0;
		int numb = 0;
		
		numa = (num1%10)*100 + ((num1%100)/10)*10 + num1/100;
		numb = (num2%10)*100 + ((num2%100)/10)*10 + num2/100;
		
		System.out.println(numa);
		System.out.println(numb);
		
		if(numa>numb) {
			System.out.println(numa);
		}else {
			System.out.println(numb);
		}
	}

}