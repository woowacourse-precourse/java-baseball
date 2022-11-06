package baseball;

import static baseball.ContinueOrBreak.*;
import static baseball.utils.Constants.*;

import java.util.List;

public class BaseballGame implements Game {

    @Override
    public void intro() {
        System.out.println(INTRO);
    }

    @Override
    public void run() {
        int strike = 0;
        int ball;
        List<Integer> computerNumbers = RandomThreeDigitNumberGenerator.generate();
        while (strike != RANDOM_NUMBER_LENGTH) {
            System.out.print(INPUT_PLAYER_NUMBER);
            List<Integer> playerNumbers = BaseballGameService.getPlayer().getNumbers();
            List<Integer> ballAndStrike = ResultCalculator.calculateBallAndStrike(computerNumbers, playerNumbers);
            ball = ballAndStrike.get(0);
            strike = ballAndStrike.get(1);
            System.out.println(ball + BALL + SPACE + strike + STRIKE);
        }
    }

    @Override
    public void outro() {
        System.out.println(OUTRO);
        System.out.println(CONTINUE_OR_END);
        if (BaseballGameService.getContinueOrBreak() == CONTINUE) {
            replay();
        }
    }
}
