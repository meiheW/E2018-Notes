package onlineexam._20181010_pingan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


class Info implements Comparable<Info>{
	String name;
	double avarage;
	int index;
	
	Info(String name, double avarage, int index){
		this.name = name;
		this.avarage = avarage;
		this.index = index;
	}

	@Override
	public int compareTo(Info info) {
		
		if(info.avarage==this.avarage)
			return index - info.index;
		
		return (info.avarage - this.avarage)>0 ? 1 : -1;
	}
		
} 

public class NO2 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> al = new ArrayList<String>();
		String str = null;
		while(sc.hasNext()){
			al.add(sc.nextLine());
		}
		
		ArrayList<Info> infoArr = new ArrayList<Info>(); 
		for(int i=0; i<al.size(); i++){
			String[] split = al.get(i).split(" ");
			String name = split[0];
			double avarage = 0;
			for(int j=1; j<split.length; j++){
				avarage += Integer.parseInt(split[j]);
			}
			avarage /= (split.length-1);
			
			infoArr.add(new Info(name, avarage, i));
		}
		
		Collections.sort(infoArr);
		
		for(int i=0; i<infoArr.size(); i++){
			System.out.println(infoArr.get(i).name+" "+(int)Math.ceil(infoArr.get(i).avarage*1.0));
		}
		
	
		
	}
	
}
