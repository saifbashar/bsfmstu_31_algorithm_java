package lab1;

import java.util.*;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

public class quick {
	private static void display(int[] arr) {
		for(int i:arr) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	private static int partition(int a[],int l,int r) {
		int pivot = a[r];
		int i= l-1;
		for(int j=l;j<r;j++) {
			if(a[j] < pivot) {
				i++;
				int temp = a[j];
				a[j] = a[i];
				a[i] = temp;
			}
		}
		i++;
		int temp = a[i];
		a[i]  = a[r];
		a[r] = temp;
		return i;
	}
	private static  void quick_sort(int a[], int l,int r) {
		if(l<r) {
			int par = partition(a,l,r);
			quick_sort(a,l,par-1);
			quick_sort(a,par+1,r);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		quick obj1 = new quick();
		obj1.display(a);
		obj1.quick_sort(a,0,n-1);
		obj1.display(a);
	}

}
