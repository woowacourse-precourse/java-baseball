package baseball.domain;

import java.util.List;

import static baseball.message.BaseballMessage.*;

public class BaseballCount {

    private final int NUMBER_LIST_SIZE = 3;
    private Computer computer;
    private List<Integer> userInputList;
    private User user;

    public BaseballCount() {
        this.computer = new Computer();
        this.user = new User();
    }

    // 게임 진행 기능
    public void playGame() {
        this.userInputList = user.getUserNumberList();
    }

    // 힌트 메세지 출력 기능
    public String displayHint() {
        return combineMessage(getBall(), getStrike());
    }

    // 정답확인 기능
    public boolean isCorrect() {
        return getStrike() == 3;
    }

    // 볼과 스트라이크 갯수에 따른 메세지 결합 기능
    private String combineMessage(int ball, int strike) {
        BaseballStatusName status = judgeNumberStatus(ball, strike);
        switch (status) {
            case STRIKE_AND_BALL:
                return String.format(STRIKE_AND_BALL_MESSAGE, ball, strike);
            case BALL:
                return String.format(BALL_MESSAGE, ball);
            case STRIKE:
                return String.format(STRIKE_MESSAGE, strike);
        }
        return NOTHING_MESSAGE;
    }

    // 숫자가 어떤 형태에 해당하는지 형태를 판단하는 기능
    private BaseballStatusName judgeNumberStatus(int ball, int strike) {
        if (ball > 0 && strike > 0) {
            return BaseballStatusName.STRIKE_AND_BALL;
        }
        if (ball > 0 && strike == 0) {
            return BaseballStatusName.BALL;
        }
        if (ball == 0 && strike > 0) {
            return BaseballStatusName.STRIKE;
        }
        return BaseballStatusName.NOTHING;
    }


    // 볼 값 반환 기능
    private int getBall() {
        int ballCount = 0;
        for (int i : userInputList) {
            if (computer.getComputerList().contains(i)) {
                ballCount += 1;
            }
        }
        return ballCount - getStrike();
    }

    // 스트라이크 값 반환 기능
    private int getStrike() {
        int strikeCount = 0;
        for (int i = 0; i < NUMBER_LIST_SIZE; i++) {
            if (isSameDigit(i)) {
                strikeCount += 1;
            }
        }
        return strikeCount;
    }

    // 컴퓨터 난수와 유저 input값을 자릿수별 비교 기능
    private boolean isSameDigit(int index) {
        return userInputList.get(index) == computer.getComputerList().get(index);
    }
}
