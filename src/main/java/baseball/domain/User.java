package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private static final int USER_NUMBER_SIZE = 3;

    private final List<Integer> userNumberList;

    // 일급컬렉션 유저넘버
    public User(String inputUserNumber) {
        List<Integer> userNumberList = stringToUserNumberList(inputUserNumber);
        this.userNumberList = userNumberList;
    }

    // 플레이어가 입력한 값을 일급컬렉션으로 초기화
    private List<Integer> stringToUserNumberList(String inputUserNumber) {
        List<Integer> userNumberList = new ArrayList<>();
        for (char c : inputUserNumber.toCharArray()) {
            userNumberList.add(Integer.parseInt(String.valueOf(c)));
        }
        return userNumberList;
    }

    private void validateSize(List<Integer> userNumber) {
        if (userNumber.size() != USER_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
