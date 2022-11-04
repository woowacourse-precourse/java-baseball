package baseball.exception;

import java.util.List;
import java.util.regex.Pattern;

public class InputException {
    private static final Pattern IsOnlyNumber = Pattern.compile("^[1-9]*?");

    public void isNumber(String input) {
        if (input.isEmpty() || !IsOnlyNumber.matcher(input).matches()) {
            throw new IllegalArgumentException("숫자 외의 값이 입력되었습니다.");
        }
    }

    public void InputValid(List<Integer> RandomList, List<Integer> inputList) {

        if (inputList.size() != RandomList.size()) {
            throw new IllegalArgumentException("입력값이 잘못 되었습니다.");
        }

        for(int idx = 0; idx < inputList.size() - 1; idx++) {
            for (int compare = idx+1; compare < inputList.size(); compare++) {
                if (inputList.get(idx) == inputList.get(compare))
                    throw new IllegalArgumentException("입력값이 잘못 되었습니다.");
            }
        }

    }
}
