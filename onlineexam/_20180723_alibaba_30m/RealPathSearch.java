package onlineexam._20180723_alibaba_30m;

import java.util.ArrayList;
import java.util.Scanner;



class PathSearch1 {
	
	
	public ArrayList<String> Permutation(String str){

		ArrayList<String> strArr = new ArrayList<String>();
		getPermutation(strArr, str.toCharArray(), 0);
		//process
		
		return strArr;
		
	}

	private void getPermutation(ArrayList<String> strArr, char[] str, int k) {
		if(k==str.length){
			strArr.add(new String(str));
			return;
		}
		for(int i=k; i<str.length; i++){
			swap(str,i,k);
			getPermutation(strArr, str, k+1);
			swap(str,i,k);
		}
		
	}

	private void swap(char[] str, int i, int k) {
		if(i!=k){
			char temp = str[i];
			str[i] = str[k];
			str[k] = temp;
		}
	}
	
	public int getMinPathLength(ArrayList<String> arr, ArrayList<Point> pointArr){
		int minlength=0;
		
		for(int i=0; i<arr.size(); i++){
			
			minlength=Integer.MAX_VALUE;
			String pathSeq = arr.get(i);
			System.out.println(pathSeq);
			char[] pathSeqChar = pathSeq.toCharArray();
			int length=0;
			
			for(int j=0;j<pathSeq.length()-1; j++){
				if(0==j)
					length+=pointArr.get(pathSeqChar[j]-'0').getDistance(new Point(0,0));
				length += pointArr.get(pathSeqChar[j]-'0').getDistance(pointArr.get(pathSeqChar[j+1]-'0'));
			}
			
			if(length<minlength)
				minlength = length;
		}
		
		return minlength;
	}
	
	
	
}



public class RealPathSearch {

	public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine().trim());
        int k =num;
        int index = 0;
        String[] locations = new String[num];
      
        while(num-- > 0){
            locations[index++] = scanner.nextLine();
            System.out.println("hh");
        }
        
        
		ArrayList<Point> pointArr = new ArrayList();
        for(int i=0; i<locations.length; i++){
        	String[] split = locations[i].split(",");
        	int x = Integer.parseInt(split[0]);
        	int y = Integer.parseInt(split[1]);
        	pointArr.add(new Point(x,y));
        
        }
        PathSearch ps = new PathSearch();
        
        String s = new String();
        for(int i=0;i<k;i++)
        {
        	s+=i;
        }
        
        ArrayList<String> permutation = ps.Permutation(s);
		
		
	
		int res = ps.getMinPathLength(permutation, pointArr);
		
		System.out.println(res);
        
   
    }
	
}
