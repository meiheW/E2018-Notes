package onlineexam._20180729_huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NO3 {
	public static String[] basicType = new String[]{"char","wchar_t","char16_t","char32_t","short","int","long","long long","float","double","long double"};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String str = sc.nextLine().trim();
		//检查每个定义式是否符合基本标准
		String[] definitions = line.split(";");
		for(int i=0; i<definitions.length; i++){
			String cur = definitions[i].trim();
			//System.out.println(cur);
				System.out.println(i);	
			if(!isChecked(cur)){
				System.out.println("none");
				return;
			}
		}
		
		//将定义值与DIY存入map
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for(int i=0; i<definitions.length; i++){
			String cur = definitions[i].trim();
			String[] items = cur.split(" ");
			//下标1和2对应key和value
			String key = items[1];
			String value = items[2];
			if(map.containsKey(key))
				map.get(key).add(value);
			else{
				ArrayList<String> al = new ArrayList<String>();
				al.add(value);
				map.put(key, al);
			}
				
		}
		
		String lastDef = str;
		boolean isFound = false;
		for(String curKey : map.keySet()){
			ArrayList<String> arr = map.get(curKey);
			for(int i=0; i<arr.size(); i++){
				String curValue = arr.get(i);
				if(curValue.equals(lastDef)){
					System.out.println(curKey);
				}
					
			}
			
		}
		
		
	
	}

	//检查每一个定义式是否能够通过编译
	private static boolean isChecked(String cur) {
		String[] items = cur.split(" ");
		if(items==null||items.length!=3)
			return false;
		if(!items[0].equals("typedef"))
			return false;
		if(items[1]==null||items[1].length()==0||items[2]==null||items[2].length()==0)
			return false;
		
		//第三个字符串必须不能够包含C++基本数据类型
		int thirdIsContained=0;
		for(int i=0; i<basicType.length; i++){
			if(items[2].contains(basicType[i])){
				thirdIsContained=1;
			}
		}
		if(1==thirdIsContained)
			return false;
		
		return true;
	}
	
}
