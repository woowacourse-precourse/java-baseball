package baseball.utils;

import java.util.List;
import java.util.stream.Collectors;

public class Parser {
	public static List<Character> parseStringToCharList(String str) {
		return str.chars()
				.mapToObj(e -> (char) e)
				.collect(Collectors.toList());
	}
}
