package sword2offer;
import java.util.Stack;

public class T2_QueueByTwoStack {
	private Stack<Integer> s1 = new Stack<Integer>();
	private Stack<Integer> s2 = new Stack<Integer>();
	private int num = 0;
	public void push(int node){
		s1.push(node);
		num++;
	}
	
	public int pop() throws Exception{
		if(s2.isEmpty()){
			while(!s1.isEmpty()){
				s2.push(s1.pop());
			}
		}
		
		if(s2.isEmpty())
			throw new Exception("queue is empty");
		num--;
		return s2.pop();
	}
	
	public boolean isEmpty(){
		return num==0;
	}
	
	public int length(){
		return num;
	}
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		T2_QueueByTwoStack queue = new T2_QueueByTwoStack();
		queue.push(1);
		queue.push(11);
		queue.push(111);
		queue.push(1111);
		
		System.out.println(queue.length());
		while(!queue.isEmpty()){
			System.out.print(queue.pop()+ " " );
		}
		
		
	}

}
