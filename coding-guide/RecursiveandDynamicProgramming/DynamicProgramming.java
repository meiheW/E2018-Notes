package RecursiveandDynamicProgramming;

import java.util.*;


public class DynamicProgramming {
	//4.1.1쳲���������(�����ݹ�:ʱ�临�Ӷ�O(2^N))
	public static int Fibonacci1(int n)
	{
		if(n<1)
			return 0;
		if(n==1||n==2)
			return 1;
		
		return Fibonacci1(n-1)+Fibonacci1(n-2);
	}
	//4.1.2쳲���������(���������μ���ÿ��ֵ:ʱ�临�Ӷ�O(2^N))
	public static int Fibonacci2(int n)
	{
		if(n<1)
			return 0;
		if(n==1 || n==2)
			return 1;
		
		int a = 1;
		int b = 1;
		int c = 0;
		for(int i=3; i<=n; i++)
		{
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}
	//4.1.3쳲���������(���þ���N�η���O(logN))
	public static int Fibonacci3(int n)
	{
		if(n<1)
			return 0;
		if(n==1 || n==2)
			return 1;
		
		int[][] base = {{1,1},{1,0}};
		int[][] res  = matrixPower(base, n-2);
		
		return res[0][0]+res[1][0];
	}
	
	public static int[][] matrixPower(int[][] m, int p)
	{
		int[][] res = new int[m.length][m[0].length];
		for(int i=0; i<res.length; i++)
			res[i][i] = 1;
		
		int[][]tmp = m;
		for(; p!=0; p >>= 1)
		{
			if((p&1)!=0)
				res = muliMatrix(res, tmp);
			tmp = muliMatrix(tmp, tmp);
		}
		return res;
	}
	
	public static int[][] muliMatrix(int[][] m1,int[][] m2)
	{
		int[][] res = new int[m1.length][m2[0].length];
		for(int i=0; i<m1.length; i++)
		{
			for(int j=0; j<m2[0].length; j++)
			{
				for(int k = 0; k<m2.length; k++)
					res[i][j] += m1[i][k] * m2[k][j];
			}
		}
		return res;
	}
	
	
	//4.1.4̨������
	public static int step1(int n)
	{
		if(n<1)
			return 0;
		if(n==1 || n==2)
			return n;
		
		return step1(n-1)+step1(n-2);
	}
		
	public static int step2(int n)
	{
		if(n<1)
			return 0;
		if(n==1 || n==2)
			return n;
		
		int a = 1;
		int b = 2;
		int c = 0;
		
		for(int i=3; i<=n; i++)
		{
			c = a+b; 
			a = b;
			b = c;
		}
		return c;
			
	}
	
	//4.1.5ţ��������
	public static int cow1(int n)
	{
		if(n<1)
			return 0;
		if(n==1||n==2||n==3)
			return n;
		
		return cow1(n-1)+cow1(n-3);
	}
	
	public static int cow2(int n)
	{
		if(n<1)
			return 0;
		if(n==1||n==2||n==3)
			return n;
		int res = 3;
		int pre = 2;
		int prepre = 1;
		int tmp = 0;
		
		for(int i=4; i<=n; i++)
		{
			tmp = res;
			res += prepre;
			prepre = pre;
			pre = res;
		}
		return res;
		
	}
	
	//4.2������С·����  
	//dp[i][j]��ʾ�����Ͻǵ������m[i][j]������С·����
	public static int minPathSum(int[][] m)
	{
		if(m==null||m.length==0||m[0]==null||m[0].length==0)
			return 0;
		int row = m.length;
		int col = m[0].length;
		
		int[][] dp = new int[row][col];
		dp[0][0] = m[0][0];
		for(int i=1; i<row; i++){
			dp[0][i] = dp[0][i-1] + m[0][i];
		}
		for(int i=1; i<col; i++){
			dp[i][0] = dp[i-1][0] + m[i][0];
		}
		
		for(int i=1; i<row; i++){
			for(int j=1; j<col; j++){
				dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + m[i][j];
			}	
		}
		return dp[row-1][col-1];
	}
	
	
	//4.3��Ǯ����С������
	//dp[i][j]��ʾʹ��arr[0...i]���ҵ���������j��Ҫ����С����
	public static int minCoin(int[] arr, int aim)
	{
		if(arr==null || arr.length==0 || aim<0)
			return -1;
		
		int n = arr.length;
		int max = Integer.MAX_VALUE;
		
		int[][] dp = new int[n][aim+1];
		for(int j=1; j<=aim; j++){
			dp[0][j] = max;
			if(j>=arr[0] &&  dp[0][j-arr[0]]!=max)
				dp[0][j] = dp[0][j-arr[0]]+1;
		}
		
		int left = 0;
		for(int i=1; i<n; i++){
			for(int j=1; j<=aim; j++){
				left = max;
				if(j>=arr[i] && dp[i][j-arr[i]]!=max)
					left = dp[i][j-arr[i]]+1;
				
				dp[i][j] = Math.min(left, dp[i-1][j]);
			}
		}
		
		return dp[n-1][aim]!=max ? dp[n-1][aim] : -1; 
		
	}
	
	
	//4.4��Ǯ�ķ�����
	//1�����ݹ�(O(aim^n))
	public static int coins1(int[] arr, int aim)
	{
		if(arr==null||arr.length==0||aim<0)
			return 0;
		return process1(arr, 0, aim);
	}	
	
	public static int process1(int[] arr, int index, int aim)
	{
		int res = 0;
		
		if(index==arr.length)
			res = aim==0 ? 1 : 0;
		else {
			for(int i=0; arr[index]*i<=aim; i++)
			{
				res += process1(arr,index+1, aim-arr[index]*i);
			}
		}
		
		return res;
	}
	
	//2��������
	public static int coins2(int[] arr, int aim)
	{
		if(arr==null||arr.length==0||aim<0)
			return 0;
		int[][] map = new int[arr.length+1][aim+1];
		return process2(arr, 0, aim, map);
	}
		
	public static int process2(int[] arr, int index, int aim, int[][] map)
	{
		int res = 0;
		
		if(index==arr.length)
			res = aim==0 ? 1 : 0;
		else {
			int mapValue = 0;
			for(int i=0; arr[index]*i<=aim; i++)
			{
				mapValue = map[index+1][aim-arr[index]*i];
				if(mapValue != 0)
					res += mapValue==-1 ? 0 : mapValue;
				else	
					res += process2(arr,index+1, aim-arr[index]*i, map);
			}
		}
		map[index][aim] = res==0 ? -1 : res;
		return res;
	}
	
	
	//3 ��̬�滮
	//dp[i][j]��ʾʹ��arr[0...i]���ҵ���������j�ķ�����
	public static int coins3(int[] arr, int aim)
	{
		if(arr==null || arr.length==0 || aim<0)
			return 0;
		
		int n = arr.length;
		int[][] dp = new int[n][aim+1];
		for(int i=0; i<n; i++)
			dp[i][0] = 1;
		for(int j=0; j*arr[0]<=aim; j++)
			dp[0][j*arr[0]] = 1;
		
		int num = 0;
		for(int i=1; i<n; i++)
		{
			for(int j=1; j<=aim; j++)
			{
				 num = 0;
				 for(int k=0; j-k*arr[i]>=0; k++)
					 num += dp[i-1][j-k*arr[i]];
				 
				 dp[i][j] = num;
			}
		}
		return dp[n-1][aim];
	}
	//4 ��̬�滮
	public static int coins4(int[] arr, int aim)
	{
		if(arr==null || arr.length==0 || aim<0)
			return 0;
		
		int n = arr.length;
		int[][] dp = new int[n][aim+1];
		for(int i=0; i<n; i++)
			dp[i][0] = 1;
		for(int j=0; j*arr[0]<=aim; j++)
			dp[0][j*arr[0]] = 1;
		
		for(int i=1; i<n; i++)
		{
			for(int j=1; j<=aim; j++)
			{
				//���ݺ���
				 dp[i][j] = dp[i-1][j];
				 dp[i][j] += j-arr[i]>=0 ? dp[i][j-arr[i]] : 0; 
			}
		}
		return dp[n-1][aim];
	}
	
	//4.5�����������
	public static int[] LIS(int[] arr)
	{
		if(arr==null||arr.length==0)
			return null;
		int[] dp = getdp(arr);
		return generateLIS(arr, dp);
		
	}
	//dp[i]��ʾ��arr[i]Ϊ��β������µ�������еĳ���
	public static int[] getdp(int[] arr)
	{
		int[] dp = new int[arr.length];
		for(int i=0; i<arr.length; i++)
		{
			dp[i] = 1;
			for(int j=0; j<i; j++)
			{
				if(arr[j]<arr[i])
					dp[i] = Math.max(dp[i], dp[j]+1);
			}
		}
		return dp;
	}
	
	public static int[] generateLIS(int[] arr, int[] dp)
	{
		int len = 0;
		int index = 0;//��ȡ����������еĳ��ȼ���ĩԪ���±�
		for(int i=0; i<dp.length; i++){
			if(dp[i]>len){
				len = dp[i];
				index = i;
			}
		}
		int[] lis = new int[len];
		lis[--len] = arr[index];
		//�������������iΪindexǰ��һ��
		for(int i=index; i>=0; i--){
			if(arr[i]<arr[index] && dp[i]==dp[index]-1){
				lis[--len]=arr[i];
				index = i;
			}
		}
		return lis;
	}
	
	//4.6��ŵ������
		public static void hanoi(int n)
		{
			if(n>0)
				func(n, "left", "mid", "right");
		}
			
		public static void func (int n, String from, String mid, String to)
		{
			if(n==1)
				System.out.println("movev from "+from+" to "+to);
			else {
				func(n-1, from, to, mid);
				func(1,   from, mid, to);
				func(n-1, mid, from, to);
			}
		}
	
	//4.7����������� 
	//dp[i][j]�ĺ�����st1[0..i]��str2[0..j]������������еĳ���
	public static int[][] getdplcse(char[] str1, char[] str2)
	{
		int[][] dp = new int[str1.length][str2.length];
		dp[0][0] = str1[0]==str2[0] ? 1 : 0;		
		for(int i=1; i<str1.length; i++)
			dp[i][0] = Math.max(dp[i-1][0], str1[i]==str2[0] ? 1 : 0);
		for(int j=1; j<str2.length; j++)
			dp[0][j] = Math.max(dp[0][j-1], str2[j]==str1[0] ? 1 : 0);
		
		for(int i=1; i<str1.length; i++){
			for(int j=1; j<str2.length; j++){
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				if(str1[i]==str2[j])
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+1);
			}
		}
		return dp;
	}
	//ͨ��dp�������������еĹ��̾��ǻ�ԭ����ʱ������dp�Ĺ���(ע�⣺����������в�Ψһ)
	
	public static String lcse(String str1, String str2)
	{
		if(str1==null||str2==null||str1.equals("")||str2.equals(""))
			return "";
		
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		int[][] dp = getdplcse(chs1, chs2);
		int m = str1.length()-1;
		int n = str2.length()-1;
		char[] res = new char[dp[m][n]];
		int index = dp[m][n]-1;
		while(index>=0)
		{
			if(n>0 && dp[m][n]==dp[m][n-1])
				n--;
			else if(m>0 && dp[m][n] == dp[m-1][n])
					m--;
			else {
				res[index--] = chs1[m];
				m--;
				n--;
			}
		}
		return String.valueOf(res);
	}
	
	//4.8������Ӵ�
	//dp[i][j]ָ��str1[i]��str2[j]Ϊĩβ�Ĺ����Ӵ����ܴﵽ����󳤶�
	public static int[][] getdplcst(char[] str1, char[] str2)
	{
		int[][] dp = new int[str1.length][str2.length];
		dp[0][0] = str1[0]==str2[0] ? 1 : 0;
		for(int i=1; i<str1.length; i++)
			if(str1[i]==str2[0]) dp[i][0] = 1;
		for(int j=1; j<str2.length; j++)
			if(str1[0]==str2[j]) dp[0][j] = 1;
		
		for(int i=1; i<str1.length; i++){
			for(int j=1; j<str2.length; j++){
				if(str1[i]==str2[j])
					dp[i][j] = dp[i-1][j-1]+1;//��i,j��β��
			}
		}
		return dp;
	}
	
	public static String lcst(String str1, String str2)
	{
		if(str1==null||str2==null||str1.equals("")||str2.equals(""))
			return "";
		
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		int[][] dp = getdplcst(chs1, chs2);
		
		int end = 0;
		int max = 0;
		for(int i=0; i<str1.length(); i++){
			for(int j=0; j<str2.length(); j++){
				if(dp[i][j]>max){
					max = dp[i][j];
					end = i;
				}
			}
		}
		
		return str1.substring(end-max+1,end+1);
	}

	
	//4.9��С�༭����
	//dp[i][j]��ʾstr1[0..i-1]�任��str2[0..j-1]����С�༭����
	public static int minCost(String str1, String str2, int ic, int dc, int rc)
	{
		if(str1==null||str2==null)
			return 0;
		
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		int row = chs1.length + 1;
		int col = chs2.length + 1;
		int[][] dp = new int[row][col];
		for(int i=0; i<row; i++)
			dp[i][0] = dc * i;
		for(int j=0; j<col; j++)
			dp[0][j] = ic * j;
		
		for(int i=1; i<row; i++){
			for(int j=1; j<col; j++){
				if(chs1[i-1] == chs2[j-1]) {
					dp[i][j] = dp[i-1][j-1];
				}else {
					dp[i][j] = dp[i-1][j-1] + rc;
				}
				dp[i][j] = Math.min(dp[i][j], dp[i][j-1]+ic);
				dp[i][j] = Math.min(dp[i][j], dc+dp[i-1][j]);
			}
		}
		
		return dp[row-1][col-1];
	}
	
	//4.10�ַ����Ľ������
	public static boolean isCross(String str1, String str2, String aim)
	{
		if(str1==null||str2==null||aim==null)
			return false;
		
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		char[] chaim = aim.toCharArray();
		if(chs1.length+chs2.length != chaim.length)
			return false;
		int row = chs1.length;
		int col = chs2.length;
		//dp[i][j]��ʾaim[i+j-1]�Ƿ�Ϊstr1[0..i-1]��str2[0..j-1]�������
		boolean[][] dp = new boolean[row+1][col+1];
		dp[0][0] = true;
		for(int i=1; i<=row; i++)
		{
			if(chs1[i-1]!=chaim[i-1])
				break;
			dp[i][0] = true;
		}
		for(int j=1; j<=col; j++)
		{
			if(chs2[j-1]!=chaim[j-1])
				break;
			dp[0][j] = true;
		}
		
		for(int i=1; i<row; i++){
			for(int j=1; j<col; j++){
				if(dp[i-1][j]==true && chs1[i-1]==chaim[i+j-1])
					dp[i][j] = true;
				if(dp[i][j-1]==true && chs2[j-1]==chaim[i+j-1])
					dp[i][j] = true;
			}
		}
		
		return dp[row-1][col-1];
	}
	
	//4.11������³�
	public static int dragonGame(int[][] m)
	{
		 if(m==null||m.length==0||m[0]==null||m[0].length==0)
			 return 1;
		 int row = m.length;
		 int col = m[0].length;
		 int[][] dp = new int[row][col];
		 //dp[i][j]��ʾ����m[i][j]ʱ, ��Ҫ���е�Ѫ��,���ս��Ϊdp[0][0].
		 dp[row-1][col-1] = (m[row-1][col-1]>=0 ? 1 : 1-m[row-1][col-1]);
		 
		 for(int i=row-2; i>=0; i--){
			 dp[i][col-1] = Math.max(dp[i+1][col-1]-m[i][col-1], 1);
		 }
		 for(int j=col-2; j>=0; j--){
			 dp[row-1][j] = Math.max(dp[row-1][j+1]-m[row-1][j], 1);
		 }
		 
		 for(int i=row-2; i>=0; i--)
		 {
			 for(int j=col-2; j>=0; j--)
			 {
				 int right = Math.max(dp[i][j+1]-m[i][j], 1);
				 int down  = Math.max(dp[i+1][j]-m[i][j], 1);
				 dp[i][j]  = Math.min(right, down);
			 }
		 }
		 
		 return dp[0][0];	 
	}
	
	
	//4.12�����ַ���ת��Ϊ��ĸ��ϵ�����(�����ݹ�)
	public static int alphaNum(String str)
	{
		if(str==null||str.equals(""))
			return 0;
		char chs[] = str.toCharArray();
		int cur = chs[chs.length-1]=='0' ? 0 : 1;
		int next = 1;
		int tmp = 0;
		
		for(int i=chs.length-2; i>=0; i--)
		{
			if(chs[i]=='0')//1:chs[i]Ϊ0 
			{
				next = cur;
				cur=0;
			}else {
				tmp = cur;
				//chs[i]��chs[i+1]�ܽ��
				if((chs[i]-'0')*10+chs[i+1]-'0'<27)
					cur += next;
				next = tmp;
			}
		}
		
		return cur;
	}
	
	//4.13���ʽ�õ�����������������(�����ݹ�)
	public static int desireTrue(String express, boolean desired)
	{
		if(express==null||express=="")
			return 0;
		char[] exp = express.toCharArray();
		if(!isValid(exp))
			return 0;
		
		return p(exp,desired,0,exp.length-1);
	}
	public static int p(char[] exp, boolean desired, int l, int r)
	{
		if(l==r) {
			if(exp[l]=='1')
				return desired ? 1 : 0;
			else
				return desired ? 0 : 1;
		}
		int res = 0;
		if(desired) {
			for(int i=l+1; i<r; i+=2) {
				switch(exp[i]) {
				case '&':
					res += p(exp, true, l, i-1)*p(exp, true, i+1, r);
					break;
				case '|':
					res += p(exp, true, l, i-1)*p(exp, true, i+1, r);
					res += p(exp, true, l, i-1)*p(exp, false, i+1, r);
					res += p(exp, false, l, i-1)*p(exp, true, i+1, r);
					break;
				case '^':
					res += p(exp, false, l, i-1)*p(exp, true, i+1, r);
					res += p(exp, true, l, i-1)*p(exp, false, i+1, r);
					break;
				}
			}
		}else {
			for(int i=l+1; i<r; i+=2) {
				switch(exp[i]) {
				case '&':
					res += p(exp, true, l, i-1)*p(exp, false, i+1, r);
					res += p(exp, false, l, i-1)*p(exp, false, i+1, r);
					res += p(exp, false, l, i-1)*p(exp, false, i+1, r);
					break;
				case '|':
					res += p(exp, false, l, i-1)*p(exp, false, i+1, r);
					break;
				case '^':
					res += p(exp, true, l, i-1)*p(exp, true, i+1, r);
					res += p(exp, false, l, i-1)*p(exp, false, i+1, r);
					break;
				}
			}	
		}
		return res;
	}
	public static boolean isValid(char[] exp)
	{
		if(exp.length%2==0)
			return false;
		for(int i=0; i<exp.length; i+=2){
			if(exp[i]!='0'&&exp[i]!='1')
				return false;
		}	
		for(int i=1; i<exp.length; i+=2){
			if(exp[i]!='|'&&exp[i]!='^'&&exp[i]!='&')	
				return false;
		}
		
		return true;
	}
	
	
	//4.14.1�ų�һ���ߵ�ֽ�Ʋ���(�����ݹ�)
	public static int cardWin1(int[] arr)
	{
		if(arr==null||arr.length==0)
			return 0;
		
		return Math.max(f(arr,0,arr.length-1), s(arr,0,arr.length-1));
	}
	public static int f(int[] arr, int i, int j)
	{
		if(i==j)
			return arr[i];
		//��ѡ��Ļ���a[i]��[i+1..j]�ĺ�ѡ---a[j]��[i..j-1]�ĺ�ѡ--���߼�Ľϴ�ֵ
		return Math.max(arr[i]+s(arr,i+1, j),arr[j]+s(arr,i,j-1));
	}
	public static int s(int[] arr, int i, int j)
	{
		if(i==j)
			return 0;
		//��ѡ��Ļ�,[i+1..j]��[i,j-1]�еĽ�С��
		return Math.min(f(arr,i+1,j), f(arr,i,j-1));
	}
	
	//4.14.2�ų�һ���ߵ�ֽ�Ʋ���(��̬�滮)	
	public static int cardWin2(int[] arr)
	{
		if(arr==null||arr.length==0)
			return 0;
		
		int[][] f = new int[arr.length][arr.length];
		int[][] s = new int[arr.length][arr.length];
		for(int j=0; j<arr.length; j++)
		{
			f[j][j] = arr[j];
			for(int i=j-1; i>=0; i--){//�м�i<=j
				f[i][j] = Math.max(arr[i]+s[i+1][j], arr[j]+s[i][j-1]);
				s[i][j] = Math.min(f[i+1][j], f[i][j-1]);
			}
		}
		
		return Math.max(f[0][arr.length-1], s[0][arr.length-1]);	
	}
	
	//4.15��Ծ��Ϸ
	public static int jump(int[] arr)
	{
		if(arr==null||arr.length==0)
			return 0;
		
		int jump = 0;
		int cur = 0;//jump���ܹ��ﵽ[��Զ]����
		int next = 0;//����һ���ܹ��ﵽ��[��Զ]����
		for(int i=0; i<arr.length; i++)
		{
			if(cur<i) {
				jump++;
				cur = next;
			}
			//��һ���ﵽ����Զ��ǰһ���ﵽ֮ǰ���п����������Զ��
			next = Math.max(next, i+arr[i]);
		}
		
		return jump;
	}
	
	//4.16���������������
	public static int longestConsecutive(int[] arr)
	{
		if(arr==null||arr.length==0)
			return 0;
		int max = 1;
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
		for(int i=0; i<arr.length; i++)
		{
			if(!map.containsKey(arr[i]))
			{
				map.put(arr[i], 1);
				if(map.containsKey(arr[i]-1))
					max = Math.max(max, merge(map, arr[i]-1, arr[i]));
				if(map.containsKey(arr[i]+1))
					max = Math.max(max, merge(map, arr[i], arr[i]+1));
			}
		}
		return max;
	}
	
	public static int merge(HashMap<Integer,Integer> map, int less, int more)
	{
		int left = less-map.get(less)+1;//�������ҽڵ㲢���map
		int right = more+map.get(more)-1;
		
		int len = right-left+1;
		
		map.put(left, len);
		map.put(right, len);
		return len;
	}
	
	//4.17.1N�ʺ�����(�ݹ飬����һ�ַ�����λ����)
	public static int NQueue(int n)
	{
		if(n<1)
			return 0;
		int[] record = new int[n];
		return mprocess1(0, record, n);
	}
	
	public static int mprocess1(int i, int[] record, int n)
	{
		if(i==n)
			return 1;
		int res = 0;
		for(int j=0; j<n; j++){
			if(mValid(record, i, j)){
				record[i] = j;
				res += mprocess1(i+1, record, n); 
			}
		}
		return res;
	}
	
	public static boolean mValid(int[] record, int i, int j)
	{
		for(int k=0; k<i; k++)
		{
			if(record[k]==j || Math.abs(record[k]-j)==Math.abs(k-i))
				return false;
		}
		return true;	
	}
	
	
	
	
	
	public static void printArray(int[] arr)
	{
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	
	public static void printMatrix(int[][] matrix)
	{
		for(int i=0; i<matrix.length; i++)
		{
			for(int j=0; j<matrix[0].length; j++)
			{
				if(matrix[i][j]==2147483647)
					System.out.print("Z");
				else
					System.out.print(matrix[i][j]);
				if(j!=matrix[0].length)
					System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public static void main1(String[] args) {
		int[][] m = {
				{1,3,5,9},
				{8,1,3,4},
				{5,0,6,1},
				{8,8,4,0}
		};
		//4.2������С·����
		int res = minPathSum(m);
		System.out.println(res);
		//4.3��Ǯ����С������
		int[] arr = {5,10,25,1};
		int aim = 15;
		res = minCoin(arr,aim);
		//4.4��Ǯ�ķ�����
		res = coins3(arr,aim);
		
		//4.5�����������
		int[] lisarr = {2,1,5,3,6,4,8,9,7};
		int[] lisres = LIS(lisarr);
		printArray(lisres);
		
		//4.7�����������
		String lcseres = lcse("13542687","148675");
		System.out.println(lcseres);
		
		//4.8������Ӵ�
		String lcstres = lcst("1AB2345CD", "12345EF");
		System.out.println(lcstres);
		
		//4.9��С�༭����
		int minres = minCost("abc","abc",5,3,100);
		System.out.println(minres);
		
		//4.10�ַ����������
		boolean icres = isCross("aabcc","dbbca","aadbbbaccc");
		System.out.println(icres);
		
		//4.11������³�
		int[][] dram = {
			{-2, -3, 3},
			{-5, -10,1},
			{0, 30, -5}
		};
		int drares = dragonGame(dram);
		System.out.println(drares);
		
		//4.12�����ַ���ת��Ϊ��ĸ��ϵ�����
		int alhpares = alphaNum("11111100");
		System.out.println(alhpares);
		
		//4.13���ʽ�õ�����������������
		int desres = desireTrue("1^0|0|1", false);
		System.out.println(desres);
		
		//4.14�ų�һ���ߵ�ֽ�Ʋ���
		int[] cardarr = {1,2,100,4};
		int winres = cardWin1(cardarr);
		System.out.println(winres);
		
		//4.15��Ծ��Ϸ
		
		int[] jumparr = {3,2,3,1,1,4};
		int jumpres = jump(jumparr);
		System.out.println(jumpres);
		
		//4.16���������������
		int[] lcarr = {100,4,200,1,3,2};
		int lcres = longestConsecutive(lcarr);
		System.out.println(lcres);
		
		//4.17N�ʺ�����
		int queueres = NQueue(8);
		System.out.println(queueres);
	}

}
