package baseball;

import static baseball.ContinueOrBreak.*;
import static baseball.utils.Constants.*;
import static baseball.utils.Printer.*;

import java.util.List;

public class BaseballGame implements Game {

    @Override
    public void intro() {
        println(INTRO);
    }

    @Override
    public void run() {
        int strike = 0;
        List<Integer> computerNumbers = RandomThreeDigitNumberGenerator.generate();
        while (strike != THREE) {
            print(INPUT_PLAYER_NUMBER);
            List<Integer> playerNumbers = BaseballGameService.getPlayer().getNumbers();
            BallAndStrike ballAndStrike = BallAndStrike.from(computerNumbers, playerNumbers);
            strike = ballAndStrike.getStrike();
            println(ballAndStrike);
        }
    }

    @Override
    public void outro() {
        println(OUTRO);
        println(CONTINUE_OR_BREAK);
        if (BaseballGameService.getContinueOrBreak() == CONTINUE) {
            replay();
        }
    }
}
