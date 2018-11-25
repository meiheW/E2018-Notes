package codingguide.stack_queue;

import java.util.*;

public class MaxRec {
//////1.9������Ӿ���Ĵ�С	
	//��ÿһ��Ϊ�׵ľ��ε����������
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
			//����ÿһ�У�����ÿһ��Ϊ�׵ľ��ε�������������ٱȽϵõ����ľ������
			maxArea = Math.max(maxRecFromBottom(height), maxArea);
		}
		return maxArea;
	}
	//ֱ��ͼ�������ε����
	public static int maxRecFromBottom(int[] height)
	{
		if(height == null || height.length == 0)
		{
			return 0;
		}
		int maxArea = 0;
		Stack<Integer> stack = new Stack<Integer>();//ջ�ڱ��������±�
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
			int curArea = (height.length - k - 1) * height[j];//ע��height.length
			maxArea = Math.max(maxArea, curArea);
		}
		
		return maxArea;
	}
	
	
	
	public static void main1(String[] args) {
		// TODO �Զ����ɵķ������
		
		int[] mymap = {3,4,5,4,3,6};
		int res = maxRecFromBottom(mymap);
		System.out.println(res);
		
		
	}

}
