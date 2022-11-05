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


    // 사용자가 입력한 3개의 수의 예외사항을 판단한다.

    // 힌트를 판단한다.

    // 컴퓨터가 힌트를 화면에 출력한다.

    // 재시작 여부를 사용자에게 입력받는다.

    // 재시작을 판단한다.
}
