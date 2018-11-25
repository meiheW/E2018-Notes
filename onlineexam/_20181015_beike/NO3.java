package onlineexam._20181015_beike;

import java.util.ArrayList;
import java.util.Scanner;

public class NO3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(getResult(str));
		
		//String str="027555+692-0xD32C";
		//System.out.println(str.substring(0, 5));
		//System.out.println(getResult(str));
		//int num = Integer.valueOf("027555", 8)-Integer.valueOf("D32C", 16)+692;
		//System.out.println(num);
		
		
	}

	private static int getResult(String str) {
		
		if(str==null||str.length()==0)
			return 0;
		
		char[] charArray = str.toCharArray();
		int index = -1;
		ArrayList<Integer> symbol = new ArrayList<>();
		ArrayList<String> nums = new ArrayList<>();
		for(int i=0; i<charArray.length; i++){
			if(charArray[i]=='+'||charArray[i]=='-'){
				symbol.add(charArray[i]=='+' ? 1 : -1);
				nums.add(str.substring(index+1, i));
				index = i;
			}
		}
		
		nums.add(str.substring(index+1, str.length()));
		
		ArrayList<Integer> numi = new ArrayList();
		for(int i=0; i<nums.size(); i++){
			int cur = 0;
			String curstr = nums.get(i);
			if(curstr.startsWith("0x")||curstr.startsWith("0X"))
				cur = Integer.valueOf(curstr.substring(2), 16);
			else if(curstr.startsWith("0")&&curstr.length()>1){
				cur = Integer.valueOf(curstr, 8);
			}else if(!curstr.startsWith("0")){
				cur= Integer.valueOf(curstr, 10);
			}
			numi.add(cur);
		}
		
		int result = 0;
		if(nums.size()==symbol.size()){
			for(int i=0; i<symbol.size(); i++)
				result += numi.get(i)*symbol.get(i); 
		}else{
			for(int i=0; i<symbol.size(); i++)
				result += numi.get(i+1)*symbol.get(i);
			result += numi.get(0);
		}
		
		
		
		return result;
	}
}
