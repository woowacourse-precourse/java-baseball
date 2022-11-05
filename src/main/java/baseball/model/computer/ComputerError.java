package baseball.model.computer;

import java.util.List;
import java.util.Objects;

import static baseball.controller.Setup.*;

public class ComputerError {

	static boolean followDigitRule(List<Integer> randomNumber) {
		return Objects.equals(randomNumber.size(), Integer.parseInt(NUMBER_LENGTH.getValue()));
	}

	public static boolean hasDuplication(List<Integer> randomNumber, int createdNumber) {
		return randomNumber.contains(createdNumber);
	}
}
