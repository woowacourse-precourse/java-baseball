package baseball;

import java.util.ArrayList;
import java.util.List;

public class UserNums {

    private List<Integer> numbers = new ArrayList<>();

    public UserNums(String userinput) {
        if (userinput.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자가 아닙니다.");
        }
        for (char usernumchar : userinput.toCharArray()) {
            numbersAdd(usernumchar);
        }

    }

    public void numbersAdd(char usernum) {
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
