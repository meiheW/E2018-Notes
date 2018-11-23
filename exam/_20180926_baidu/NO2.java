package _20180926_baidu;

import java.util.*;
//IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
//SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
//DEFINE ANY CLASS AND METHOD NEEDED
//CLASS BEGINS, THIS CLASS IS REQUIRED
public class NO2
{        
 // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
 public static int minNumberOfProjects(int num, int projCmptDec, int restDec,
 							   int[] errorScore)    
 {
     
     boolean flag = false;
     int count = 0;
     while(!flag){
         Arrays.sort(errorScore);
         errorScore[errorScore.length-1] = (errorScore[errorScore.length-1] - projCmptDec > 0) ? errorScore[errorScore.length-1] - restDec : 0;
         for(int i=0; i<errorScore.length-1; i++){
             errorScore[i] = (errorScore[i] - restDec > 0) ? errorScore[i] - restDec : 0;
         }
         count++;
         if(isArrayAllZero(errorScore))
             flag = true;
         
     }
     
     return count;
     
 }
 // METHOD SIGNATURE ENDS
 
 private static boolean isArrayAllZero(int[] errorScore){
     boolean res = true;
     for(int i=0; i<errorScore.length; i++){
         if(errorScore[i]!=0){
             res = false;
             break;
         }
         
     }
     
     return res;
     
     
 }
 
 
 public static void main(String[] args) {
	 int num = 4;
	 int projCmptDec = 3;
	 int restDec = 1;
	 
	 int[] errorScore = {9,8,2,5};
	 
	 System.out.println(minNumberOfProjects(num, projCmptDec, restDec, errorScore));  
	 
	 
	 
}
 
 
}