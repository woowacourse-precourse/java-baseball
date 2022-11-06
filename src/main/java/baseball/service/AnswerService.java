package baseball.service;

import static baseball.Constant.*;

import java.util.HashSet;
import java.util.Set;

public class AnswerService {
	private AnswerService() {}

	private static AnswerService instance;

	public static AnswerService getInstance() {
		if(instance == null) {
			instance = new AnswerService();
		}
		return instance;
	}

	public void validateInputAnswer(String inputAnswer) {
		validateDigits(inputAnswer);
		validateNumberSize(inputAnswer);
		validateDuplicatedNumber(inputAnswer);
	}

	private void validateDigits(String inputAnswer) {
		if(!inputAnswer.chars().allMatch(Character::isDigit)) {
			throw new IllegalArgumentException(INPUT_ANSWER_IS_NOT_DIGIT_ERROR_MESSAGE);
		}
	}

	private void validateNumberSize(String inputAnswer) {
		if(inputAnswer.length() != CORRECT_ANSWER_NUMBER_SIZE) {
			throw new IllegalArgumentException(INPUT_ANSWER_IS_NOT_ENOUGH_SIZE_ERROR_MESSAGE);
		}
	}

	private void validateDuplicatedNumber(String inputAnswer) {
		Set<Integer> numbers = new HashSet<>();
		inputAnswer.chars().forEach(numbers::add);
		if(numbers.size() != CORRECT_ANSWER_NUMBER_SIZE) {
			throw new IllegalArgumentException(INPUT_ANSWER_IS_DUPLICATED_ERROR_MESSAGE);
		}
	}
}
