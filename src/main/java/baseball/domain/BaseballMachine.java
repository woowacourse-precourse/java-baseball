package baseball.domain;

import baseball.util.Input;

public class BaseballMachine {

    private Computer computer;
    private Input input;
    private User user;
    private StrikeModel strikeModel;

    public void prepareGame() {
        this.computer = new Computer();
        this.input = new Input();
    }

    public void matchNumber() {
        createUserNumber();
        this.strikeModel = new StrikeModel(user.getUserNumberList(), computer.getComputerNumberList());
    }

    // 입력한 값을 정답과 비교하여 boolean값 반환하는 기능
    public boolean checkAnswer() {
        int[] answer = strikeModel.getBallAndStrike();
        if (answer[1] == 3) {
            return true;
        }
        return false;
    }

    // 유저 일급컬렉션 생성
    private void createUserNumber() {
        this.user = new User(input.inputUserNumber());
    }

}
