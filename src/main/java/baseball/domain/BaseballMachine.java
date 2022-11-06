package baseball.domain;

import baseball.util.Input;
import static baseball.message.GameMessage.*;

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
        if (classify(strikeModel.getBall(), strikeModel.getStrike())) {
            return true;
        }
        return false;
    }

    // 볼 스트라이크에 따라 구분하여 힌트 메세지 출력
    private boolean classify(int ball, int strike) {
        if (ball > 0 && strike > 0) {
            System.out.println(ballAndStrikeMessage(ball, strike));
            return false;
        }
        if (ball > 0 && strike == 0) {
            System.out.println(ballMessage(ball));
            return false;
        }
        if (ball == 0 && strike > 0) {
            System.out.println(strikeMessage(strike));
            if (strike == 3) {
                return true;
            }
            return false;
        }
        System.out.println(nothingMessage());
        return false;
    }

    // 유저 일급컬렉션 생성
    private void createUserNumber() {
        this.user = new User(input.inputUserNumber());
    }

}
