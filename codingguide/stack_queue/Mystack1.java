package codingguide.stack_queue;
import java.util.*;

//1.1设计一个有getMin功能的栈                                                                                                                                 
public class Mystack1 {
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;

	public Mystack1(){
		this.stackData = new Stack<Integer>();
		this.stackMin = new Stack<Integer>();
	}
	
	public void push(int newNum){
		if(this.stackData.isEmpty())
			stackMin.push(newNum);
		else if(newNum <= this.getMin())
			stackMin.push(newNum);
		
		stackData.push(newNum);
	}
	
	public int pop(){
		if(stackData.isEmpty())
			throw new RuntimeException("stack is empty.");
		int value = stackData.pop();
		if(value <= this.getMin())
			this.stackMin.pop();
		
		return value;
	}
	
	public int getMin(){
		if(stackMin.isEmpty())
			throw new RuntimeException("stack is empty.");
		return this.stackMin.peek();
	}
	
	
	public static void main1(String[] args)
	{
		Mystack1 ms = new Mystack1();
		ms.push(3);
		ms.push(4);
		ms.push(5);
		ms.push(1);
		int num = ms.getMin();
		System.out.println(num);
		
	}
}
