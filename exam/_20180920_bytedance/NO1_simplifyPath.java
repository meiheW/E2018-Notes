package _20180920_bytedance;

import java.util.Scanner;
import java.util.Stack;

public class NO1_simplifyPath {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(simplifyPath(str));
	}
	
	
    public static String simplifyPath(String path) {
        
        String[] strings = path.split("/");
        Stack<String> stack = new Stack<String>();
        for(int i=0;i<strings.length;++i){
            if(".".equals(strings[i])||"".equals(strings[i]))
                continue;
            if("..".equals(strings[i])){
                if(!stack.empty())
                	stack.pop();
            }else
            	stack.push(strings[i]);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()){
            sb.insert(0,stack.pop());
            sb.insert(0,"/");
        }
        if(sb.length()==0)
            sb.append("/");
        
        return sb.toString();    
    }

	
}
