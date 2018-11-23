import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

class Node{
	int val;
	Node next = null;
	Node(int val){
		this.val = val;
	}
}

public class Practice {

	
	
	//复制
	public static boolean duplicate1(int[] nums, int length, int[] duplication)
	{
		if(nums==null || nums.length<=0)	return false;
		for(int i=0; i<length; i++){
			while(nums[i]!=i){
				if(nums[nums[i]] == nums[i]){
					duplication[0] = nums[i];
					return true;
				}
				
				swap(nums, i, nums[i]);
			}
			
		}
		
		return false;
	}
	
	//排序矩阵查找某元素
	public static boolean Find(int target, int[][] matrix){
		if(matrix==null || matrix.length==0 || matrix[0].length==0)		return false;
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		int r = 0;
		int c = cols - 1;
		while(r<rows && c>=0){
			if(target == matrix[r][c])	
				return true;
			else if(target > matrix[r][c])	
				r++;
			else
				c--;
		}
		
		return false;
	}
	
	//替换空格
	public static String replaceSpace(StringBuffer str){
		int oldLen = str.length();
		for(int i=0; i<oldLen; i++){
			if(str.charAt(i)==' ')
				str.append("  ");
		}
		
		int newLen = str.length();
		int p1 = oldLen-1; 
		int p2 = newLen-1;
		
		
		while(p1>=0 && p2>p1){
			if(str.charAt(p1)==' '){
				str.setCharAt(p2--, '0');
				str.setCharAt(p2--, '2');
				str.setCharAt(p2--, '%');
				p1--;
			}else{
				str.setCharAt(p2--, str.charAt(p1--));
			}
			
		}
		
		return str.toString();
	}
	
	//stack
	public static ArrayList<Integer> printListReverse(Node head){
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<Integer> mstack = new Stack<Integer>();
		
		while(head!=null){
			mstack.push(head.val);
			head = head.next;
		}
		
		while(!mstack.isEmpty())
			res.add(mstack.pop());
		
		return res;
	}
	
	public static ArrayList<Integer> printListReverse1(Node head){
		ArrayList<Integer> res = new ArrayList<Integer>();
		while(head!=null){
			res.add(head.val);
			head = head.next;
		}
		
		Collections.reverse(res);
		return res;
	}
	
	//奇数前，偶数后
	public static void reOrderArray(int[] array){
		if(array==null || array.length<1)
			return;
		int ou=0;
		int ji=0;
		for(int i=0; i<array.length; i++){
			if(array[i]%2==0)	ou++;
			else				ji++;
		}
		int[] arro = new int[ou];
		int[] arrj = new int[ji];
		
		int oindex=0;
		int jindex=0;
		for(int i=0;i<array.length; i++){
			if(array[i]%2==0){
				arro[oindex]=array[i];
				oindex++;
			}else{
				arrj[jindex]=array[i];
				jindex++;
			}
			
		}
		
		for(int i=0;i<arrj.length; i++)
			array[i] = arrj[i];
		for(int i=0;i<arro.length; i++)
			array[i+arrj.length]=arro[i];
		
	}	
	
	//旋转数组的最小数字
	public static int minIntOfArray(int[] nums) throws Exception{
		if(nums==null||nums.length==0)
			return 0;
		
		int low = 0;
		int high = 0;
		while(low<high){
			int mid = low + (high-low)/2;
			if(nums[mid] < nums[high]){
				high = mid;
			}else if(nums[mid] > nums[high]) {
				low = mid+1;
			}else{
				high--;
			}
				
		}
		return low;
	}
	
	//******第一个只出现一次的字符的位置******
	/* 
	 * 每一个字符及其出现次数存入map中，遍历map，把出现一次的存进list
	 * list为空则没有，不为空遍历数组，若list包含当前字符则返回该位置。
	 */
	public int FirstNotRepeatingChar(String str) {
        char[] charArray = str.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<charArray.length; i++){
        	char key = charArray[i];
        	if(map.containsKey(key))
        		map.put(key, map.get(key)+1);
        	else
        		map.put(key, 1);
        	
        }
        
        Set<Character> keySet = map.keySet();
        ArrayList<Character> al = new ArrayList<Character>();
        for(Character c: keySet){
        	if(map.get(c)==1)
        		al.add(c);
        }
        if(al.isEmpty())	return -1;
        
        int res=0;
        for(int i=0; i<charArray.length; i++){
        	if(al.contains(charArray[i])){
        		res=i;
        		break;
        	}
        }
		
		
        return res;
    }
	
	//超过数组长度的一半的数字
	public int MoreThanHalfNum_Solution(int [] array) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		for(int i=0;i<array.length; i++){
			if(map.containsKey(array[i]))
				map.put(array[i], map.get(array[i])+1);
			else
				map.put(array[i], 1);
		}
		int res = 0;
		for(int i : map.keySet()){
			if(map.get(i)>array.length/2)
				res = i;
			
		}
		
        return res;
    }
	
	//统计一个数字在排序数组中出现的次数
	public int GetNumberOfK(int [] array , int k) {
		if(array==null || array.length==0)		return 0;
		if(array.length==1)	return array[0]==k ? 1 : 0;
		
		
		int low = 0;
		int high = array.length-1;
		int res = -1;
		int count = 0;
		while(low<high){
			int mid = low + (high-low)/2;
			if(array[mid]<k)
				low = mid+1;
			else if(array[mid]>k)
				high = mid-1;
			else{
				res = mid;
				break;
			}
		}
		if(res!=-1){
			count=1;
			int m=res;
			int n=res;
			
			while(--m!=-1 && array[m]==k)	count++;
			while(++n!=array.length && array[n]==k)	count++;
		}
		
		return count;
    }
	
	//☆☆☆判断一个数组是否是出栈序列☆☆☆
	/*
	 * 开一个栈，将入栈数组元素依次入栈，入栈后判断是否与数组当前的元素相同，相同则出战且将数组下表后移。
	 */
	public boolean IsPopOrder(int [] pushA,int [] popA) {
	    if(pushA==null||popA==null||pushA.length==0||popA.length==0||pushA.length!=popA.length)
	    	return false;
		
	    Stack<Integer> s = new Stack<Integer>();
		for(int i=0,j=0; i<pushA.length; i++){
			s.push(pushA[i]);
			while(!s.isEmpty() && s.peek()==popA[j]){
				s.pop();
				j++;
			}
			
		}
		
		return s.isEmpty();
    }
	
	//左旋转字符串
	public String LeftRotateString(String str,int n) {
        if(str==null)	return null;
        if(str.length()==0||str.length()==1)	return str;
        n=n % str.length();
        String res;
        if(n==0)
        	res = str;
        else{
	        String str1 = str.substring(0, n);
	        String str2 = str.substring(n);
	        res = str2+str1;
        }
        
        return res;
    }
	
	//找出数组中任意一个重复的数字
	/*
	 * 条件：一个长度为n的数组里的所有数字都在0到n-1的范围内
	 */
	public boolean duplicate(int numbers[],int length,int [] duplication) {
	    boolean[] mark = new boolean[length];
	    for(int i=0; i<length; i++){
	    	if(mark[numbers[i]]==true){
	    		duplication[0] = numbers[i];
	    		return true;
	    		//break;
	    	}
	    	
	    	mark[numbers[i]]=true;
	    }
	    
	    return false;
    }
	
	/**
	 * 从1到n中1出现的次数
	 * 思路：整数转为字符串，每个字符判断
	 */
    public int NumberOf1Between1AndN_Solution(int n) {
    	int count=0;
    	while(n>0){
    		String cur = String.valueOf(n);
    		char[] charArray = cur.toCharArray();
    		for(int i=0; i<charArray.length; i++){
    			if(charArray[i]=='1')
    				count++;
    		}
    		n--;
    	}
    	
    	return count;
    }
    
    /**
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     * 思路：自定义比较器
     */
    public String PrintMinNumber(int [] numbers) {
    	ArrayList<Integer> al = new ArrayList<Integer>();
    	for(int i=0; i<numbers.length; i++){
    		al.add(numbers[i]);
    	}
    	
    	Collections.sort(al, new Comparator<Integer>(){
			@Override
			public int compare(Integer n1, Integer n2) {
				String s1 = n1+""+n2;
				String s2 = n2+""+n1;
				return s1.compareTo(s2);
			}
    		
    	});
    	
    	String res="";
    	for(int i=0; i<al.size(); i++){
    		res = res+al.get(i);
    	}
    	
    	return res;
    }
    
    /**
     * 丑数-质因子2.3.5，第一个丑数为1，求第N个
     * 思路：
     */
    
    public int GetUglyNumber_Solution(int index) {
    	if(index<=0)
    		return 0;
    	
    	int i2=0;
    	int i3=0;
    	int i5=0;
    	int[] result = new int[index];
    	result[0] = 1;
    	int count = 0;
    	while(count<index-1){
    		int tmp = Math.min(result[i2]*2, Math.min(result[i3]*3, result[i5]*5));
    		if(tmp==result[i2]*2)	i2++;
    		if(tmp==result[i3]*3)	i3++;
    		if(tmp==result[i5]*5)	i5++;
    		result[++count] = tmp;
    	}
    	
        return result[index-1];
    }
    
    
    /**
     * 数组中的逆序对---我的算法超时了O(N^2)
     * 思路：
     */
    public int InversePairs_my(int [] array) {
        if(array==null || array.length<=1)
        	return 0;
        
        int count = 0;
        for(int i=0; i<array.length-1; i++){
        	int head = array[i];
        	for(int j=i+1; j<array.length; j++){
        		int cur = array[j];
        		if(head>cur){
        			count++;
        		}
        	}
        }
    	
    	return count;
    }
    
    
   /**
    * 乘积数组
    * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
    * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
    */
    
    public int[] multiply(int[] A) {
    	int[] B = null;
    	if(A==null||A.length==0)
    		return B;
    	
    	B = new int[A.length];
    	for(int i=0; i<B.length; i++){
    		int res = 1;
    		for(int j=0; j<B.length; j++){
    			if(j!=i){
    				res *= A[j];
    			}
    		}
    		B[i] = res;
    		
    	}
    	
    	return B;
    }
    
    
    /**
     * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。
     * 请写程序找出这两个只出现一次的数字。
     * 
     */
    
  //num1,num2分别为长度为1的数组。传出参数
  //将num1[0],num2[0]设置为返回结果
	public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
		if(array==null||array.length<=0)
			return;
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<array.length; i++){
			int key = array[i];
			if(map.containsKey(key)){
				map.put(key, map.get(key)+1);
			}else{
				map.put(key, 1);
			}
		}
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int key : map.keySet()){
			if(map.get(key)==1)
				al.add(key);
		}
		
		if(al.size()<2)
			return;
		num1[0] = al.get(0);
		num2[0] = al.get(1);
		
	}

	/**
	 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
	 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
	 * ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆两个指针指向收尾向中间靠拢☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆
	 */
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
    	ArrayList<Integer> al = new ArrayList<Integer>();
    	if(array==null||array.length==0)
    		return al;
    	
    	int i=0;
    	int j=array.length;
    	while(i<j){
    		if(array[i]+array[j] == sum){
    			al.add(array[i]);
    			al.add(array[j]);
    			return al;
    		}
    		while(i<j && array[i]+array[j]>sum)	j--;
    		while(i<j && array[i]+array[j]<sum) i++;
    		
    	}
    	
    	return al;
    }
	
    /**
     * 翻转这些单词顺序
     * @param args
     */
    public String ReverseSentence(String str) {
        if(str==null)	return str;
        if(str.trim().equals(""))
        	return str;
        
        
        String[] split = str.trim().split(" ");
        Stack<String> stack = new Stack<String>();
        for(int i=0; i<split.length; i++){
        	stack.push(split[i]);
        }
        
        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()){
        	sb.append(stack.pop());
        	sb.append(" ");
        }
        String result = sb.toString().substring(0, sb.toString().length()-1);
        return result;
    }
    
    /**
     * 扑克牌
     * 思路：大小王数量，不能有重复，最大与最小值间距与大小王数量比较
     * @param args
     */
    public boolean isContinuous(int [] numbers) {
        if(numbers==null||numbers.length!=5)
        	return false;
        Arrays.sort(numbers);
        
        HashSet<Integer> set = new HashSet<Integer>(); 
        int zeros = 0;
        int index = 0;
        boolean flag = false;
        for(int i=0; i<numbers.length; i++){
        	if(numbers[i]==0)
        		zeros++;
        	else{
        		if(flag==false){
        			flag=true;
        			index = i;
        		}
        		set.add(numbers[i]);
        	}
        }
        
        if(set.size()+zeros<numbers.length)
        	return false;
        
        int dis = numbers[numbers.length-1]-numbers[index];
        if(dis<5)
        	return true;
        return false;
        
        
    }
    
    /**
     * 求1+2+3+...+n，要求不能使用乘除法、
     * for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     * 思路：短路
     * @param args
     */
    public int Sum_Solution(int n) {
    	int ans=n;
    	boolean res = (ans>0) && ((ans+=Sum_Solution(n-1))>0);
    	return  ans;
    }
    
    /**
     * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
     * @param args
     */
    public int Add(int num1,int num2) {
        BigInteger bnum1 = new BigInteger(String.valueOf(num1));
        BigInteger bnum2 = new BigInteger(String.valueOf(num2));
        int res = bnum1.add(bnum2).intValue();
        return res;
    }
    
    /**
     * 输出所有和为S的连续正数序列
     * 思路：判断有N个数和为S，N为奇偶各自的条件
     * @param args
     */
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
    	ArrayList<ArrayList<Integer> > al  = new ArrayList<ArrayList<Integer> >();
    	for(int n =(int)Math.sqrt(2*sum); n>=2; n-- ){
    		if((n%2)==1&&sum%n==0 || (sum%n)*2==n){
    			ArrayList<Integer> a = new ArrayList<Integer>();
    			for (int j = 0, k = (sum / n) - (n - 1) / 2; j < n; j++, k++) {
                    a.add(k);
                }
    			al.add(a);
    		}
    		
    		
    	}
    	return al;
	
    }
    
    
    /**
     * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
     * @param str
     * @param pattern
     * @return
     */
    
    public boolean match(char[] str, char[] pattern) {
	    if (str == null || pattern == null) {
	        return false;
	    }
	    int strIndex = 0;
	    int patternIndex = 0;
	    return matchCore(str, strIndex, pattern, patternIndex);
    } 
    
    public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //有效性检验：str到尾，pattern到尾，匹配成功
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        //pattern先到尾，匹配失败
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return matchCore(str, strIndex, pattern, patternIndex + 2)//模式后移2，视为x*匹配0个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)//视为模式匹配1个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex);//*匹配1个，再匹配str中的下一个
            } else {
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }
    
    
    /**
     * 将一个字符串转换成一个整数
     * @param args
     */
    public int StrToInt(String str) {
        if(str==null||str.equals(""))
        	return 0;
        char[] arr = str.toCharArray();
        int fuhao = 0;
        if(arr[0]=='-')
        	fuhao = 1;
        int sum = 0;
        for(int i=fuhao; i<str.length(); i++){
        	if(arr[i]=='+')
        		continue;
        	if(arr[i]<'0'||arr[i]>'9')
        		return 0;
        	
        	sum = sum*10+arr[i]-'0';
        }
        return fuhao==0 ? sum : 0-sum;
        
        
    }
    
    
    /**
     * 请实现一个函数用来判断字符串是否表示数值
     * @param args
     */
    public boolean isNumeric(char[] str) {
    	//String string = String.valueOf(str);
        //return string.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
        
    	// 标记符号、小数点、e是否出现过
        boolean sign = false, decimal = false, hasE = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'e' || str[i] == 'E') {
                if (i == str.length-1) return false; // e后面一定要接数字
                if (hasE) return false;  // 不能同时存在两个e
                hasE = true;
            } else if (str[i] == '+' || str[i] == '-') {
                // 第二次出现+-符号，则必须紧接在e之后
                if (sign && str[i-1] != 'e' && str[i-1] != 'E') return false;
                // 第一次出现+-符号，且不是在字符串开头，则也必须紧接在e之后
                if (!sign && i > 0 && str[i-1] != 'e' && str[i-1] != 'E') return false;
                sign = true;
            } else if (str[i] == '.') {
              // e后面不能接小数点，小数点不能出现两次
                if (hasE || decimal) return false;
                decimal = true;
            } else if (str[i] < '0' || str[i] > '9') // 不合法字符
                return false;
        }
        return true;
    }
    
    /**
     * 孩子们的游戏：约瑟夫环
     * @param args
     */
    public int LastRemaining_Solution(int n, int m) {
        if(n==0||m==0)return -1;
        int s=0;
        for(int i=2;i<=n;i++)
        {
            s=(s+m)%i;
        }   
       return s ;
    	
    	
    }
    
    /**
     * 一个数据流中的中位数
     * @param args
     */
    
    ArrayList<Integer> al = new ArrayList<Integer>();
    public void Insert(Integer num) {
    	al.add(num);
    }

    public Double GetMedian() {
        Collections.sort(al);
        if(1 == al.size()%2)
        	return al.get(al.size()/2)+.0;
        else
        	return (al.get(al.size()/2-1) + al.get(al.size()/2+1)) / 2.0; 
    }
    
    
    /**
     * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
     * @param args
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
    	ArrayList<Integer> al = new ArrayList<Integer>();
    	if(num==null||num.length<=0||size<=0||num.length<size)
    		return al;
        int numLen = num.length;
        
    	for(int i=0; i<num.length-size+1; i++){
    		int max = num[i];
    		for(int j=i; j<i+size; j++){
    			if(num[j]>max)
    				max = num[j];
    		}
    		al.add(max);
    	}
    	
    	return al;
    }
    
    /**
     * 判断在一个矩阵中是否存在一条包含某字符串所有字符的路径
     * ☆☆☆☆☆☆思路：回溯法☆☆☆☆☆☆
     * @param args
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
    	int[] flag = new int[matrix.length];
    	for(int i=0; i<rows; i++){
    		for(int j=0; j<cols; j++){
    			if(hasPathCore(matrix, rows, cols, i, j, str, 0, flag))
    				return true;
    		}
    	}
    	return false;
    }
    
	private boolean hasPathCore(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, int[] flag) {
		int index = i*cols + j;
		if(matrix==null||matrix.length==0||i<0||i>=rows||j<0||j>=cols||matrix[index]!=str[k]||flag[index]==1)
			return false; 
		if(k==str.length-1)
			return true;
		
		flag[index] = 1;
		if(hasPathCore(matrix, rows, cols, i+1, j, str, k+1, flag)
				||hasPathCore(matrix, rows, cols, i-1, j, str, k+1, flag)
				||hasPathCore(matrix, rows, cols, i, j+1, str, k+1, flag)
				||hasPathCore(matrix, rows, cols, i, j-1, str, k+1, flag))
			return true;
		flag[index] = 0;
		
		return false;
	}
	
	/**
	 * 机器人运动范围
	 * 思路：回溯法
	 * @param args
	 */
    public int movingCount(int threshold, int rows, int cols)
    {
    	boolean[][] visited = new boolean[rows][cols];
    	int res = movingCountCore(threshold, rows, cols, 0, 0 ,visited);
    	return res;
    }
	

	private int movingCountCore(int threshold, int rows, int cols, int i, int j, boolean[][] visited) {
		if(i<0||i>=rows||j<0||j>=cols||visited[i][j]==true||cal(i)+cal(j)>threshold)
			return 0;
		visited[i][j] = true;
		
		return movingCountCore(threshold, rows, cols, i+1, j ,visited)
		+movingCountCore(threshold, rows, cols, i-1, j ,visited)
		+movingCountCore(threshold, rows, cols, i, j-1 ,visited)
		+movingCountCore(threshold, rows, cols, i, j+1 ,visited)+1;
		
	}

	private int cal(int i) {
		int res=0;
		while(i>0){
			int rest = i%10;
			i/=10;
			res+=rest;
		}
		return res;
	}

	
	//输入一个字符串,按字典序打印出该字符串中字符的所有排列。
	//例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba
    public ArrayList<String> Permutation(String str) {
        return null;
    }
	
	
	public static void main(String[] args) {
		Practice p = new Practice();
		int[] arr = {1,2,3,2,2,2,5,4,2};
		int res = p.MoreThanHalfNum_Solution(arr);
		System.out.println(res);
		
		int resIndex = p.FirstNotRepeatingChar("google");
		System.out.println(resIndex);
		
		System.out.println(p.LeftRotateString("abcXYZdef",3));
		
		p.LastRemaining_Solution(8,2);
		
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i]  = nums[j];
		nums[j]  = temp;
	}

	private static void printarr(ArrayList<Integer> marr){
		for(int i : marr)
			System.out.print(i+" ");
	}
	
	private static void printarray(int[] num){
		for(int i=0;i<num.length;i++)
			System.out.print(num[i]+" ");
	}
	
	
	
	
}
