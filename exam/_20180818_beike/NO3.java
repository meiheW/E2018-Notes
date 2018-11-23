package _20180818_beike;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 山里有N个村庄，第i个村庄海拔高度为Aj。现在要在村庄之间修建道路，使得从每个村庄出发，都能达到其他所有村庄。
 * 在第i和j个村庄之间修建道路的费用取决于海拔较高的村庄的高度，即max{Ai，Aj},那么修建道路的总费用最少是多少？
 * @author Administrator
 *
 */

public class NO3 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		for(int i=0; i<num; i++){
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int sum = 0;
		for(int i=1; i<num; i++){
			sum+=arr[i];
		}
		System.out.println(sum);
	}
	
}
