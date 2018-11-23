import java.util.Stack;

public class T3_MinStack {
	
	public Stack<Integer> s;
	public Stack<Integer> smin;
    
	T3_MinStack(){
        this.s = new Stack<Integer>();
	    this.smin = new Stack<Integer>();
    }
    
    
	public void push(int node) {
        s.push(node);
        if(smin.isEmpty())
            smin.push(node);
        else if(node<this.min())	
        	smin.push(node);
        else
        	smin.push(this.min());
    }
    
    public void pop() {
        s.pop();
        smin.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int min() {
        return smin.peek();
    }
}
