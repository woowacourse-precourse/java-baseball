package baseball.game;

import java.util.List;

import static baseball.view.Print.*;
import static baseball.util.NumberUtil.*;

public class BaseBall {
    private Balls answerBalls;
    private Balls userBalls;

    public void start() {
        printGameStart();

        boolean check = true;
        while (check) {
            createAnswerBalls();

        }
    }

    public void createAnswerBalls() {
        answerBalls = new Balls(List.of());
        answerBalls.setNumberList(createRandomNumber());
    }

    public void inputUserBalls() {
        userBalls = new Balls(List.of());
        userBalls.setNumberList(getUserNumber());
    }

    // 힌트를 출력하고 판단한다.
    public boolean printHint() {
        return isCorrect(answerBalls.getNumberList(), userBalls.getNumberList());
    }

    // 재시작 여부를 사용자에게 입력받는다.
}
