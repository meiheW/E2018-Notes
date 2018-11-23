package StackandQueue;

import java.util.*;

public class GetMaxWindow {
	//1.7生成窗口最大值数组
	public static int[] getMaxWindow(int[] arr, int w)
	{
		if(arr == null || arr.length < w || w < 1 )
		{
			return null;
		}
		int[] res = new int[arr.length - w + 1];
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		int index = 0;
		for(int i=0; i<arr.length; i++)
		{
			while(!qmax.isEmpty() && arr[qmax.peekLast()]<=arr[i])
			{
				qmax.pollLast();
			}
			
			qmax.addLast(i);
			if(qmax.peekFirst() == i-w)
			{
				qmax.pollFirst();
			}
			if(i >= w-1)
			{
				res[index++] = arr[qmax.peekFirst()];
			}	
		}
		
		return res;
	}
	
	
	public static void main1(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = {4,3,5,4,3,3,6,7};
		int win_size = 3;
		
		int[] res = getMaxWindow(arr, win_size);
		
		for(int i=0; i<res.length; i++)
		{
			System.out.println(res[i]);
		}
	}

}
