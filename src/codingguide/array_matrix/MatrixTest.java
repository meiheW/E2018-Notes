package codingguide.array_matrix;

import java.util.ArrayList;
import java.util.Arrays;

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
	
	
}
