package onlineexam._20181010_didi;

import java.util.ArrayList;
import java.util.Scanner;

public class NO1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] strs = scanner.nextLine().trim().split(" ");
		int num = Integer.parseInt(strs[0]);
		int combineNum = Integer.parseInt(strs[1]);
		strs = scanner.nextLine().trim().split(" ");
		ArrayList<Integer> values = new ArrayList<>();
		for (String str : strs) {
			values.add(Integer.parseInt(str));
		}
		for (int i = 0; i < combineNum; i++) {
			int index = 0;
			for (int j = 1; j < values.size(); j++) {
				if (values.get(index) > values.get(j)) {
					index = j;
				}
			}
			int nextIndex = (index + 1) % values.size();
			for (int j = 1; j < values.size(); j++) {
				if (index != j && values.get(nextIndex) > values.get(j)) {
					nextIndex = j;
				}
			}
			
			if (index == 0) {
				values.set(index + 1, values.get(index) + values.get(index + 1));
				values.remove(index);
			} else if (index == values.size() - 1) {
				values.set(index - 1, values.get(index) + values.get(index - 1));
				values.remove(index);
			} else if (values.get(index - 1) > values.get(index + 1)) {
				values.set(index + 1, values.get(index) + values.get(index + 1));
				values.remove(index);
			} else if(values.get(index - 1) < values.get(index + 1)) {
				values.set(index - 1, values.get(index) + values.get(index - 1));
				values.remove(index);
			} else {
				if(nextIndex < index) {
					values.set(index + 1, values.get(index) + values.get(index + 1));
					values.remove(index);
				} else {
					values.set(index - 1, values.get(index) + values.get(index - 1));
					values.remove(index);
				}
			}
		}
		int min = values.get(0);
		for (Integer integer : values) {
			if (integer < min) {
				min = integer;
			}
		}
		System.out.println(min);
	}
}