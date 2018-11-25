package coding_guide.stack_queue;

import java.util.*;

public class SortStack {
//////1.5用一个栈实现另一个栈的排序(栈底->栈顶 :从小到大)
	public static void sortStackByStack(Stack<Integer> stack)
	{
		Stack<Integer> help = new Stack<Integer>();
		while(!stack.isEmpty())
		{
			int cur = stack.pop();
			//栈里pop出的每个元素在help找到大于自己的元素位置
			while(!help.isEmpty() && help.peek()<cur)
			{
				stack.push(help.pop());
			}
			help.push(cur);		
		}

		while(!help.isEmpty())
		{
			stack.push(help.pop());
		}
	}
	
	public static void printStack(Stack<Integer> stack)
	{
		while(!stack.isEmpty())
		{
			System.out.println(stack.pop());
		}
	}
	
	public static void main1(String[] args) {
		// TODO 自动生成的方法存根
		Stack<Integer> ms = new Stack<Integer>();
		ms.add(2);
		ms.add(1);
		ms.add(4);
		ms.add(3);
		ms.add(7);
		ms.add(5);
		ms.add(8);
		
		sortStackByStack(ms);
		
		printStack(ms);
		
	}

}
