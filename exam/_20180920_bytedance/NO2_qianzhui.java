package _20180920_bytedance;

import java.util.Scanner;

public class NO2_qianzhui {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String[] strArr = new String[num];
		for(int i=0; i<num; i++){
			String str = sc.next().trim();
			strArr[i] = str;
		}
		//printArr(strArr);
		
		String[] res = new String[num];
		for(int i=0; i<num; i++){
			String str = strArr[i];
			for(int j=1; j<=str.length(); j++){
				
				String qiaozhui = str.substring(0, j);
				boolean flag = true;
				for(int k=0; k<num; k++){
					if(k!=i){
						if(strArr[k].startsWith(qiaozhui)){
							flag = false;
							break;
						}
					}
					
					
				}
				
				if(flag==true){
					res[i] = qiaozhui;
					break;
				}
				
			}
			
			
			
		}
		
		
		for(int i=0; i<num; i++){
			System.out.println(res[i]);
		}
		
	}

	private static void printArr(String[] strArr) {
		for(int i=0; i<strArr.length; i++)
			System.out.print(strArr[i]+" ");
		
	}
	
}
