package StackandQueue;
import java.util.*;

public class GetArrNum {
	//1.10���ֵ����Сֵ <= num������������
	public static int getNum(int[] arr, int num)
	{
		if(arr == null || arr.length == 0)
			return 0;
		LinkedList<Integer> qmin = new LinkedList<Integer>();
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		
		int i = 0;
		int j = 0;
		int res = 0;
		
		while(i<arr.length)//����������[i,j]
		{
			while(j<arr.length)
			{
				while(!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j])
					qmin.pollLast();
				qmin.addLast(j);
				
				while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j])
					qmax.pollLast();
				qmax.addLast(j);
				//qmax,qmin�洢�����ֵ����Сֵ���±꣬������Ԫ��Ϊ��ǰ����������Сֵ�±�
				if(arr[qmax.getFirst()] - arr[qmin.getFirst()] > num)
					break;
				
				j++;
			}
			//����ѭ����˵��[i,j]�������С��ֵ����num,��Ҫ�ƶ�i
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
		// TODO �Զ����ɵķ������
		int[] arr = {1,1,1,4};
		int num = 2;
		int res = getNum(arr, num);

		System.out.println(res);
	}

}
