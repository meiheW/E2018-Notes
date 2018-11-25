package online_exam._20180722_pdd;

import java.util.*;

public class PingDuoDuo1 {
	//ABCD四人喝可乐，喝完一个变两个再到对尾排队，求第N个喝可乐的人名
	
	public static String getName(int num){
		String[] name = new String[]{"A","B","C","D"};
		if(num>=1&&num<=4)	return name[num-1];
		int sum = 4;
		int k = 2;
		
		return "0";
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String name = getName(num);
		System.out.println(name);
	}
	
}


