package _20180818_beike;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ɽ����N����ׯ����i����ׯ���θ߶�ΪAj������Ҫ�ڴ�ׯ֮���޽���·��ʹ�ô�ÿ����ׯ���������ܴﵽ�������д�ׯ��
 * �ڵ�i��j����ׯ֮���޽���·�ķ���ȡ���ں��νϸߵĴ�ׯ�ĸ߶ȣ���max{Ai��Aj},��ô�޽���·���ܷ��������Ƕ��٣�
 * @author Administrator
 *
 */

public class NO3 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		for(int i=0; i<num; i++){
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int sum = 0;
		for(int i=1; i<num; i++){
			sum+=arr[i];
		}
		System.out.println(sum);
	}
	
}
