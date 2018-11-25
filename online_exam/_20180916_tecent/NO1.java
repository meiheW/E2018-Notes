package online_exam._20180916_tecent;

import java.util.Scanner;

public class NO1 {

	static int lcm(int a, int b){
		 int maxnum = Math.max(a,b);
		 int minnum = Math.min(a,b);
		 int ans = 0;
		 for(int i=0; i<=100000; i++){
			 ans = i*maxnum;
			 if(ans%minnum==0)
				 return ans;
			 
		 }
		return ans;
				 
	}

    public static void process(int n){
		int mlcm = 1;
			    
		for(int i=0; i<n; i++){
			 mlcm = lcm(mlcm, i);
			int nlcm = 1;
			
			for(int m=n; i<2*n; i++){
				if(nlcm % m!=0){
					nlcm = lcm(nlcm, m);
		            if (mlcm == nlcm){
		            	System.out.println(m);
		                return;
		            }
				}
			                
		        if(mlcm % m!=0){
		            mlcm = lcm(mlcm, m);
		            if(mlcm == nlcm){
		                System.out.println(m);
		                return;
		            }
		        }
			}
			
			
		}
	
	
	
	}
	    
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		process(num);
		System.out.println();
	}
}
