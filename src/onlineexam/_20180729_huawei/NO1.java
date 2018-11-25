package onlineexam._20180729_huawei;

import java.util.Scanner;

public class NO1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
		String str = sc.next();
		if(str==null||str.length()==0)
			continue;
		char[] arr = str.toCharArray();
		for(int i=0; i<arr.length; i++){
			char ch = arr[i];
			if(Character.isUpperCase(ch)||Character.isLowerCase(ch))
				arr[i] = Character.isUpperCase(arr[i]) ? Character.toLowerCase(ch) : Character.toUpperCase(ch);
		}
		String res = new String(arr);
		System.out.println(res);
		
		}
	}
	
}
