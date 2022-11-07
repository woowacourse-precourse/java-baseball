package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import baseball.constants.Constants;
import camp.nextstep.edu.missionutils.Console;

// 입력한 숫자
public class User {
	
	public ArrayList<Integer> userNumber;
	
	public void setUserNumber() throws IllegalArgumentException {
		userNumber = new ArrayList<>();
		System.out.print(Constants.inputNumberMessage);
		addUserNumber(Console.readLine());
	}
	
	public void addUserNumber(String word) throws IllegalArgumentException {
		userNumberLength(word);
		userNumberDigit(word);
		userNumberSameCheck(word);
		for(int i = 0; i < word.length(); i++) {
			userNumber.add(word.charAt(i) - '0');
		}
	}
	
	// 1. 입력한 문자가 3자리 인가?
	public static void userNumberLength(String word) {
		if(word.length() != Constants.NUMBER_MAX_LENGTH) {
			throw new IllegalArgumentException("Length Error");
		}
	}
	
	// 2. 입력한 문자가 모두 숫자인가?
	public static void userNumberDigit(String word) {
		for(int i = 0; i < word.length(); i++) {
			userNumberDigitCheck(word.charAt(i));
		}
	}
	
	public static void userNumberDigitCheck(Character number) {
		if(Character.isDigit(number) == false) {
			throw new IllegalArgumentException("Not Digit word");
		}
	}
	
	// 3. 입력한 문자가 모두 숫자이되 중복된 값이 있는가?
	public static void userNumberSameCheck(String word) {
		Set<Character> set = new HashSet<>();
		for(int i = 0; i < word.length(); i++) {
			set.add(word.charAt(i));
		}
		if(word.length() != set.size()) {
			throw new IllegalArgumentException("Duplication Number");
		}
	}
	
	// 끝날 때 입력
	public static boolean finishInput() throws IllegalArgumentException {
		return finishNumber(Console.readLine());
	}
	
	public static boolean finishNumber(String word) {
		if(word.equals("1")) {
			return true;
		} else if(word.equals("2")) {
			return false;
		}
		throw new IllegalArgumentException();
	}
}
