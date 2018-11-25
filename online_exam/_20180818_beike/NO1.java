package online_exam._20180818_beike;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * N个社团申请了某一天使用同一教室，假设第i个社团占用时间为[li，ri]
 * 现必须取消一个社团的预约，问有多少种取消方案？
 * 都不相交都输出，去除某个其余都不相交的则去除，去除哪个都没用的输出0
 * @author Administrator
 *
 */

class Interval{
	
	int begin;
	int end;
	public Interval(int begin, int end){
		this.begin = begin;
		this.end = end;
	}
	//判断两个区间是否相交
	boolean intersect(Interval other){
		if(this.end<=other.begin || this.begin>=other.end)
			return false;
		return true;
	}	
}

public class NO1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		ArrayList<Interval> al = new ArrayList<Interval>(); 
		for(int i=0; i<num; i++){
			int begin = sc.nextInt();
			int end   = sc.nextInt();
			al.add(new Interval(begin,end));
		}
		//保存相交结果
		int[] result = new int[num];
		for(int i=0; i<al.size()-1; i++){
			for(int j=i+1; j<al.size(); j++){
				if(al.get(i).intersect(al.get(j))){
					result[i]+=1;
					result[j]+=1;
				}
			}
		}
		
		
		boolean allzero = true;
		int upperonecount = 0;
		int onecount = 0;
		for(int i=0; i<al.size(); i++){
			if(result[i]!=0)
				allzero = false;
			
			if(result[i]==1){
				onecount++;
			}
			
			
			if(result[i]>1){
				upperonecount++;
			}
		}
		//全部不相交
		if(allzero==true){
			System.out.println(num);
			
			for(int i=1; i<=num; i++){
				System.out.print(i);
				if(i!=num)
					System.out.print(" ");
			}
			return;
		}
		
		if(upperonecount>=2){
			System.out.println("0");
			return;
		}
		
		if(onecount>1&&upperonecount>=1){
			System.out.println("0");
			return;
		}
		
	}
	
}
