package _20180912_thunder;

import java.util.Scanner;

//�к��������ɫ�ķ����ľ����ɫ��������A����ɫ������B��
//ѡ��17���ľ�ų�һ�ţ�ʹ����������7���ľ֮�Ͷ�С��0��
//�����ѡ����ʹ17���ľ֮��������ֵ�Ƕ��٣�

public class NO2 {
	public static void main(String[] args) {
		/*
		 * ����A������B, A��B����ֵС��10000
		 */
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		if(A+6*B >= 0)	return;
		
		int i;	//�����ĸ���
		int sum = 0;
		for(i=6; i>=1; i++){
			sum = i*A + (7-i)*B;
			if(sum < 0)
				break;
		}
		
		int max = (i>=3) ? 2*sum+3*A : 2*sum+i*A+(3-i)*B ;
		System.out.println(max);
		
		
	}
}
