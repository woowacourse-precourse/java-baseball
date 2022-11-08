package baseball;

import baseball.player.Computer;
import baseball.player.User;

public class Play {

    User user;
    Computer computer;
    Hint hint;

    public Play(User user, Computer computer, Hint hint) {
        this.user = user;
        this.computer = computer;
        this.hint = hint;
    }
    
}
