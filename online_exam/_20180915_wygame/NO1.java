package online_exam._20180915_wygame;

import java.util.Scanner;

public class NO1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		
		int kk = tt(str1, str2);
		System.out.println(kk);
	}
	
	
	public static int tt(String str1, String str2)
	{
		if(str1==null||str2==null)
			return 0;
		
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		int r = chs1.length + 1;
		int c = chs2.length + 1;
		int[][] dp = new int[r][c];
		for(int i=0; i<r; i++)
			dp[i][0] = i;
		for(int j=0; j<c; j++)
			dp[0][j] = j;
		
		for(int i=1; i<r; i++){
			for(int j=1; j<c; j++){
				if(chs1[i-1] == chs2[j-1]) {
					dp[i][j] = dp[i-1][j-1];
				}else {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				dp[i][j] = Math.min(dp[i][j], dp[i][j-1]+1);
				dp[i][j] = Math.min(dp[i][j], 1+dp[i-1][j]);
			}
		}
		
		return dp[r-1][c-1];
	}
	
}
