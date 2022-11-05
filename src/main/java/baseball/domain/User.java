package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class User {

    private static final int USER_NUMBER_SIZE = 3;

    private final List<Integer> userNumberList;

    // 일급컬렉션 유저넘버
    public User(String inputUserNumber) {
        List<Integer> userNumberList = stringToUserNumberList(inputUserNumber);
        validateSize(userNumberList);
        this.userNumberList = userNumberList;
    }

    // 플레이어가 입력한 값을 일급컬렉션으로 초기화
    private List<Integer> stringToUserNumberList(String inputUserNumber) {
        List<Integer> userNumberList = new ArrayList<>();
        for (char c : inputUserNumber.toCharArray()) {
            validateCharacter(c);
            userNumberList.add(Integer.parseInt(String.valueOf(c)));
        }
        return userNumberList;
    }

    // 유저의 입력값이 숫자가 아닐경우 예외처리
    private void validateCharacter(char digit) {
        if (!Character.isDigit(digit)) {
            throw new IllegalArgumentException();
        }
    }

    // 유저의 입력값이 3자리가 아닐경우 예외처리
    private void validateSize(List<Integer> userNumber) {
        if (userNumber.size() != USER_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
