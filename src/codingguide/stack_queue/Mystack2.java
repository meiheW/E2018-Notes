package codingguide.stack_queue;

import java.util.*;
//1.1设计一个有getMin功能的栈                                                                                                                                                             
public class Mystack2 {
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	
	Mystack2(){
		this.stackData = new Stack<Integer>();
		this.stackMin = new Stack<Integer>();
	}
	
	public void push(int num){
		stackData.push(num);
		if(stackMin.isEmpty())
			stackMin.push(num);
		else if(num <= this.getMin())
			stackMin.push(num);
		else
			stackMin.push(this.getMin());
	}
	
	public int pop(){
		if(stackData.isEmpty())
			throw new RuntimeException("stack data is empty.");
	
		int value = stackData.pop();
		stackMin.pop();
		return value;
	}
	
	public int getMin(){
		if(stackData.isEmpty())
			throw new RuntimeException("stack data is empty.");
		
		return stackMin.peek();
	}
	
	
	public static void main1(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println("hello world.\n");
		Mystack2 ms = new Mystack2();
		ms.push(3);
		ms.push(4);
		ms.push(5);
		ms.push(1);
		int num = ms.getMin();
		System.out.println(num);
	}

}
