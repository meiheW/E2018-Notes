package _20180909_bytedance;

import java.util.Scanner;

/**
 * 还原出可能的原始ip，输出可能ip的数量
 * @author Administrator
 *
 */

public class IPReduction {

	public static void main(String[] args){
	    Scanner scanner = new Scanner(System.in);
	    String str = scanner.next();
	    StringBuffer sb = new StringBuffer();
	    
	    
	    int count = 0;
	    boolean isIpLegal = isIpLegal(new String(sb));
	    if(isIpLegal) {
	    	count++;
	        System.out.println(0);
	    }
	    else{
	        System.out.println(0);
	    }
	}

	public static boolean isIpLegal(String str){
	    if(str == null){
	        return false;
	    }

	    if(str.length() < 7 || str.length() > 15){
	        return false;
	    }

	    String[] arr = str.split("\\.");
	    if(arr.length != 4){
	        return false;
	    }
	    for(int i = 0; i < arr.length; i++){
	        for(int j = 0; j < arr[i].length(); j++){
	            if (arr[i].charAt(j) < '0' || arr[i].charAt(j) > '9'){
	                return false;
	            }
	        }
	    }

	    for(int i = 0; i < arr.length; i++){
	        int temp = Integer.parseInt(arr[i]);
	        if(i == 0){
	            if (temp < 1 || temp > 255){
	                return false;
	            }
	        }
	        else{
	            if(temp < 0 || temp > 255){
	                return false;
	            }
	        }
	    }

	    return true;
	}
}
