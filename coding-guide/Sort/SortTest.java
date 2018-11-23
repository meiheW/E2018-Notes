package Sort;

import java.util.Arrays;

public class SortTest {
	
	//插入排序
	public static void InsertSort(int[] arr)
	{
		int size = arr.length;
		if(size == 0 || size == 1) 
			return;
		
		
		for(int i=1; i<arr.length; i++)
		{
			int temp = arr[i];
			int j=0;
			for(j=i-1; j>=0&&arr[j]>temp; j--)
			{
					arr[j+1] = arr[j];
			}
			arr[j+1] = temp;
			
			System.out.print(i+":");
			PrintArray(arr);
		}
		
	}
	
	//希尔排序
	public static void ShellSort(int[] arr)
	{
		int size = arr.length;
		for(int dk=size/2; dk>=1; dk/=2)
		{
			System.out.println("dk="+dk);
			for(int i=dk; i<size; i++)
			{
				int temp = arr[i];
				int j=0;
				for(j=i-dk; j>=0&&arr[j]>temp; j-=dk)
				{
					arr[j+dk] = arr[j];
				}
				arr[j+dk] = temp;
				
				System.out.print(i+":");
				PrintArray(arr);
			}
		}
		
	}
	
	//选择排序
	public static void SelectSort(int[] arr)
	{
		int size = arr.length;
		for(int i=0; i<size-1; i++)
		{
			int min = arr[i];
			int k=i;
			for(int j=i+1; j<size; j++){
				if(min>arr[j]){
					min=arr[j];
					k=j;
				}
			}
			if(k!=i){
				int temp = arr[i];
				arr[i] = arr[k];
				arr[k] = temp;
			}
			
			System.out.print(i+":");
			PrintArray(arr);
			
		}
		
		
		
	}
	
	//堆排序
	public static void HeapSort(int[] arr)
	{
		int size = arr.length;
		for(int i=0; i<size-1; i++){
			BuildMaxHeap(arr,size-i-1);
			Swap(arr,0,size-i-1);
		}
	}
	
	
	public static void BuildMaxHeap(int[] data, int lastIndex)
	{
		//int size = data.length;
		for(int i=(lastIndex-1)/2; i>=0; i--)	//i代表节点下标
		{
			int k = i;							//k当前节点
			
			while(2*k+1 <= lastIndex){
				int biggerIndex = 2*k+1;
				if(2*k+1 < lastIndex && data[2*k+1]<data[2*k+2])
					++biggerIndex;
				
				if(data[k] < data[biggerIndex]){
					Swap(data, k, biggerIndex);
					k=biggerIndex;
				}
				else {
					break;
				}
			}	
		}
		
	}
	
	public static void Swap(int[] arr, int a, int b)
	{
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	//冒泡排序
	public static void BubbleSort(int[] arr)
	{
		int size  =arr.length;
		for(int i=0; i<size-1; i++)
		{
			for(int j=0; j<size-1-i; j++)
			{
				if(arr[j] > arr[j+1])
					Swap(arr, j, j+1);
			}
		}
	}
	//快速排序
	public static void QuickSort(int[] arr, int low, int high)
	{
		if(low < high)
		{
			int middle = GetMiddle(arr, low, high);
			QuickSort(arr, low, middle-1);
			QuickSort(arr, middle+1, high);
		}
	}
	
	public static int GetMiddle(int[] arr, int low, int high)
	{
		int privotKey = arr[low];
		while(low < high)
		{
			while(low<high && arr[high]>=privotKey)		high--;
			Swap(arr, low, high);
			while(low<high && arr[low]<=privotKey)		low++;
			Swap(arr, low, high);
		}
		
		return low;
	}
	//归并排序
	public static void MergeSort(int[] arr, int low, int high)
	{
		int mid = (low+high)/2;
		if(low<high)
		{
			MergeSort(arr, low, mid);
			MergeSort(arr, mid+1, high);
			Merge(arr, low, mid, high);
		}
	}
	
	public static void Merge(int[] arr, int low, int mid, int high)
	{
		int rf[] = new int[high-low+1];
		
		int i=low;
		int j=mid+1;
		int k=0;
		while(i<=mid && j<=high)
		{
			if(arr[i] < arr[j])
				rf[k++] = arr[i++];
			else
				rf[k++] = arr[j++];
		}
		
		while(i<=mid)
		{
			rf[k++] = arr[i++];
		}
		while(j<=high)
		{
			rf[k++] = arr[j++];
		}
		
		for(i=0; i<high-low+1; i++)
			arr[i+low] = rf[i];
		
	}
	
	//二分查找(循环)
	public static int commonBinarySearch(int[] arr, int k){
		if(arr==null||arr.length==0)
			return -1;
		int low=0;
		int high=arr.length-1;
		int mid = 0;
		while(low<=high){
			mid = low+(high-low)/2;//important
			if(arr[mid]<k)
				low=mid+1;
			else if(arr[mid]>k)
				high=mid-1;
			else
				return mid;
		}
		return -1;
		
	} 
	//二分查找(递归)
	public static int recursionBinarySearch(int[] arr, int k, int low, int high){
		if(arr==null||arr.length==0||low>high||arr[low]>k||arr[high]<k)	return -1;
		int mid = low+(high-low)/2;
		if(arr[mid]<k)
			return recursionBinarySearch(arr, k, mid+1,high);
		else if(arr[mid]>k)
			return recursionBinarySearch(arr, k, low, mid-1);
		else
			return mid;
		
	}
	
	public static void PrintArray(int[] arr)
	{
		for(int i=0; i<arr.length; i++)
		{
			System.out.print(arr[i]);
			if(i!=arr.length-1)
				System.out.print(" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		int[] a = new int[]{3,1,5,7,2,4,9,6,8};
		PrintArray(a);
		Arrays.sort(a);
		PrintArray(a);
		System.out.println(commonBinarySearch(a,7));
		System.out.println(recursionBinarySearch(a,7,0,8));
		//SortTest1.main(null);
		//InsertSort(a);
		//ShellSort(a);
		//SelectSort(a);
		//HeapSort(a);
		//BubbleSort(a);
		//QuickSort(a, 0, 8);
		//MergeSort(a,0,8);
		//PrintArray(a);
	}
}
