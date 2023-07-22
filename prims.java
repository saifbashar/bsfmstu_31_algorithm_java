package lab1;

import java.util.*;
import  java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class prims {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v;
		Scanner sc = new Scanner(System.in);
		v = sc.nextInt();
		
		int[][] vertex = new int[v][v];
		for(int i=0;i<v;i++) {
			for(int j=0;j<v;j++) {
				vertex[i][j] = sc.nextInt();
			}
		}
		
		int[] selected = new int[v];
		for(int i=0;i<v;i++) {
			selected[i] = 0;
		}
		selected[0] = 1;
		
		int edge = 0;
		
		while(edge < v-1) {
			int min = 99999;
			int x = -1, y = -1;
			for(int i=0;i<v;i++) {
				
				if(selected[i] == 1) {
					//System.out.println(selected[i]);
					for(int j=0;j<v;j++) {
						if(selected[j] == 0 && vertex[i][j] != 0 && vertex[i][j] < min) {
							min = vertex[i][j];
							x = i;
							y = j;
						}
					}
				}
				
			}
			System.out.println(x+"->"+y+":"+ min);
			selected[y] = 1;
			edge++;
		}
		
		

	}

}
