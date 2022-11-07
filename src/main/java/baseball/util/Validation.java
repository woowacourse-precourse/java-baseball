package baseball.util;

import java.util.HashSet;
import java.util.Set;

public class Validation {
    public static boolean checkValidation(String inputString) {
	if (!checkLength(inputString)) return false;
	if (!checkInteger(inputString)) return false;
	if (!checkRightNumbers(inputString)) return false;
	return true;
    }

    private static boolean checkRightNumbers(String inputString) {
	Set<Integer> checkNumbers = new HashSet<Integer>();

	for (Character c: inputString.toCharArray()) {
	    if (Character.getNumericValue(c) == 0) {
		return false;
	    }
	    if (checkNumbers.contains(Character.getNumericValue(c))) {
		return false;
	    }
	    checkNumbers.add(Character.getNumericValue(c));
	}
	return true;
    }

    private static boolean checkInteger(String inputString) {
	for (Character c: inputString.toCharArray()) {
	    if (!Character.isDigit(c)) {
		return false;
	    }
	}
	return true;
    }

    private static boolean checkLength(String inputString) {
	return (inputString.length() == 3);
    }
}