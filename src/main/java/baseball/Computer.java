package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static constant.Const.*;

public class Computer {

    private static String answerNumber;

    protected void setAnswerNumber() {
        answerNumber = makeRandomNumber();
    }

    private String makeRandomNumber() {
        Set<String> numbers = new LinkedHashSet<>();
        while (numbers.size() != NUMBER_LENGTH) {
            numbers.add(String.valueOf(Randoms.pickNumberInRange(NUMBER_MIN_VALUE, NUMBER_MAX_VALUE)));
        }

        return convertSetToString(numbers);
    }

    private String convertSetToString(Set<String> numbers) {
        return numbers.stream().collect(Collectors.joining());
    }
}
