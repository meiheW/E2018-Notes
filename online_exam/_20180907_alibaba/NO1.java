package online_exam._20180907_alibaba;

import java.util.Scanner;

public class NO1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = Integer.valueOf(sc.nextLine());
		int[] arr = new int[num];
		for(int i=0; i<num; i++){
			int cur = Integer.valueOf(sc.nextLine());
			arr[i] = cur;
		}
		//printArr(arr);
		
		System.out.println(0);
		
	}

	private static void printArr(int[] arr) {
		System.out.println("...print...");
		for(int i=0; i<arr.length; i++)
			System.out.println(arr[i]);
		
	}
	
}
