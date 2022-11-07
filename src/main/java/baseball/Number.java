package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Number {
	private static final int CNT_NUMBER = 3;
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;
	private static final String INPUT_SENTENCE = "숫자를 입력해주세요 : ";

	private int[] digits;

	public Number() {}

	public int[] getDigits() {
		return this.digits;
	}

	public void setRandomNumber() {
		Set<Integer> digitSet = new HashSet<>();

		while(digitSet != null && digitSet.size() < CNT_NUMBER) {
			digitSet.add(getRandomNumber());
		}

		this.digits = convertIntegerSetToIntArray(digitSet);
	}

	private int[] convertIntegerSetToIntArray (Set<Integer> set) {
		return set.stream()
					.mapToInt(Integer::intValue)
					.toArray();
	}

	private int getRandomNumber() {
		return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
	}
	
	public void inputAnswer() {
		System.out.print(INPUT_SENTENCE);
		String input = Console.readLine();
		setDigits(input);
	}
	
	public void inputAnswer(String str) {
		setDigits(str);
	}
	
	private void setDigits(String input) {
		this.digits = Arrays.stream(input.split(""))
				.mapToInt(Integer::parseInt)
				.toArray();
	}
}
