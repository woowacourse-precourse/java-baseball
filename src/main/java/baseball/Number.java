package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Number {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 9;
    private static final int CNT_NUMBER = 3;
    private static final String ANSWER_LENGTH_ERR_MESSAGE = "숫자의 자리수가 올바르지 않습니다.";
    private static final String ANSWER_DUPLICATION_ERR_MESSAGE = "중복된 수가 포함되어 있습니다.";
    private static final String ANSWER_RANGE_ERR_MESSAGE = "범위를 벗어난 수가 포함되어 있습니다.";
    private static final String ANSWER_DATATYPE_ERR_MESSAGE = "숫자가 아닌 문자가 포함되어 있습니다.";

    public Number() {
    }

    public List<Integer> generateRandomNumber() {
        List<Integer> computerNumbers = new ArrayList<>();

        while (computerNumbers.size() < CNT_NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);

            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }

        return computerNumbers;
    }

    public boolean isValidAnswer(String answer) {
        checkLength(answer);
        checkDuplication(answer);
        checkDataType(answer);
        checkRange(answer);

        return true;
    }

    private void checkLength(String answer) {
        if (answer.length() != 3) {
            throw new IllegalArgumentException(ANSWER_LENGTH_ERR_MESSAGE);
        }
    }

    private void checkDuplication(String answer) {
        String uniqueAnswer = "";

        for (int idx = 0; idx < answer.length(); idx++) {
            if (answer.indexOf(answer.charAt(idx)) == idx) {
                uniqueAnswer += answer.charAt(idx);
            }
        }

        if (uniqueAnswer.length() != 3) {
            throw new IllegalArgumentException(ANSWER_DUPLICATION_ERR_MESSAGE);
        }
    }

    private void checkDataType(String answer) {
        List<Integer> asciiAnswer = new ArrayList<>();
        char character;
        int ascii;

        for (int idx = 0; idx < answer.length(); idx++) {
            character = answer.charAt(idx);
            ascii = character;
            asciiAnswer.add(ascii);
        }

        boolean answerDataType = asciiAnswer.stream().allMatch(num -> num >= 48 && num <= 57);

        if (!answerDataType) {
            throw new IllegalArgumentException(ANSWER_DATATYPE_ERR_MESSAGE);
        }
    }

    private void checkRange(String answer) {
        List<String> stringAnswers = List.of(answer.split(""));

        boolean answerRange = stringAnswers.stream().map(Integer::valueOf)
                .allMatch(num -> num >= MIN_RANGE && num <= MAX_RANGE);

        if (!answerRange) {
            throw new IllegalArgumentException(ANSWER_RANGE_ERR_MESSAGE);
        }
    }
}