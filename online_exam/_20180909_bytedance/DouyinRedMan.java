package online_exam._20180909_bytedance;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A->B,B->C,��A->C
 * N:�û���
 * M:��ע��
 * ��ע��ϵ��
 * @author Administrator
 *
 */
public class DouyinRedMan {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		ArrayList<FocusRe> al = new ArrayList<FocusRe>();
		
		for(int i=0; i<M; i++){
			int f = sc.nextInt();
			int b = sc.nextInt();
			al.add(new FocusRe(f, b));
		}
		
		//��¼��ע���뱻��ע��֮��Ĺ�ϵ
		int[][] map = new int[N+1][N+1];
		for(int i=0; i<al.size(); i++)
			map[al.get(i).focusor][al.get(i).bfocusor] = 1;
		printArr(map, N+1);


		int[] fansNum = new int[N+1]; 
		for(int i=1; i<=N; i++){
			for(int j=1; j<=N; j++){
				if(map[j][i]==1)
					fansNum[i]++;
				
			}
			
		}
		
		
		
	}
	
	
	private static void printArr(int[][] matrix,int M) {
		for(int i=0; i<M; i++){
			for(int j=0; j<M; j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	
	
}

class FocusRe{
	
	int focusor;
	int bfocusor;
	
	public FocusRe(int f, int b) {
		this.focusor = f;
		this.bfocusor = b;
	}
	
}