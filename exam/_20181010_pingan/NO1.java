package _20181010_pingan;

import java.util.*;

public class NO1{
  public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      Map<Integer, Integer> tree = new HashMap<>();
      int high = 0;
      int father, son ;
      while(in.hasNext()){
          String[] strs = in.nextLine().split("\\s+");
			father = Integer.parseInt(strs[0]);
			son = Integer.parseInt(strs[1]);
			tree.put(son, father);
		}
      int index;
      for(Integer key : tree.keySet() ){
      	index = 1;
          while(tree.containsKey(key)){
          	index ++;
              key = tree.get(key);
          }
          if(high < index) {
          	high = index;
          }
      }
      System.out.print(high);
  }
}