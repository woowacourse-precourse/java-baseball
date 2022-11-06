package baseball.exception;

import java.util.List;
import java.util.regex.Pattern;

public class InputException {
    private static final Pattern IsOnlyNumber = Pattern.compile("^[1-9]*?");

    public void restart(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("잘못된 값 입력");
        }
    }

    public void isNumber(String input) {
        if (input.isEmpty() || !IsOnlyNumber.matcher(input).matches()) {
            throw new IllegalArgumentException("숫자 외의 값이 입력되었습니다.");
        }
    }

    public void input(List<Integer> randomList, List<Integer> inputList) {

        if (inputList.size() != randomList.size()) {
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
