package baseball.domain;

import baseball.util.Input;

import java.util.ArrayList;
import java.util.List;

public class StrikeCounter {

    private Computer computer;
    private Input input;
    private User user;

    public StrikeCounter() {
        this.computer = new Computer();
        this.input = new Input();
    }

    // 플레이어가 입력한 값을 일급컬렉션으로 초기화
    private List<Integer> stringToUserNumberList(String inputUserNumber) {
        List<Integer> userNumberList = new ArrayList<>();
        for (char c : inputUserNumber.toCharArray()) {
            userNumberList.add(Integer.parseInt(String.valueOf(c)));
        }
        return userNumberList;
    }
}
