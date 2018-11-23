package _20180818_beike;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 一副扑克牌按大小分为13种，每种牌各四个花色，总共52张牌。规定13张牌从小到大顺序分别为：
 * A23456789TJQK,现在从一副牌中抽取20张，每轮出牌规则：
 * 单牌：任一张；
 * 对子：两张相同的；
 * 三带：三张大小相同的牌，带任一张；
 * 四带：四张大小相同的牌，带至多两张任意；
 * 顺子：至少五张任意的牌；
 * 那么，至少多少轮能够全部出完？
 * @author Administrator
 *
 */

public class NO2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		char[] card = s.nextLine().trim().toCharArray();
		Integer[] intCard = new Integer[card.length];
		List<Integer> arrayCard = new ArrayList<>();
		for (int i = 0; i< intCard.length; i++) {
			switch(card[i]) {
			case 'A':
				intCard[i] = 1;
				break;
			case 'T':
				intCard[i]=10;
				break;
			case 'J':
				intCard[i]=11;
				break;
			case 'Q':
				intCard[i]=12;
				break;
			case 'K':
				intCard[i]=13;
				break;
			default:
				intCard[i] = card[i] - '0';
			}
			arrayCard.add(intCard[i]);
		}
		Collections.sort(arrayCard);
		List<TreeSet<Integer>> list = new ArrayList<>();
		while(!arrayCard.isEmpty()) {
			int index = 0;
			Iterator<Integer> it = arrayCard.iterator();
			TreeSet<Integer> set = new TreeSet<Integer>();
			while(it.hasNext()) {
				Integer lin = it.next();
				if(set.isEmpty()) {
					set.add(lin);
				}
				if(set.last() == lin+1) {
					set.add(lin);
				} else {
					if(set.size() < 5) {
						index ++;
						set.clear();
					} else {
						list.add(set);
						break;
					}
				}
			}
			for(Integer i: set) {
				arrayCard.remove(i);
			}
			if(index > 10) {
				break;
			}
		}
		Collections.sort(arrayCard);
		HashMap<Integer, Integer> map = new HashMap<>();
		for(Integer i: arrayCard) {
			if(map.containsKey(i)) {
				map.put(i, map.get(i)+1);
			}else {
				map.put(i, 1);
			}
		}
		
		for(int i : intCard) {
			System.out.print(i + " ");
		}
	}
}