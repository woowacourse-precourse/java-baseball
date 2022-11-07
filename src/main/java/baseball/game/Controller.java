package baseball.game;

import baseball.domain.User;
import baseball.domain.Computer;

import java.util.List;

import static baseball.game.View.show;
import static baseball.util.Constant.*;

public class Controller {
    private final Computer computer;
    private final User user;

    public Controller() {
        computer = new Computer();
        user = new User();
        show(GAME_START_MESSAGE);
    }

    public void run() {
        computer.generateNumbers();
        play();
        if (restart()) {
            run();
        }
    }

    private void play() {
        show(USER_NUMBER_INPUT_MESSAGE);
        user.generateNumbers();

        List<Integer> hint = Service.countHint(user.getNumbers(), computer.getNumbers());
        show(Service.printHint(hint));

        if (!Service.isThreeStrike(hint)) {
            play();
        }
    }

    private boolean restart() {
        show(THREE_STRIKE_MESSAGE);
        show(GAME_RESTART_OR_TERMINATE_MESSAGE);
        return user.inputRestart() == GAME_RESTART_VALUE;
    }
}
