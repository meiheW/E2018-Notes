package onlineexam._20181013_eleme;

public class BinarySearch {
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4,5,6};
		int num = 3;
		
		System.out.println(binarySearch(arr, 0, arr.length-1, num));
		
	}

	private static int binarySearch(int[] arr, int low, int high, int num) {
		
		while(low<=high){
			int mid = (low+high)/2;
			if(arr[mid] < num){
				low = mid+1;
			}else if(arr[mid] > num){
				high = mid-1;
			}else{
				return mid;
			}
		
		}
		return -1;
	}
	
}
