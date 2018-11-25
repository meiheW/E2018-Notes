package onlineexam._20180909_jd;

import java.util.Scanner;

/**
  现有n个物品，每个物品有三个参数 ai , bi , ci ，
  定义i物品不合格品的依据是 : 
  若存在物品 j , 且aj>ai , bj>bi , cj>ci，则称i物品为不合格品
 * @author Administrator
 *
 */
public class NO2_compare {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int [][] para = new int [num][3];
		for(int i=0; i<num; i++){
			para[i][0] = sc.nextInt();
			para[i][1] = sc.nextInt();
			para[i][2] = sc.nextInt();
		}

		int count=0;
		for (int i=0; i<num; i++) {
			for (int j=0; j<num; j++) {
				if (j!=i) {
					if (para[i][0]<para[j][0] && para[i][1]<para[j][1] && para[i][2]< para[j][2]) {
						count++;
						break;
					}
				}

			}
		}

		
		
		System.out.println(count);
		
		
	}
	
	
}

