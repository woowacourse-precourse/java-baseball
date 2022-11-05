package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserNumber {

    private static final int USER_INPUT_LENGTH = 3;
    private List<Character> numberList;

    public UserNumber() {
    }

    public UserNumber(String userInput) {
        List<Character> tempNumberList = userInput.chars()
                .mapToObj(e -> (char) e).collect(Collectors.toList());
        userNumberValidator(tempNumberList);
        this.numberList = tempNumberList;
    }

    private void userNumberValidator(List<Character> numberList) {
        checkUserInputLength(numberList);
        checkInputIsNumber(numberList);
        checkDuplicateValue(numberList);
    }

    private void checkDuplicateValue(List<Character> numberList) {
        if (numberList.get(0) == numberList.get(1) || numberList.get(1) == numberList.get(2) || numberList.get(2) == numberList.get(0)) {
            throw new IllegalArgumentException("입력값 사이에 중복된 값이 존재합니다.");
        }
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

    public List<Character> getNumberList() {
        return numberList;
    }

}
