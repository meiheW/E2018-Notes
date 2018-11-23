package _20180915_aiqiyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
局长有N种食物，每种食物有Ai份。
每天局长会吃一份食物，或者买一份食物（即每天只能进行吃或买其中的一种动作），这样过了M天
现在局长想知道M天后第p种食物的份数排名（从大到小，相同算并列，例如3 3 2，则排名为1 1 3）N,M,P<=100,Ai<=1000
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
