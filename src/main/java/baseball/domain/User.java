package baseball.domain;

import java.util.List;

public class User {

    private static final int USER_NUMBER_SIZE = 3;

    private final List<Integer> userNumberList;

    // 일급컬렉션 유저넘버
    public User(List<Integer> userNumberList) {
        /*
        * 예외처리 할 내용 넣기
        * */
        this.userNumberList = userNumberList;
    }

    private void validateSize(List<Integer> userNumber) {
        if (userNumber.size() != USER_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
