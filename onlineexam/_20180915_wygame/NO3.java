package onlineexam._20180915_wygame;

import java.util.ArrayList;
import java.util.Scanner;

public class NO3 {

    public static void sqt2(double[][] x, double[] y, int m, int n, double[] a,
            double[] dt, double[] v) {
        int i, j, k, mm;
        double q, e, u, p, yy, s, r, pp;
        double[] b = new double[(m + 1) * (m + 1)];
        mm = m + 1;
        b[mm * mm - 1] = n;
        for (j = 0; j <= m - 1; j++) {
            p = 0.0;
            for (i = 0; i <= n - 1; i++)
                p = p + x[j][i];
            b[m * mm + j] = p;
            b[j * mm + m] = p;
        }
        for (i = 0; i <= m - 1; i++)
            for (j = i; j <= m - 1; j++) {
                p = 0.0;
                for (k = 0; k <= n - 1; k++)
                    p = p + x[i][k] * x[j][k];
                b[j * mm + i] = p;
                b[i * mm + j] = p;
            }
        a[m] = 0.0;
        for (i = 0; i <= n - 1; i++)
            a[m] = a[m] + y[i];
        for (i = 0; i <= m - 1; i++) {
            a[i] = 0.0;
            for (j = 0; j <= n - 1; j++)
                a[i] = a[i] + x[i][j] * y[j];
        }
        chlk(b, mm, 1, a);
        yy = 0.0;
        for (i = 0; i <= n - 1; i++)
            yy = yy + y[i] / n;
        q = 0.0;
        e = 0.0;
        u = 0.0;
        for (i = 0; i <= n - 1; i++) {
            p = a[m];
            for (j = 0; j <= m - 1; j++)
                p = p + a[j] * x[j][i];
            q = q + (y[i] - p) * (y[i] - p);
            e = e + (y[i] - yy) * (y[i] - yy);
            u = u + (yy - p) * (yy - p);
        }
        s = Math.sqrt(q / n);
        r = Math.sqrt(1.0 - q / e);
        for (j = 0; j <= m - 1; j++) {
            p = 0.0;
            for (i = 0; i <= n - 1; i++) {
                pp = a[m];
                for (k = 0; k <= m - 1; k++)
                    if (k != j)
                        pp = pp + a[k] * x[k][i];
                p = p + (y[i] - pp) * (y[i] - pp);
            }
            v[j] = Math.sqrt(1.0 - q / p);
        }
        dt[0] = q;
        dt[1] = s;
        dt[2] = r;
        dt[3] = u;
    }
 
    private static int chlk(double[] a, int n, int m, double[] d) {
        int i, j, k, u, v;
        if ((a[0] + 1.0 == 1.0) || (a[0] < 0.0)) {
            System.out.println("fail\n");
            return (-2);
        }
        a[0] = Math.sqrt(a[0]);
        for (j = 1; j <= n - 1; j++)
            a[j] = a[j] / a[0];
        for (i = 1; i <= n - 1; i++) {
            u = i * n + i;
            for (j = 1; j <= i; j++) {
                v = (j - 1) * n + i;
                a[u] = a[u] - a[v] * a[v];
            }
            if ((a[u] + 1.0 == 1.0) || (a[u] < 0.0)) {
                System.out.println("fail\n");
                return (-2);
            }
            a[u] = Math.sqrt(a[u]);
            if (i != (n - 1)) {
                for (j = i + 1; j <= n - 1; j++) {
                    v = i * n + j;
                    for (k = 1; k <= i; k++)
                        a[v] = a[v] - a[(k - 1) * n + i] * a[(k - 1) * n + j];
                    a[v] = a[v] / a[u];
                }
            }
        }
        for (j = 0; j <= m - 1; j++) {
            d[j] = d[j] / a[0];
            for (i = 1; i <= n - 1; i++) {
                u = i * n + i;
                v = i * m + j;
                for (k = 1; k <= i; k++)
                    d[v] = d[v] - a[(k - 1) * n + i] * d[(k - 1) * m + j];
                d[v] = d[v] / a[u];
            }
        }
        for (j = 0; j <= m - 1; j++) {
            u = (n - 1) * m + j;
            d[u] = d[u] / a[n * n - 1];
            for (k = n - 1; k >= 1; k--) {
                u = (k - 1) * m + j;
                for (i = k; i <= n - 1; i++) {
                    v = (k - 1) * n + i;
                    d[u] = d[u] - a[v] * d[i * m + j];
                }
                v = (k - 1) * n + k - 1;
                d[u] = d[u] / a[v];
            }
        }
        return (2);
    }
 

    public static void main(String[] args) {
        int i;
        double[] a = new double[4];
        double[] v = new double[3];
        double[] dt = new double[4];
 
        ArrayList<Double> alx0 = new ArrayList<Double>(); 
        ArrayList<Double> alx1 = new ArrayList<Double>(); 
        ArrayList<Double> aly = new ArrayList<Double>(); 
        
        
        Scanner sc = new Scanner(System.in);
        
        double curStr = sc.nextDouble();
        while(sc!=null){
        	System.out.println(curStr);
        	alx0.add(curStr);
        	alx1.add(sc.nextDouble());
        	aly.add(sc.nextDouble());
        }
        

        
        for( i=0; i<alx0.size(); i++)
        	System.out.println(alx0.get(i)+" ");
        //double[][] x = { { 1.1, 1.0, 1.2, 1.1, 0.9 },
        //        { 2.0, 2.0, 1.8, 1.9, 2.1 }, { 3.2, 3.2, 3.0, 2.9, 2.9 } };
        
        double[][] x = new double[2][alx0.size()];
        for(i=0; i<alx0.size(); i++){
        	x[0][i] = alx0.get(i);
        }
        for(i=0; i<alx1.size(); i++){
        	x[1][i] = alx1.get(i);
        }
        
        
        double[] y = new double[aly.size()];     //{ 10.1, 10.2, 10.0, 10.1, 10.0 };
        for(i=0; i<aly.size(); i++)
        	y[i] = aly.get(i);

        
        
        
        
        sqt2(x, y, 2, alx0.size(), a, dt, v);
        
        for (i = 0; i < 3; i++){
            System.out.print(a[i]);
            if(i!=2)
            	System.out.print(",");
        }
        
 
    }
	
}
