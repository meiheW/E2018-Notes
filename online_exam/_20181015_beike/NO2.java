package online_exam._20181015_beike;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class NO2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine().trim());
		int[][] points = new int[n][6];
		for (int i = 0; i < points.length; i++) {
			String[] strs = scanner.nextLine().trim().split(" ");
			for (int j = 0; j < 6; j++) {
				points[i][j] = Integer.parseInt(strs[j].trim());
			}
		}
		//SimpleDateFormat df = new SimpleDateFormat();
		long curTime = System.currentTimeMillis();
		//System.out.println(df.format(new Date()));
		for (int i = 0; i < points.length; i++) {
			
			caculate(points[i]);
		}
		
		System.out.println(System.currentTimeMillis()-curTime);
		//System.out.println(df.format(new Date()));
	}

	public static void caculate(int[] points) {
		int x = points[0];
		int a = points[1];
		int c = points[2];
		int y = points[3];
		int b = points[4];
		int d = points[5];

		int timeX = 0;// 小智打小春花费时�?
		int timeY = 0;// 小春打小智花费时�?
		while (true) {
			y = y - a;
			if (y > 0) {
				timeX += c;
			} else {
				break;
			}
		}
		while (true) {
			x = x - b;
			if (x > 0) {
				timeY += d;
			} else {
				break;
			}
		}
		if (timeX > timeY) {
			System.out.println("XIAOCHUN");
		} else if (timeX < timeY) {
			System.out.println("XIAOZHI");
		} else {
			System.out.println("TIE");
		}
	}
}