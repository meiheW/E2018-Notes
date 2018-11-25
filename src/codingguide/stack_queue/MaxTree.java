package codingguide.stack_queue;

import java.util.*;

public class MaxTree {
	//1.8构造数组的MaxTree
	public static void popStackSetMap(Stack<Node> stack, HashMap<Node, Node> map)
	{
		Node popNode = stack.pop();
		if(stack.isEmpty())
			map.put(popNode, null);
		else
			map.put(popNode, stack.peek());
	}
	public static Node getMaxTree(int[] arr) //3,1,2
	{
		Node[] nArr = new Node[arr.length];
		for(int i=0; i<arr.length; i++){
			nArr[i] = new Node(arr[i]);
		}
		Stack<Node> stack = new Stack<Node>();
		HashMap<Node,Node> lBigMap = new HashMap<Node,Node>();
		HashMap<Node,Node> rBigMap = new HashMap<Node,Node>();
		//从左到右将每个节点压栈判断其左边第一个大于自己的元素的位置
		for(int i=0; i<arr.length; i++){
			Node curNode = nArr[i];
			while(!stack.isEmpty() && stack.peek().value < curNode.value)
			{
				popStackSetMap(stack, lBigMap);
			}
			stack.push(curNode);
		}
		while(!stack.isEmpty())
		{
			popStackSetMap(stack, lBigMap);
		}
		//从右到左将每个节点压栈判断其右边第一个大于自己的元素的位置
		for(int i=arr.length-1; i>=0; i--){
			Node curNode = nArr[i];
			while(!stack.isEmpty() && stack.peek().value < curNode.value)
			{
				popStackSetMap(stack, rBigMap);
			}
			stack.push(curNode);
		}
		while(!stack.isEmpty())
		{
			popStackSetMap(stack,rBigMap);
		}
		Node head = null;
		for(int i=0; i<arr.length; i++){
			Node curNode = nArr[i];
			Node left = lBigMap.get(curNode);
			Node right = rBigMap.get(curNode);
			
			if(left == null && right == null){
				head = curNode;
			}else if(left == null){
				if(right.left == null)
					right.left = curNode;
				else
					right.right = curNode;
			}else if(right == null){
				if(left.left == null)
					left.left = curNode;
				else
					left.right = curNode;
			}else{
				Node parent = left.value < right.value ? left : right;
				if(parent.left == null)
					parent.left = curNode;
				else
					parent.right = curNode;
			}
		}
		return head;
	}

	public static void bianli(Node treeNode)
	{
		if(treeNode != null) {
			System.out.println(treeNode.value);
			bianli(treeNode.left);
			bianli(treeNode.right);
		}
	}
	
	
	public static void main1(String[] args) {
		// TODO 自动生成的方法存根
		
		int[] arr = {3,1,2};
		
		Node mn = getMaxTree(arr);
		
		bianli(mn);
		

	}

}
