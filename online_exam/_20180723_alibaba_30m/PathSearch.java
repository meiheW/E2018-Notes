package online_exam._20180723_alibaba_30m;

import java.util.ArrayList;
import java.util.HashSet;

class Point{
	int x;
	int y;
	Point(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	public int getDistance(Point p){
		return Math.abs(this.x-p.x)+Math.abs(this.y-p.y);
	}
}

public class PathSearch {
	
	
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
	
	
	
	
	public static void main(String[] args) {
		PathSearch ps = new PathSearch();
		
		String pointSeq=null;
		
		ArrayList<String> permutation = ps.Permutation("012");
		ArrayList<Point> pointArr = new ArrayList();
		pointArr.add(new Point(1,2));
		pointArr.add(new Point(2,2));
		pointArr.add(new Point(1,3));
		
		int res = ps.getMinPathLength(permutation, pointArr);
		
		System.out.println(res);
	}
	
	
	
	
}
