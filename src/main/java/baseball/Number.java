package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class Number {
	private static final int COUNT_NUMBER = 3;
	private static final int START_RANGE = 1;
	private static final int END_RANGE = 9;
	private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String REGEX = "^["+START_RANGE+"-"+END_RANGE+"]*$";

	private int[] number;

	public Number() {}

	private void setNumber(String input) {
		if(!checkInputValue(input)) {
			throw new IllegalArgumentException();
		}
		this.number = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
	}
	
	public int[] getNumber() {
		return this.number;
	}
	
	public void setRandomNumber() {
		Set<Integer> numberSet = new HashSet<>();

		while (numberSet != null && numberSet.size() < COUNT_NUMBER) {
			numberSet.add(getRandomNumber());
		}

		this.number = convertSetToArray(numberSet);
	}

	private int getRandomNumber() {
		return pickNumberInRange(START_RANGE, END_RANGE);
	}
	
	public int[] convertSetToArray(Set<Integer> set) {
		return set.stream().mapToInt(Integer::intValue).toArray();
	}
	
	public void getAnswer() {
		System.out.println(INPUT_MESSAGE);
		String input = Console.readLine();
		setNumber(input);
	}
	
	private boolean checkInputValue(String str) {
		if(!checkInputLength(str) || !checkInputPattern(str) || !checkInputDuplicate(str)) {
			return false;
		}
		return true;
	}
	
	private boolean checkInputLength(String input) {
		return input.length() == COUNT_NUMBER;
	}
	
	private boolean checkInputPattern(String input) {
		Pattern pattern = Pattern.compile(REGEX);
		return pattern.matcher(input).matches();
	}
	
	private boolean checkInputDuplicate(String input) {
		Set<Character> set = new HashSet<>();
		for(char s : input.toCharArray()) {
			set.add(s);
		}
		return input.length() == set.size();
	}


}