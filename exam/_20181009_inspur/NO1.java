package _20181009_inspur;

import java.util.Scanner;

public class NO1 {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		
		for(int i=0; i<num; i++){
			String[] split = sc.nextLine().trim().split(" ");
			int m = Integer.parseInt(split[0]);
			int n = Integer.parseInt(split[1]);
			int a = Integer.parseInt(split[2]);
			
			int mi=0;
			int ni=0;
			while( (a*mi<m) && (a*ni<n) ){
				mi++;
				ni++;
			}
			
			System.out.println(mi*ni);
		}
		
		
	}
}
