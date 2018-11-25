package codingguide.string;

import java.util.*;

public class StringUtils {

	public static boolean isDeformation(String str1, String str2)
	{
		if(str1==null||str2==null||str1.length()!=str2.length())
			return false;
		
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		
		int[] mymap = new int[256];
		for(int i=0; i<chs1.length; i++)
		{
			mymap[chs1[i]]++;
		}
		for(int i=0; i<chs2.length; i++)
		{
			if(mymap[chs2[i]--]==0)
				return false;
		}
		return true;
	}
	
	public static int numSum(String str)
	{
		if(str==null||str.length()==0)
			return 0;
		
		char chs[] = str.toCharArray();
		int res = 0;
		int num = 0;
		int cur = 0;
		boolean flag = true;
		for(int i=0; i<str.length(); i++)
		{
			cur = chs[i]-'0';
			if(cur>=0 && cur<=9){
				num = 10 * num + (flag ? cur : -cur);  
			}else {
				res+=num;
				num=0;
				if(chs[i]=='-') {
					if(chs[i-1]=='-'&&i-1>-1)
					{
						flag=!flag;
					}
					else {
						flag = true;
					}	
				}else {
					flag = true;
				}
			}
		}
		res += num;
		return res;
	}
	
	public static String removeKZeroes(String str, int K)
	{
		if(str==null||K<1)
			return str;
		
		char[] chs = str.toCharArray();
		int count = 0;
		int start = -1;
		String newstr = "";
		for(int i=0; i<str.length(); i++)
		{
			if(chs[i]=='0') {
				count++;
				start = start==-1 ? i : start;
			}else
			{
				if(start!=-1 && count!=K)
					newstr += String.valueOf(chs, start, count);
				newstr += String.valueOf(chs[i]);
				
				count=0;
				start=-1;
			}	
		}
		if(start!=-1 && count!=K)
		{
			newstr += String.valueOf(chs, start, count);
		}
		return newstr;
		
	}
	
	public static boolean isRotation(String str1, String str2)
	{
		if(str1==null||str2==null||str1.length()!=str2.length())
			return false;
		String str = str1+str1;
		int index = str.indexOf(str2);
		if(index==-1)
			return false;
		return true;
	}
	
	public static int convert(String str)
	{
		if(str==null||str.equals(""))
			return 0;
		
		char[] chr = str.toCharArray();
		boolean posi = chr[0]=='-' ? false : true;
		int minq = Integer.MIN_VALUE/10;
		int minr = Integer.MAX_VALUE/10;
		int res = 0;
		int cur = 0;
		for(int i=posi?0:1; i<chr.length; i++)
		{
			cur = '0' - chr[i];
			if((res<minq)||(res==minq&&cur<minr))
				return 0;
			
			res = res*10 + cur;
		}
		
		if(posi&&res==Integer.MIN_VALUE)
			return 0;
		
		return posi ? -res : res;
	}
	
	public static boolean isUnique(char[] chas)
	{
		HashSet<Character> mset = new HashSet<Character>();
		for(int i=0; i<chas.length; i++)
		{
			if(mset.contains(chas[i]))
				return false;
			else
				mset.add(chas[i]);
		}
		
		return true;		
	}
	
	public static boolean isValidChs(char[] chs)
	{
		if(chs[0]=='0' && chs.length>1)
			return false;
		if(chs[0]=='-' && (chs[1]=='0'||chs.length==1))
			return false;
		if(chs[0]=='-' && (chs[0]<'0'||chs[0]>'9'))
			return false;
		for(int i=1;i<chs.length; i++)
			if(chs[i]<'0'||chs[i]>'9')
				return false;
		
		return true;
	}
	
	public static void main1(String[] args) {
		String str1 = "1323";
		String str2 = "3213";
		boolean dres = isDeformation(str1, str2);
		System.out.println(dres);

		int numres = numSum("A1CD2E33");
		System.out.println(numres);
		
		String removeres = removeKZeroes("0000u000Aggg0000B000C000", 3);
		System.out.println(removeres);
		
		boolean irres = isRotation("2ab1","ab12");
		System.out.println(irres);
		
		int conres = convert("1234");
		System.out.println(conres);
		
		System.out.println("....");
		
		char[] mchuni = "maokfd".toCharArray();
		boolean unires = isUnique(mchuni);
		System.out.println(unires);
		
 	
	}

}
