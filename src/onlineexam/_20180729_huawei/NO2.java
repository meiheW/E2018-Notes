package onlineexam._20180729_huawei;

import java.util.Scanner;

public class NO2 {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		int Weight = sc.nextInt();
		String[] split1 = str1.split(",");
		String[] split2 = str2.split(",");
		
		int[] val = new int[split1.length];
		for(int i=0; i<split1.length; i++){
			val[i] = Integer.parseInt(split1[i]);
		}
		int[] wt = new int[split2.length];
		for(int i=0; i<split2.length; i++){
			wt[i] = Integer.parseInt(split2[i]);
		}
		//mytest
		//int val[] = {6, 3, 5, 4, 6};
        //int wt[] = {2, 2, 6, 5, 4};
        //int Weight = 10;
 
        System.out.println(thiefVal(val, wt, Weight));
    }
 
    public static int thiefVal(int val[], int wt[], int W) {
        
    	int N = wt.length; 
        int[][] V = new int[N + 1][W + 1]; 
        //赋值
        for (int col = 0; col <= W; col++) {
            V[0][col] = 0;
        } 
        for (int row = 0; row <= N; row++) {
            V[row][0] = 0;
        }
        //动态规划
        for (int i=1;i<=N;i++){
            for (int j=1;j<=W;j++){
                if (wt[i-1]<=j){
                    V[i][j]=Math.max (val[i-1]+V[i-1][j-wt[i-1]], V[i-1][j]);
                }
                else {
                    V[i][j]=V[i-1][j];
                }
            }
        }
 
//        for (int[] rows : V) {
//            for (int col : rows) {
//                System.out.format("%5d", col);
//            }
//            System.out.println();
//        }
 
        return V[N][W];
    }
}
