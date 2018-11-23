package ArrayAndMatrix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class ArrayTest {
	
	//找到无序数组中最小的K个数
	public int[] findMinK(int[] arr, int k){
		if(arr==null ||k<=0 || k>arr.length)
			return null;
		Arrays.sort(arr);
		int[] newArr  =new int[k];
		for(int i=0; i<k; i++)
			newArr[i] = arr[i];
		
		return newArr;
	}
	

	
	//打印数组中出现次数大于一半的数
	public void printXH(int[] arr){
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for(int i=0; i<arr.length; i++){
			if(m.containsKey(arr[i]))
				m.put(arr[i], m.get(arr[i])+1);
			else
				m.put(arr[i], 1);
		}
		
		Set<Integer> keySet = m.keySet();
		boolean found = false;
		for (Integer key : keySet) {
			if(m.get(key)>arr.length/2){
				System.out.println(key);
				found = true;
				break;
			}
		}
		
		if(found == false)
			System.out.println("Not Found");
		
	}
	
	
	
	public void printArr(int[] arr){
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	
	@Test
	public void demo(){
		int[] arr = new int[]{2,3,1,5,4,9,0};
		int[] res = findMinK(arr, 3);
		printArr(res);
		
		int[] arr2 = new int[]{1,1,2,2,2,2,2,2,3,3,3};
		printXH(arr2);
	}
	
	
}
