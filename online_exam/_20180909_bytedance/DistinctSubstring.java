package online_exam._20180909_bytedance;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * 给定一个字符串，找出其中无重复字符的最长子字符串的长度。
 * @author Administrator
 *
 */
public class DistinctSubstring {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		String A = sc.next(); 
		
	Map<Character, Integer> charPosition = new HashMap<Character, Integer>();
	        int[] preArr = new int[A.length()];
	        char[] str2charArr = A.toCharArray();
	        for(int i=0; i<A.length(); i++){
	            Integer lastPosOfChar = charPosition.get(str2charArr[i]);
	            if(lastPosOfChar == null){
	                preArr[i] = i == 0 ? 1 : preArr[i-1] + 1;
	                charPosition.put(str2charArr[i], i);
	            }
	            else{
	                int aPos = lastPosOfChar + 1;
	                int unRepeatLen = preArr[i-1];
	                int bPos = i - unRepeatLen;
	                if(aPos >= bPos){
	                    preArr[i] = i - aPos + 1;
	                }
	                else{
	                    preArr[i] = i - bPos + 1;
	                }
	                //update
	                charPosition.put(str2charArr[i], i);
	            }
	        }
	        //get_max
	        int max = preArr[0];
	        for(int i: preArr) if(i > max) max = i;
	        System.out.println(max);
	}
	
}
