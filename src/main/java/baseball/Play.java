package baseball;

import static baseball.Constant.ASK_RESTART_MSG;
import static baseball.Constant.ERR_MSG;
import static baseball.Constant.EXIT;
import static baseball.Constant.GAME_START_MSG;
import static baseball.Constant.RESTART;

import baseball.player.Computer;
import baseball.player.User;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Play {

    User user;
    Computer computer;
    Hint hint;

    public Play(User user, Computer computer, Hint hint) {
        this.user = user;
        this.computer = computer;
        this.hint = hint;
    }

    public void run() {
        System.out.println(GAME_START_MSG);
        do {
            List<Integer> computerNumber = computer.getNumber();
            playGame(computerNumber);
        } while (isRestart());
    }

    public void playGame(List<Integer> computerNumber) {
        do {
            hint.initHint();
            List<Integer> userNumber = user.getNumber();
            hint.giveHint(computerNumber, userNumber);
            System.out.println(hint.printHint());
        } while (!hint.isThreeStrike());
    }

    public boolean isRestart() {
        System.out.println(ASK_RESTART_MSG);
        String answer = Console.readLine();
        if (answer.equals(RESTART)) {
            return true;
        } else if (answer.equals(EXIT)) {
            return false;
        } else {
            throw new IllegalArgumentException(ERR_MSG);
        }
    }
}
