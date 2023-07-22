package lab1;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class radix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++) {
			a[i]  = sc.nextInt();
		}
		
		// radix sort
		int min = a[0];
		for(int i=1;i<n;i++) {
			if(min < a[i]) {
				min = a[i];
			}
		}
		
		// digit count
		int d = 0;
		while(min > 0) {
			min = min/10;
			d++;
		}
		
		int result = 1;
		while(d>0) {
			int[] bucket = new int[10];
			for(int i=0;i<10;i++) {
				bucket[i] = 0;
			}
			for(int i=0;i<n;i++) {
				int temp = (a[i]/result)%10;
				bucket[temp]++;
			}
			
			for(int i=1;i<10;i++) {
				bucket[i] += bucket[i-1];
			}
			
			int[] ans = new int[n];
			for(int i=n-1;i>=0;i--) {
				int temp = (a[i]/result)%10;
				ans[--bucket[temp]] = a[i];
			}
			for(int i=0;i<n;i++) {
				a[i] = ans[i];
			}
			
			d--;
		}
		
		for(int i=0;i<n;i++) {
			System.out.print(a[i]+" ");
		}
	}

}
