package _20180912_thunder;

import java.util.Scanner;

//有红黑两种颜色的方块积木，红色代表正数A，黑色代表负数B。
//选出17块积木排成一排，使得任意相邻7块积木之和都小于0。
//如何挑选才能使17块积木之和最大，最大值是多少？

public class NO2 {
	public static void main(String[] args) {
		/*
		 * 正数A，负数B, A和B绝对值小于10000
		 */
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		if(A+6*B >= 0)	return;
		
		int i;	//正数的个数
		int sum = 0;
		for(i=6; i>=1; i++){
			sum = i*A + (7-i)*B;
			if(sum < 0)
				break;
		}
		
		int max = (i>=3) ? 2*sum+3*A : 2*sum+i*A+(3-i)*B ;
		System.out.println(max);
		
		
	}
}
