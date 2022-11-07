package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class UserNums {

    private final List<Integer> numbers = new ArrayList<>();

    public UserNums(String userinput) {
        if (userinput.length() != BaseballRule.num_length) {
            throw new IllegalArgumentException("자리수가 맞지않습니다.");
        }
        for (char usernumchar : userinput.toCharArray()) {
            numbersAdd(usernumchar);
        }

    }

    private void numbersAdd(char usernum) {
        if (!(usernum >= '0' && usernum <= '9')) {
            throw new IllegalArgumentException("숫자가 아닌 문자 입니다.");
        }
        if (numbers.contains(Character.getNumericValue(usernum))) {
            throw new IllegalArgumentException("서로 다른 수가 아닙니다.");
        }
        numbers.add(Character.getNumericValue(usernum));

    }


    public List<Integer> getNumbers() {
        return numbers;
    }


}
