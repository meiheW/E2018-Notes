package online_exam._20180915_aiqiyi;

import java.util.Scanner;

/**
 * СC��һ��Ʊ������Ʊ��ID�ǳ���Ϊ6���ַ�����ÿ���ַ��������֣����������ID�����������ID���������Ϳ�ʼ����ID��
 * ÿһ�β�����������ѡ������һ�����ֲ����滻����
 * ������ID��ǰ��λ����֮�͵��ں���λ����֮�ͣ���ô���ID�������˵ġ�
 * ���СC��һ�£�������Ҫ�������Σ���ʹID�������ID
 * @author Administrator
 *
 */
public class NO1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		//check the input string.
		if(str==null || str.length()!=6)
			return;
		for(int i=0; i<6; i++){
			if(str.charAt(i)<'0' || str.charAt(i)>'9')
				return;
		}
		
		int[] arr = new int[6];
		for(int i=0; i<6; i++){
			arr[i] = str.charAt(i)-'0';
		}
		//printArr(arr);
		int sum1 = getSum(arr, 0, 3);
		int sum2 = getSum(arr, 3, 6);
		
		if(sum1 == sum2){
			System.out.println(0);
			return;
		}
		
		
		if(sum1>sum2){
			swap(arr, 0, 5);
			swap(arr, 1, 2);
			swap(arr, 3, 4);
		}
		
		sum1 = getSum(arr, 0, 3);
		sum2 = getSum(arr, 3, 6);
		
		
		//System.out.println("hello");
		
		int count = 0;
		while(sum1 < sum2){
			
			int sum1_min = getmin(arr, 0, 3);
			int sum2_max = getmax(arr, 3, 6);
			
			if(9-sum1_min < sum2_max){
				int index = getMaxIndex(arr, 3, 6);
				arr[index] = 0;
			}else{
				int index = getMinIndex(arr, 0, 3);
				arr[index] = 9;
			}
			
			count++;
			
			sum1 = getSum(arr, 0, 3);
			sum2 = getSum(arr, 3, 6);
		}
		
		System.out.println(count);
		
	}

	private static int getMinIndex(int[] arr, int a, int b) {
		int index = 0;
		int min =10;
		for(int i=a; i<b; i++){
			if(arr[i]<min){
				min = arr[i];
				index = i;
			}
		}
		return index;
	}

	private static int getMaxIndex(int[] arr, int a, int b) {
		int index = 0;
		int max =0;
		for(int i=a; i<b; i++){
			if(arr[i]>max){
				max = arr[i];
				index = i;
			}
		}
		return index;
		
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}

	private static int getmin(int[] arr, int a, int b) {
		int min = 10;
		for(int i=a; i<b; i++){
			if(arr[i]<min){
				min = arr[i];
			}
		}
		return min;
	}
	
	private static int getmax(int[] arr, int a, int b) {
		int max = 0;
		for(int i=a; i<b; i++){
			if(arr[i]>max){
				max = arr[i];
			}
		}
		return max;
	}

	private static int getSum(int[] arr, int a, int b) {
		int sum = 0;
		for(int i=a; i<b;i++){
			sum += arr[i];
		}
		return sum;
	}

	
	
	private static void printArr(int[] arr) {
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
			
		}
		
	}
}
