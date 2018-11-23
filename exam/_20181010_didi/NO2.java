package _20181010_didi;

import java.util.Scanner;
import java.util.Stack;

public class NO2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] truckA = new int[4];
		int[] truckB = new int[4];
		//初始化进站出站数组
		for(int i=0; i<4; i++){
			truckA[i] = i+1;
			truckB[i] = sc.nextInt();
		}
		
		if(isPopOrder(truckA, truckB))
			System.out.println("Yes");
		else
			System.out.println("No");
		
		
		
	}
	
	//判断truckB是否为truckA的出栈顺序
	public static boolean isPopOrder(int [] truckA,int [] truckB) {
	    if(truckA==null||truckB==null||truckA.length==0||truckB.length==0||truckA.length!=truckB.length)
	    	return false;
		
	    Stack<Integer> s = new Stack<Integer>();
		for(int i=0,j=0; i<truckA.length; i++){
			s.push(truckA[i]);
			while(!s.isEmpty() && s.peek()==truckB[j]){
				s.pop();
				j++;
			}
			
		}
		
		return s.isEmpty();
    }
}
