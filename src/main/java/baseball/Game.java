package baseball;

import baseball.model.Ball;
import baseball.utils.InputNumberUtil;
import baseball.utils.RandomNumberGeneratorUtil;
import baseball.utils.StrikeBallUtil;

import java.util.List;

import static baseball.constant.BaseballConstant.GAME_FINISH;
import static baseball.constant.BaseballConstant.INPUT_NUMBER;
import static baseball.constant.BaseballConstant.RESTART_GAME;

public class Game {

    public int play() {

        int restart = 1;

        List<Integer> computer = RandomNumberGeneratorUtil.makesDifferenceThreeNumber();

        while (true) {
            System.out.print(INPUT_NUMBER);

            String user = InputNumberUtil.inputNumber();

            Ball ball = StrikeBallUtil.findStrikeAndBall(user, computer);

            StrikeBallUtil.printStrikeAndBall(ball);

            if (isCorrectAllNumber(ball)) {
                System.out.println(GAME_FINISH);
                System.out.println(RESTART_GAME);
                restart = InputNumberUtil.getRestartNumber();
                break;
            }
        }

        return restart;

    }


    public boolean isCorrectAllNumber(Ball ball) {
        return ball.getStrike() == 3;
    }

}
