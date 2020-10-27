package book_CT.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class student implements Comparable<student>{
	String name;
	int a;
	int b;
	int c;
	
	public student(String name, int a, int b, int c) {
		super();
		this.name = name;
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public String getName() {
        return this.name;
    }
	
	@Override
	public int compareTo(student o) {
		if(this.a == o.a && this.b == o.b && this.c == o.c) {
			return this.name.compareTo(o.name);
		}
		if(this.a == o.a && this.b == o.b) {
			return Integer.compare(o.c, this.c);
		}
		if(this.a == o.a) {
			return Integer.compare(this.b, o.b);
		}
		return Integer.compare(o.a, this.a);
	}
	
}

public class Q23 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

        ArrayList<student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int kor = sc.nextInt();
            int eng = sc.nextInt();
            int m = sc.nextInt();
            students.add(new student(name, kor, eng, m));
        }

        Collections.sort(students);

        for (int i = 0; i < n; i++) {
            System.out.println(students.get(i).getName());
        }
	}

}
