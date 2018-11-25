package sword2offer.stack;

public class T1_Fibonacci {
		//Fibonacci
		public static int Fibonacci(int n){
			if(n<=1) return n;
			int[] arr = new int [n+1];
			arr[0]=0;arr[1]=1;
	 		for(int i=2; i<=n; i++){
				arr[i] = arr[i-1]+arr[i-2];
			}
	 		
	 		return arr[n];
		}
		
		public static int Fibonacci_1(int n){
			if(n<=1) return n;
			int pre2=0, pre1=1;
			int fib=0;
			for(int i=2; i<=n; i++){
				fib = pre2+pre1;
				pre2 = pre1;
				pre1 = fib;
			}
			return fib;
		}
		
		public static int jumpFloor(int target){
			if(target==1) return 1;
			if(target==2) return 2;
			return jumpFloor(target-1)+jumpFloor(target-2);
			
		}
		
		//O(N)+O(N)
		public static int jumpFloor_1(int n){
			if(n==1) return 1;
			int[] arr = new int[n];
			arr[0]=1;	arr[1]=2;
			for(int i=2; i<n; i++){
				arr[i]=arr[i-1]+arr[i-2];
				
			}
			
			return arr[n-1];
		}
		
		//O(N)+O(1)	//跳台阶--矩形覆盖--相同
		public static int jumpFloor_2(int n){
			if(n<=2) return n;
			int pre2 = 1;
			int pre1 = 2;
			int res = 0;
			for(int i=3; i<=n; i++){
				res = pre2 + pre1;
				pre2 = pre1;
				pre1 = res;
				
			}
			return res;
		}
}
