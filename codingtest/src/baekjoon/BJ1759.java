package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BJ1759 {

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		L = key.nextInt();
		C = key.nextInt();
		String[] arr = new String[C];
		for (int i = 0; i < C; i++) {
			arr[i] = key.next();
		}
		
		int[] comArr = new int[L];
		Combination(comArr, C, L, 0, 0, arr);
		
		Collections.sort(ans);
		for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	}
	
	public static int L, C = 0;
	public static String[] vowel = {"a", "e", "i", "o", "u"};
	public static List<String> ans = new ArrayList<String>();
	
	public static void Combination(int[] combArr, int n, int r, int index, int target, String[] arr){
        
        if(r == 0){
        	int cnt = 0;
            for(int i=0; i<index; i++) {
            	//System.out.print(arr[combArr[i]] + " ");
            	for (int j = 0; j < vowel.length; j++) {
					if(arr[combArr[i]].equals(vowel[j])) {
						cnt++;
					}
				}
            }
            if(cnt >= 1 && cnt + 2 <= L) {
            	String[] result = new String[L];
            	for(int i=0; i<index; i++) {
            		result[i] = arr[combArr[i]];
            	}
            	Arrays.sort(result);
            	String tmp = "";
            	for (int i = 0; i < result.length; i++) {
					tmp += result[i];
				}
            	ans.add(tmp);
            }
         
        }else if(target == n){ 
            return;
        }else{
            combArr[index] = target;
            Combination(combArr, n, r-1, index+1, target+1, arr);
            Combination(combArr, n, r, index, target+1, arr); 
        }
    }
}
