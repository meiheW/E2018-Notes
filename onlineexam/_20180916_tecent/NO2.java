package onlineexam._20180916_tecent;

import java.util.Scanner;

public class NO2 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] split = sc.nextLine().trim().split(" ");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		
		int[][] path = new int[n+1][n+1];
		
		for(int i=0; i<m; i++){
			String[] road = sc.nextLine().trim().split(" ");
			int u = Integer.parseInt(road[0]);
			int v = Integer.parseInt(road[1]);
			
			path[u][v] = 1;
		}
		
		printArr(path);
		
	}

	private static void printArr(int[][] path) {
		for(int i=0; i<path.length; i++){
			for(int j=0; j<path.length; j++){
				System.out.print(path[i][j]+" ");
				
			}
			System.out.println();
			
		}
		
	}
}
