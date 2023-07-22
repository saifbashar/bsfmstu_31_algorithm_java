package lab1;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

public class merge {
	
	private static void merge1(int a[],int left,int mid ,int right) {
		int n1 = mid-left+1;
		int n2 = right -mid;
		int[] l = new int[n1];
		int[] r = new int[n2];
		
		for(int i=0;i<n1;i++) {
			l[i] = a[left+i];
		}
		for(int i=0;i<n2;i++) {
			r[i] = a[mid+1+i];
		}
		
		int k = left, i = 0, j = 0;
		while(i < n1 && j < n2) {
			if(l[i] < r[j]) {
				a[k] = l[i];
				i++;
				k++;
			}
			else{
				a[k] = r[j];
				j++;
				k++;
			}
		}
		while(i<n1) {
			a[k++] = l[i++];
		}
		while(j<n2) {
			a[k++] = r[j++];
		}
	}
	
	private static void merge_sort(int a[],int l, int r) {
		if(l<r) {
			int mid = l + (r-l)/2;
			merge_sort(a,l,mid);
			merge_sort(a,mid+1,r);
			merge1(a,l,mid,r);
		}
	}
	
	private static void display(int[] a) {
		for(int i:a) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		display(a);
		merge_sort(a,0,n-1);
		display(a);
		
		

	}

}
