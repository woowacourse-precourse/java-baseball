package baseball;

import baseball.player.Computer;
import baseball.player.User;
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

    public void playGame(List<Integer> computerNumber) {
        do {
            hint.initHint();
            List<Integer> userNumber = user.getNumber();
            hint.giveHint(computerNumber, userNumber);
            System.out.println(hint.printHint());
        } while (!hint.isThreeStrike());
    }
}
