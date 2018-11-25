package online_exam._20181013_eleme;

import java.util.HashSet;
import java.util.Set;

public class FindSumN {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int n = 8;
		findSumN(arr, n);
		
		
	}

	private static void findSumN(int[] arr, int n) {
		Set<Integer> mset = new HashSet<Integer>();
		for(int i=0; i<arr.length; i++){
			mset.add(arr[i]);
		}
		
		for(int i=0; i<arr.length; i++){
			if(mset.contains(n-arr[i])){
				System.out.println(arr[i]+" "+ (n-arr[i]));
				//break;
			}
			
		}
		
		
		
	}
	
	
	
}
