package baseball.game;

import java.util.List;

import static baseball.view.BaseBallView.*;
import static baseball.util.NumberUtil.*;

public class BaseBall {
    private Balls answerBalls = new Balls(List.of());
    private Balls userBalls = new Balls(List.of());

    public void start() {
        printGameStart();

        boolean answer = true;
        while (answer) {
            createAnswerBalls();
            answer = playerAction();
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

    public boolean printHint() {
        return isCorrect(answerBalls.getNumberList(), userBalls.getNumberList());
    }

    public boolean restart() {
        return isRestart();
    }

    public boolean playerAction() {
        boolean answer = true;
        while (answer == true) {
            inputUserBalls();
            answer = !printHint();
        }

        return restart();
    }

}
