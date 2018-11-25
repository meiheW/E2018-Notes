package online_exam._20181013_eleme;

public class FrogJump {
	
	public static void main(String[] args) {
		
		int n = 5;
		System.out.println(getSum(n));
		
	}

	private static int getSum(int n) {
		if(n==1||n==2)
			return n;
		int[] arr = new int[n];
		arr[0] = 1;
		arr[1] = 2;
		for(int i=2; i<n; i++){
			arr[i] = arr[i-1]+arr[i-1];
		}
		
		
		
		return arr[n-1];
	}
	
	
	
}
