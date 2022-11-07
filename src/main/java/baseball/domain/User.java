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
        validateDuplication(userNumberList);
        validateNumber(userNumberList);
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

    // 유저의 입력값이 중복되는 숫자가 있을경우 예외처리
    private void validateDuplication(List<Integer> userNumber) {
        HashSet<Integer> set = new HashSet<>(userNumber);
        if (set.size() != USER_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    // 유저의 입력값 중 0이 들어가있으면 예외처리
    private void validateNumber(List<Integer> userNumber) {
        long zeroCount = userNumber.stream()
                .filter(digit -> digit == 0)
                .count();
        if (zeroCount > 0) {
            throw new IllegalArgumentException();
        }
    }

    // 유저숫자목록 가져오기
    public List<Integer> getUserNumberList() {
        return userNumberList;
    }
}
