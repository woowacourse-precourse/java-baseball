package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserNumber {

    private static final int USER_INPUT_LENGTH = 3;

    public void getUserNumber() {
        String tempNumber = Console.readLine();
        userNumberValidator(tempNumber);
    }

    private void userNumberValidator(String tempNumber) {
        List<Character> numberList = tempNumber.chars()
                .mapToObj(e->(char)e).collect(Collectors.toList());
        checkUserInputLength(numberList);
        checkInputIsNumber(numberList);
    }

    private void checkInputIsNumber(List<Character> numberList) {
        for (int i = 0; i < USER_INPUT_LENGTH; i++) {
            if (!Character.isDigit(numberList.get(i)) || numberList.get(i) == '0') {
                throw new IllegalArgumentException("입력값 사이에 1부터 9사이의 숫자가 아닌 문자가 존재합니다.");
            }
        }
    }

    private void checkUserInputLength(List<Character> numberList) {
        if (numberList.size() != USER_INPUT_LENGTH) {
            throw new IllegalArgumentException("입력값의 길이가 3이 아닙니다.");
        }
    }

}
