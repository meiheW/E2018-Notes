package codingguide.stack_queue;

import java.util.*;

public class MaxRec {
//////1.9求最大子矩阵的大小	
	//以每一行为底的矩形的最大矩形面积
	public static int maxRecSize(int[][] map)
	{
		if(map == null || map.length == 0 || map[0].length == 0)
			return 0;
		
		int maxArea = 0;
		int[] height = new int[map[0].length];
		for(int i=0; i<map.length; i++)
		{
			for(int j=0; j<map[0].length; j++)
			{
				height[j] = map[i][j] == 0 ? 0 : height[j]+1;
			}
			//对于每一行，求以每一行为底的矩形的最大矩形面积，再比较得到最大的矩形面积
			maxArea = Math.max(maxRecFromBottom(height), maxArea);
		}
		return maxArea;
	}
	//直方图中最大矩形的面积
	public static int maxRecFromBottom(int[] height)
	{
		if(height == null || height.length == 0)
		{
			return 0;
		}
		int maxArea = 0;
		Stack<Integer> stack = new Stack<Integer>();//栈内保存数组下标
		for(int i=0; i<height.length; i++)
		{
			while(!stack.empty() && height[i] <= height[stack.peek()])
			{
				int j = stack.pop();
				int k = stack.isEmpty() ? -1 : stack.peek();
				int curArea = (i-k-1)*height[j];
				maxArea = Math.max(curArea, maxArea);	
			}
			stack.push(i);
		}
		while(!stack.isEmpty())
		{
			int j = stack.pop();
			int k = stack.isEmpty() ? -1 : stack.peek();
			int curArea = (height.length - k - 1) * height[j];//注意height.length
			maxArea = Math.max(maxArea, curArea);
		}
		
		return maxArea;
	}
	
	
	
	public static void main1(String[] args) {
		// TODO 自动生成的方法存根
		
		int[] mymap = {3,4,5,4,3,6};
		int res = maxRecFromBottom(mymap);
		System.out.println(res);
		
		
	}

}
