package StackandQueue;
import java.util.*;

public class GetArrNum {
	//1.10最大值减最小值 <= num的子数组数量
	public static int getNum(int[] arr, int num)
	{
		if(arr == null || arr.length == 0)
			return 0;
		LinkedList<Integer> qmin = new LinkedList<Integer>();
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		
		int i = 0;
		int j = 0;
		int res = 0;
		
		while(i<arr.length)//子数组区间[i,j]
		{
			while(j<arr.length)
			{
				while(!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j])
					qmin.pollLast();
				qmin.addLast(j);
				
				while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j])
					qmax.pollLast();
				qmax.addLast(j);
				//qmax,qmin存储了最大值或最小值的下标，队列首元素为当前区间最大或最小值下标
				if(arr[qmax.getFirst()] - arr[qmin.getFirst()] > num)
					break;
				
				j++;
			}
			//跳出循环后，说明[i,j]内最大最小差值大于num,需要移动i
			if(qmin.peekFirst() == i)
				qmin.pollFirst();
			if(qmax.peekFirst() == i)
				qmax.pollFirst();
			res += j-i;
			i++;
		}
		return res;
	}
	
	public static void main1(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = {1,1,1,4};
		int num = 2;
		int res = getNum(arr, num);

		System.out.println(res);
	}

}
