package baseball.controller.error;

import java.util.List;
import java.util.Objects;

import static baseball.controller.Setup.*;

public class ComputerError {

	public static boolean followDigitRule(List<Integer> randomNumber) {
		return Objects.equals(randomNumber.size(), Integer.parseInt(NUMBER_LENGTH.getValue()));
	}

	public static boolean followDuplicationRule(List<Integer> randomNumber, int createdNumber) {
		return Boolean.parseBoolean(DUPLICATION_ALLOWABLE.getValue()) == hasDuplication(randomNumber, createdNumber);
	}

	public static boolean hasDuplication(List<Integer> randomNumber, int createdNumber) {
		return randomNumber.contains(createdNumber);
	}

}
