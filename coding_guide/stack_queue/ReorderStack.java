package coding_guide.stack_queue;

import java.util.*;

//
public class ReorderStack {
//////1.3���õݹ麯����ջ��������һ��ջ
	//��ջ��ջ��Ԫ�ط��ز��Ƴ�
	public static int getAndRemoveLastElement(Stack<Integer> stack)
	{
		int result = stack.pop();
		if(stack.isEmpty()){
			return result;
		}
		else {
			int last = getAndRemoveLastElement(stack);
			stack.push(result);
			return last;
		}
	}
	//����һ��ջ
	public static void reserse(Stack<Integer> stack)
	{
		if(stack.isEmpty())
			return;
		int i = getAndRemoveLastElement(stack);
		reserse(stack);
		stack.push(i);
	}
	
	public static void printStack(Stack<Integer> stack)
	{
		while(!stack.isEmpty())
		{
			System.out.println(stack.pop());
		}
	}
	
	public static void main1(String[] args) {
		// TODO �Զ����ɵķ������
		Stack<Integer> ms = new Stack<Integer>();
		ms.add(1);
		ms.add(11);
		ms.add(111);
		
		reserse(ms);
		
		printStack(ms);
		
		
	}

}
