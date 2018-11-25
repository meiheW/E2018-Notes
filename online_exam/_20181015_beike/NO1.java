package online_exam._20181015_beike;

import java.util.Scanner;

public class NO1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int m = sc.nextInt();
		
		System.out.println(getCount(num, m)%((int)Math.pow(10, 9) + 7));
	}

	private static int getCount(int num, int m) {
		if(m==1)
			return 1;
		
		int count=0;
		for(int i=1; i<=num; i++){
			if(num%i==0)
				count+=getCount(num/i, m-1);
		}
		
		
		return count;
	}
}
