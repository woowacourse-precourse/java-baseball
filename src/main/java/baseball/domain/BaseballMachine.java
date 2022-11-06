package baseball.domain;

import baseball.util.Input;

public class BaseballMachine {

    private Computer computer;
    private Input input;
    private User user;

    public BaseballMachine() {
        this.computer = new Computer();
        this.input = new Input();
    }

    public void progressGame() {
        createUserNumber();
        user.getUserNumberList();
    }

    // 유저 일급컬렉션 생성
    private void createUserNumber() {
        this.user = new User(input.inputUserNumber());
    }

}
