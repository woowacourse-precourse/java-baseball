package baseball;

import java.util.ArrayList;
import java.util.Arrays;

public class Validate {
	public static void checkCorrectInput(String number){
		if (!isNumeric(number)){
			throw new IllegalArgumentException(
				Message.USER_INPUT_NOT_NUMBER.getMsg() +
				Message.INVALID_INPUT_END_GAME.getMsg()
			);
		}
		if (!isNumberLengthLegal(number)){
			throw new IllegalArgumentException(
				Message.USER_INPUT_LENGTH_INVALID.getMsg() +
					Message.INVALID_INPUT_END_GAME.getMsg()
			);
		}
		if (isDuplicated(number)){
			throw new IllegalArgumentException(
				Message.USER_INPUT_DUPLICATED.getMsg() +
					Message.INVALID_INPUT_END_GAME.getMsg()
			);
		}
		if (isNumberNotInRange(number)){
			throw new IllegalArgumentException(
				Message.USER_INPUT_NUMBER_RANGE_INVALID.getMsg() +
					Message.INVALID_INPUT_END_GAME.getMsg()
			);
		}
	}

	public static boolean isNumeric(String number){
		try{
			Integer.parseInt(number);
			return true;
		}catch (NumberFormatException e){
			return false;
		}
	}

	public static boolean isNumberLengthLegal(String number){
		return number.length() == Constant.NUMBER_LENGTH.getNumber();
	}

	public static boolean isDuplicated(String number){
		return makeNumberList(number)
			.stream()
			.distinct()
			.count()
			!= number.length();
	}

	public static boolean isNumberNotInRange(String number){
		return makeNumberList(number).contains("0");
	}

	public static ArrayList<String> makeNumberList(String number){
		String[] numberArr = number.split("");
		return new ArrayList<>(Arrays.asList(numberArr));
	}

}
