package ArrayAndMatrix;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class MatrixTest {
	
	//排序数组中寻找特定值
	public boolean findNumInSortedMatrix(int[][] matrix, int target){
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		int curR = 0; 
		int curC = matrix[0].length-1;
		boolean found = false;
		while(curR<rows && curC>=0){
			if(matrix[curR][curC]==target){
				found = true;
				break;
			}
			if(matrix[curR][curC]<target)
				curR++;
			else if(matrix[curR][curC]>target)
				curC--;
			
		}
		return found;
	
	}
	
	@Test
	public void demo(){
		int[][] matrix = new int[][]{
										{0,1,2,5},
										{2,3,4,7},
										{4,4,4,8},
										{5,7,7,9}
									};
		boolean res = findNumInSortedMatrix(matrix, 10);
		System.out.println(res);
	}
	
	
	
	
}
