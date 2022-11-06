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
        List<Integer> computerNumbers = RandomThreeDigitNumberGenerator.generate();
        while (strike != THREE) {
            System.out.print(INPUT_PLAYER_NUMBER);
            List<Integer> playerNumbers = BaseballGameService.getPlayer().getNumbers();
            BallAndStrike ballAndStrike = BallAndStrike.from(computerNumbers, playerNumbers);
            strike = ballAndStrike.getStrike();
            System.out.println(ballAndStrike);
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
