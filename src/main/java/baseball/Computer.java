package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static constant.Const.*;

public class Computer {

    private String answer;

    protected void setAnswer() {
        answer = makeRandomNumber();
        System.out.println("answer = " + answer);
    }

    private String makeRandomNumber() {
        Set<String> numbers = new LinkedHashSet<>();
        addRandomNumber(numbers);

        return convertSetToString(numbers);
    }

    private void addRandomNumber(Set<String> numbers) {
        while (numbers.size() != NUMBER_LENGTH) {
            numbers.add(String.valueOf(Randoms.pickNumberInRange(NUMBER_MIN_VALUE, NUMBER_MAX_VALUE)));
        }
    }

    private String convertSetToString(Set<String> numbers) {
        return numbers.stream().collect(Collectors.joining());
    }

    public String getAnswer() {
        return answer;
    }
}
