package online_exam._20180916_tecent;

import java.util.Scanner;

public class NO3 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		for(int i=0; i<num; i++){
			String[] split = sc.nextLine().trim().split(" ");
			int A = Integer.parseInt(split[0]);
			int B = Integer.parseInt(split[1]);
			int C = Integer.parseInt(split[2]);
			
			helper(A,B,C);
		}
		
		
	}

	private static void helper(int a, int b, int c) {
		for(int i=0; i<10000; i++){
			if(a*i%b ==c){
				System.out.println("YES");
				return;
				
			}
		}
		System.out.println("NO");
	}
}
