package onlineexam._20180909_bytedance;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 前后左右相邻的为一个部门
 * 矩阵中一共有多少相邻块
 * @author Administrator
 *
 */
public class MergeDepartment {
	
	static	ArrayList<Team> list = new ArrayList<Team>();
	static int[][] matrix=null;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = Integer.valueOf(sc.nextLine());
		//check
		if(M<=1||M>=1000)	return;
		
		matrix = new int[M][M];
		//input
		for(int i=0; i<M; i++){
			for(int j=0; j<M; j++){
				int cur= sc.nextInt();
				matrix[i][j] =  cur;
				if(cur==1)
					list.add(new Team(i, j));
			}
			
		}
		//printArr(matrix, M);
		
		int count = 0;
		while (list.size() != 0) {
			if (list.size() == 1) {
				count++;
				break;
			}
			Team o = list.get(0);
			delete(o);
			count++;
		}
		System.out.println(count);
		
	}

	private static void delete(Team o) {
		int i = o.i;
		int j = o.j;
		matrix[i][j] = 4;
		list.remove(o);
		if (i < matrix.length - 1 && matrix[i + 1][j] == 1) {
			Team oD = new Team(i + 1, j);
			delete(oD);
		}
		if (i > 0 && matrix[i - 1][j] == 1) {
			Team oU = new Team(i - 1, j);
			delete(oU);
		}
		if (j < matrix[i].length - 1 && matrix[i][j + 1] == 1) {
			Team oR = new Team(i, j + 1);
			delete(oR);
		}
		if (j > 0 && matrix[i][j - 1] == 1) {
			Team oL = new Team(i, j - 1);
			delete(oL);
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

//info of point
class Team {
	int i;
	int j;

	public Team(int i, int j) {
		super();
		this.i = i;
		this.j = j;
	}

	public String toString() {
		return "(" + this.i + "," + this.j + ")";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		result = prime * result + j;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		if (i != other.i)
			return false;
		if (j != other.j)
			return false;
		return true;
	}
}
