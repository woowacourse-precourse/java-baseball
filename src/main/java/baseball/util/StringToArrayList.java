package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class StringToArrayList {

	public static List<Integer> convert(String input) {
		List<Integer> arrayList = new ArrayList<>();

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			arrayList.add(Character.getNumericValue(c));
		}

		return arrayList;
	}
}
