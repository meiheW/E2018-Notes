package _20180920_bytedance;

import java.util.Scanner;

public class NO4_colorfulballs {
	static int N = 505;
	//static int mod = 1000000007 ; 

	static int dp[] = new int[10*N];
	static int[][] C= new int[N+5][N+5];
	static int E[][] = new int[N+5][N+5];
	static int fact[] = new int[N+5];
	static int a[] = new int[N+5];
	
	static int n,sum,ans;
	static int inv[] = new int[N+5];
	static int inv_fact[] = new int[N+5];
	static int coef[] = new int[N+5];;  



	public static  void Pre(){
	    C[0][0] = 1;
	    for(int i = 1,j; i <= N; i ++)
	        for(j = C[i][0] = 1; j <= i; j ++)
	            C[i][j] = (C[i-1][j-1] + C[i-1][j]);
	    for(int i = 1,e; i <= N; i ++)
	        for(int j = i; j >= 1; j --)
	            E[i][j] = (C[i-1][j-1]);
	    fact[0] = inv[0] = 1 ;
	    inv[1] = inv_fact[0] = 1 ;
	    for(int i = 1; i <= N; i ++){
	        fact[i] =i * fact[i-1] ;
	        
	        inv_fact[i] = inv_fact[i-1] * inv[i] ; 
	    }return ; 
	}

	public static void main(String[] args) {
	    Pre() ;
	    n=3;
	    Scanner sc = new Scanner(System.in);
	    sum = 0; dp[0] = 1 ;
	    for(int i = 1; i <= N; i ++) dp[i] = 0;
	    for(int sq = 1; sq <= n; sq ++){
	        a[sq] = sc.nextInt();
	        for(int k = 1; k <= a[sq]; k ++)
	            coef[k] =E[a[sq]][k] * inv_fact[k];
	        for(int j = sum; j >= 0; j --){
	            int tmp = dp[j] ;
	            dp[j] = 0;
	            //for(int k = 0; k <= a[sq]; k ++)
	        }
	        sum += a[sq];
	    }
	    ans = 0;
	    for(int k = 0; k <= sum; k ++) 
	    	ans = upt(ans , dp[k] * fact[k]) ;
	   System.out.println(ans);
	}

	private static int upt(int ans2, int i) {
		ans2+=i;
		return ans2;
	}
	
}

