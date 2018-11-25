package codingguide.stack_queue;

import java.util.*;

//1.2双栈队列
public class TwoStackQueue {
	private Stack<Integer> stackPush;
	private Stack<Integer> stackPop;
	
	TwoStackQueue(){
		this.stackPush = new Stack<Integer>();
		this.stackPop = new Stack<Integer>();
	}
	public void add(int num){	
		stackPush.push(num);
	}
	public int poll(){
		if(stackPush.isEmpty()&&stackPop.isEmpty())
			throw new RuntimeException("no data.");
		if(!stackPush.isEmpty()&&stackPop.isEmpty()){
			while(!stackPush.isEmpty()){
				int ret = stackPush.pop();
				stackPop.push(ret);
			}
		}
		int value = stackPop.pop();
		return value;
	}
	public int peek(){
		if(stackPush.isEmpty()&&stackPop.isEmpty())
			throw new RuntimeException("no data.");
		if(!stackPush.isEmpty()&&stackPop.isEmpty()){
			while(!stackPush.isEmpty()){
				int ret = stackPush.pop();
				stackPop.push(ret);
			}
		}
		int value = stackPop.peek();
		return value;
	}
	
	
	public static void main1(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println("hello world.\n");
		TwoStackQueue tsq = new TwoStackQueue();
		tsq.add(12);
		tsq.add(34);
		tsq.add(56);
		System.out.println(tsq.peek());
		tsq.add(78);
		tsq.add(90);
		System.out.println(tsq.poll());
		
		tsq.add(21);
		tsq.add(43);
		System.out.println(tsq.peek());
		tsq.add(65);
		tsq.add(87);
		System.out.println(tsq.poll());
		tsq.add(98);
		tsq.add(111);
		System.out.println(tsq.peek());
		
		System.out.println(tsq.poll());
		System.out.println(tsq.poll());
		System.out.println(tsq.poll());
		System.out.println(tsq.poll());
		System.out.println(tsq.poll());
	}

}
