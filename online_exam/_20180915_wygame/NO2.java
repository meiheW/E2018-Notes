package online_exam._20180915_wygame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Point{
	int x;
	int y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	double getDis(Point p){
		return Math.sqrt(Math.pow((x-p.x)*1.0, 2.0) + Math.pow((y-p.y)*1.0, 2.0) );
	}
}


public class NO2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Point[] points = new Point[3];
		for(int i=0; i<3; i++){
			String[] point = sc.nextLine().trim().split(" ");
			points[i] = new Point(Integer.parseInt(point[0]), Integer.parseInt(point[1]));
		}
		String[] innerPointStr = sc.nextLine().trim().split(" ");
		Point innerPoint = new Point(Integer.parseInt(innerPointStr[0]), Integer.parseInt(innerPointStr[1]));
		
		double d0 = points[0].getDis(points[1]);
		double d1 = points[1].getDis(points[2]);
		double d2 = points[2].getDis(points[0]);
		double p01 = points[0].getDis(points[1]);
		double p12 = points[1].getDis(points[2]);
		double p20 = points[2].getDis(points[0]);
		
		ArrayList<Double> lens = new ArrayList<Double>(); 
		lens.add(d0);lens.add(d1);lens.add(d2);
		Collections.sort(lens);
		d0 = lens.get(0);
		d1 = lens.get(1);
		d2 = lens.get(2);
		
		ArrayList<Double> area = new ArrayList<Double>(); 
		if(Math.pow(d0, 2.0) + Math.pow(d1, 2.0) == Math.pow(d2, 2.0)){
			double dt01 = pointToLine(points[0].x, points[0].y, points[1].x, points[1].y, innerPoint.x, innerPoint.y);
			double ht01 = p01 - p01 * dt01 / p12;
			area.add(dt01*ht01);
			
			double dt12 = pointToLine(points[1].x, points[1].y, points[2].x, points[2].y, innerPoint.x, innerPoint.y);
			double ht12 = p12 - p12 * dt12 / p01;
			area.add(dt12*ht12);
			
			double dt20 = pointToLine(points[2].x, points[2].y, points[0].x, points[0].y, innerPoint.x, innerPoint.y);
			double ht20 = p20 - p20 * dt20 / p20;
			area.add(dt20*ht20);
			
		}
		
		double max = 0;
		for(int i=0; i<area.size(); i++){
			if(area.get(i) > max){
				max = area.get(i);
				
			}
		}
		
		System.out.println(max);
		
		if(Math.pow(d0, 2.0) + Math.pow(d1, 2.0) == Math.pow(d2, 2.0)){
			System.out.println(4);
		}else if(Math.pow(d0, 2.0) + Math.pow(d1, 2.0) < Math.pow(d2, 2.0)){
			System.out.println(2);
		}else if(Math.pow(d0, 2.0) + Math.pow(d1, 2.0) > Math.pow(d2, 2.0)){
			System.out.println(6);
		}
		
		
		
	}
	
	
	private static double pointToLine(double x1, double y1, double x2, double y2, double x0, double y0) {
	    double space = 0;
	    double a, b, c;
	    a = lineSpace(x1, y1, x2, y2);// 线段的长度
	    b = lineSpace(x1, y1, x0, y0);// (x1,y1)到点的距离
	    c = lineSpace(x2, y2, x0, y0);// (x2,y2)到点的距离
	    if (c <= 0.000001 || b <= 0.000001) {
	       space = 0;
	       return space;
	    }
	    if (a <= 0.000001) {
	       space = b;
	       return space;
	    }
	    if (c * c >= a * a + b * b) {
	       space = b;
	       return space;
	    }
	    if (b * b >= a * a + c * c) {
	       space = c;
	       return space;
	    }
	    double p = (a + b + c) / 2;// 半周长
	    double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));// 海伦公式求面积
	    space = 2 * s / a;// 返回点到线的距离（利用三角形面积公式求高）
	    return space;
	}
	
	private static double lineSpace(double x1, double y1, double x2, double y2) {
	    double lineLength = 0;
	    lineLength = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2)
	           * (y1 - y2));
	    return lineLength;
	}
	
}
