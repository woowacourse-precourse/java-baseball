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

    public void progressGame() {
        createUserNumber();
    }

    // 유저 일급컬렉션 생성
    private void createUserNumber() {
        this.user = new User(input.inputUserNumber());
    }

}
