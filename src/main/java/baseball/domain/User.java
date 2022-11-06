package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Integer> userGameNumbers = new ArrayList<>();

    public User() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public List<Integer> getUserGameNumbers() {
        return userGameNumbers;
    }

    public void setUserGameNumbers(List<Integer> userGameNumbers) {
        this.userGameNumbers = userGameNumbers;
    }
}
