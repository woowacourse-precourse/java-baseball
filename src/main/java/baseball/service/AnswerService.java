package baseball.service;

import static baseball.Constant.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import baseball.respository.AnswerRepository;
import camp.nextstep.edu.missionutils.Randoms;

public class AnswerService {
    private static AnswerService instance;
    private static AnswerRepository answerRepository;

    private AnswerService() {
    }

    public static AnswerService getInstance() {
        if (instance == null) {
            instance = new AnswerService();
            answerRepository = AnswerRepository.getInstance();
        }
        return instance;
    }

    public void setRandomNumbers() {
        Set<Integer> correctAnswer = new HashSet<>();
        while (correctAnswer.size() < CORRECT_ANSWER_NUMBER_SIZE) {
            correctAnswer.add(Randoms.pickNumberInRange(1, 9));
        }
        answerRepository.save(new ArrayList<>(correctAnswer));
    }

    public void validateInputAnswer(String inputAnswer) {
        validateDigits(inputAnswer);
        validateNumberSize(inputAnswer);
        validateDuplicatedNumber(inputAnswer);
    }

    private void validateDigits(String inputAnswer) {
        if (!inputAnswer.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(INPUT_ANSWER_IS_NOT_DIGIT_ERROR_MESSAGE);
        }
    }

    private void validateNumberSize(String inputAnswer) {
        if (inputAnswer.length() != CORRECT_ANSWER_NUMBER_SIZE) {
            throw new IllegalArgumentException(INPUT_ANSWER_IS_NOT_ENOUGH_SIZE_ERROR_MESSAGE);
        }
    }

    private void validateDuplicatedNumber(String inputAnswer) {
        Set<Integer> numbers = new HashSet<>();
        inputAnswer.chars().forEach(numbers::add);
        if (numbers.size() != CORRECT_ANSWER_NUMBER_SIZE) {
            throw new IllegalArgumentException(INPUT_ANSWER_IS_DUPLICATED_ERROR_MESSAGE);
        }
    }
}
