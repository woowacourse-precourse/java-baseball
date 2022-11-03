package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserNumber {

    public void getUserNumber() {
        String tempNumber = Console.readLine();
        userNumberValidator(tempNumber);
    }

    private void userNumberValidator(String tempNumber) {
        List<Character> numberList = tempNumber.chars()
                .mapToObj(e->(char)e).collect(Collectors.toList());
        if (numberList.size() != 3) {
            throw new IllegalArgumentException("입력값의 길이가 3이 아닙니다.");
        }
    }

}
