package _20180915_aiqiyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
�ֳ���N��ʳ�ÿ��ʳ����Ai�ݡ�
ÿ��ֳ����һ��ʳ�������һ��ʳ���ÿ��ֻ�ܽ��гԻ������е�һ�ֶ���������������M��
���ھֳ���֪��M����p��ʳ��ķ����������Ӵ�С����ͬ�㲢�У�����3 3 2��������Ϊ1 1 3��N,M,P<=100,Ai<=1000
 * @author Administrator
 *
 */
public class NO2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n1 = sc.nextLine();
		String[] split1 = n1.split(" ");
		int N = Integer.parseInt(split1[0]);
		int M = Integer.parseInt(split1[1]);
		int P = Integer.parseInt(split1[2]);
		
		int[] food = new int[N];
		String n2 = sc.nextLine();
		String[] split2 = n2.split(" ");
		for(int i=0; i<N; i++){
			food[i] = Integer.parseInt(split2[i]);
		}
		//printFood(food);
		
		ArrayList<Integer> operations = new ArrayList<Integer>(); 
		for(int i=0; i<M; i++){
			String op = sc.nextLine();
			String[] str = op.split(" ");
			String AorB = str[0];
			int index = Integer.parseInt(str[1]);
			operations.add(AorB.equals("A") ? index : (-1)*index);
			
		}
		
		for(int i=0; i<operations.size(); i++){
			int num = operations.get(i);
			if(num<0){
				 --food[(-1)*num-1];
			}else{
				++food[num-1];
			}
		}
		
		int target = food[P];
		int grade = 1;
		for(int i=0; i<food.length; i++){
			if(food[i] > target)
				grade++;
		}
		System.out.println(grade);
		
	}

	private static void printFood(int[] food) {
		for (int i=0; i<food.length; i++)
			System.out.println(food[i]+" ");
		
	}


	
}
