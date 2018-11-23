package _20180818_beike;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * һ���˿��ư���С��Ϊ13�֣�ÿ���Ƹ��ĸ���ɫ���ܹ�52���ơ��涨13���ƴ�С����˳��ֱ�Ϊ��
 * A23456789TJQK,���ڴ�һ�����г�ȡ20�ţ�ÿ�ֳ��ƹ���
 * ���ƣ���һ�ţ�
 * ���ӣ�������ͬ�ģ�
 * ���������Ŵ�С��ͬ���ƣ�����һ�ţ�
 * �Ĵ������Ŵ�С��ͬ���ƣ��������������⣻
 * ˳�ӣ���������������ƣ�
 * ��ô�����ٶ������ܹ�ȫ�����ꣿ
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