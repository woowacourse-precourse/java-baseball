package baseball.domain;

import baseball.util.Input;
import static baseball.message.GameMessage.*;

public class BaseballMachine {

    private Computer computer;
    private User user;
    private StrikeModel strikeModel;

    public void prepareGame() {
        this.computer = new Computer();
    }

    public void matchNumber() {
        createUserNumber();
        this.strikeModel = new StrikeModel(user.getUserNumberList(), computer.getComputerNumberList());
    }

    // 스트라이크가 3개일경우 정답 반환
    public boolean checkAnswer() {
        return strikeModel.getStrike() == 3;
    }

    // 볼 스트라이크에 따라 구분하여 힌트 문자열 반환
    public String getHint() {
        int ball = strikeModel.getBall();
        int strike = strikeModel.getStrike();
        if (ball > 0 && strike > 0) {
            return ballAndStrikeMessage(ball, strike);
        }
        if (ball > 0 && strike == 0) {
            return ballMessage(ball);
        }
        if (ball == 0 && strike > 0) {
            return strikeMessage(strike);
        }
        return nothingMessage();
    }

    // 유저 일급컬렉션 생성
    private void createUserNumber() {
        this.user = new User(Input.inputUserNumber());
    }

}
