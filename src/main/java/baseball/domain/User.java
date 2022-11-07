package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import baseball.constants.Constants;
import camp.nextstep.edu.missionutils.Console;

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
	
	public static void userNumberLength(String word) {
		if(word.length() != Constants.NUMBER_MAX_LENGTH) {
			throw new IllegalArgumentException("Length Error");
		}
	}
	
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
	
	public static void userNumberSameCheck(String word) {
		Set<Character> set = new HashSet<>();
		for(int i = 0; i < word.length(); i++) {
			set.add(word.charAt(i));
		}
		if(word.length() != set.size()) {
			throw new IllegalArgumentException("Duplication Number");
		}
	}
	
	public static void userNumberRange(String word) {
		for(int i = 0; i < word.length(); i++) {
			userNumberRangeCheck(word.charAt(i));
		}
	}
	
	public static void userNumberRangeCheck(Character number) {
		for(int i = Constants.MIN_RANGE; i <= Constants.MAX_RANGE; i++) {
			if(number == (i - '0')) {
				return;
			}
		}
		throw new IllegalArgumentException("Not Range in Number");
	}
	
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
