package _20180907_alibaba;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NO2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] pointstr = sc.nextLine().split(",");
		Point2D.Double point = new Point2D.Double(Double.valueOf(pointstr[0]), Double.valueOf(pointstr[1]));
		
		String[] points = sc.nextLine().split(",");
		List<Point2D.Double> pts = new ArrayList<Point2D.Double>();
		for(int i=0; i<points.length/2; i++){
			pts.add(new Point2D.Double(Double.valueOf(points[i]), Double.valueOf(points[i+1])));
		}
	    
		
		
	    if(IsPtInPoly(point, pts)){
	        System.out.println("yes,0");
	    }else{
	        System.out.print("no,");
	        double len = 0;
	        len = getMinLen(point, pts);
	        
	        System.out.println(len);
	    }
		

	}
	
	
	private static double getMinLen(java.awt.geom.Point2D.Double point, List<java.awt.geom.Point2D.Double> pts) {
		ArrayList<Double> dis = new ArrayList<Double>();
		for(int i=0;i<pts.size()-1; i++){
			dis.add(pointToLine(pts.get(i).getX(), pts.get(i).getY(), pts.get(i+1).getX(), pts.get(i+1).getY(), point.getX(), point.getY()));
		}
		dis.add(pointToLine(pts.get(0).getX(), pts.get(0).getY(), pts.get(pts.size()-1).getX(), pts.get(pts.size()-1).getY(), point.getX(), point.getY()));
		
		double min = 0.0;
		for(int i=0; i<dis.size(); i++){
			if(dis.get(i)<min)
				min = dis.get(i);
		}
		
		return min;
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
	
	public static boolean IsPtInPoly(Point2D.Double point, List<Point2D.Double> pts){
	    
	    int N = pts.size();
	    boolean boundOrVertex = true; 
	    int intersectCount = 0; 
	    double precision = 2e-10; 
	    Point2D.Double p1, p2;
	    Point2D.Double p = point;
	    
	    p1 = pts.get(0);        
	    for(int i = 1; i <= N; ++i){            
	        if(p.equals(p1)){
	            return boundOrVertex;
	        }
	        
	        p2 = pts.get(i % N);            
	        if(p.x < Math.min(p1.x, p2.x) || p.x > Math.max(p1.x, p2.x)){                
	            p1 = p2; 
	            continue;
	        }
	        
	        if(p.x > Math.min(p1.x, p2.x) && p.x < Math.max(p1.x, p2.x)){
	            if(p.y <= Math.max(p1.y, p2.y)){                    
	                if(p1.x == p2.x && p.y >= Math.min(p1.y, p2.y)){
	                    return boundOrVertex;
	                }
	                
	                if(p1.y == p2.y){                        
	                    if(p1.y == p.y){
	                        return boundOrVertex;
	                    }else{
	                        ++intersectCount;
	                    } 
	                }else{                        
	                    double xinters = (p.x - p1.x) * (p2.y - p1.y) / (p2.x - p1.x) + p1.y;//cross point of y                        
	                    if(Math.abs(p.y - xinters) < precision){
	                        return boundOrVertex;
	                    }
	                    
	                    if(p.y < xinters){
	                        ++intersectCount;
	                    } 
	                }
	            }
	        }else{                
	            if(p.x == p2.x && p.y <= p2.y){                    
	                Point2D.Double p3 = pts.get((i+1) % N);                     
	                if(p.x >= Math.min(p1.x, p3.x) && p.x <= Math.max(p1.x, p3.x)){
	                    ++intersectCount;
	                }else{
	                    intersectCount += 2;
	                }
	            }
	        }            
	        p1 = p2;
	    }
	    
	    if(intersectCount % 2 == 0){
	        return false;
	    } else { 
	        return true;
	    }
	    
	}
	 
	 


	
}
