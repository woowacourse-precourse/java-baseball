package baseball.game;

import baseball.domain.Computer;
import baseball.domain.User;

import java.util.List;

import static baseball.util.Constant.*;

public class Controller {
    private final View view;
    private final Service service;
    private final Computer computer;
    private final User user;

    public Controller() {
        view = new View();
        service = new Service();
        computer = new Computer();
        user = new User();

        view.show(GAME_START_MESSAGE);
    }

    public void run() {
        computer.generateNumbers();
        play();
        if (restart()) {
            run();
        }
    }

    private void play() {
        view.show(USER_NUMBER_INPUT_MESSAGE);
        user.generateNumbers(view.input());

        List<Integer> hint = service.calculateHint(user.getNumbers(), computer.getNumbers());
        view.show(service.hintToString(hint));

        if (!hint.equals(THREE_STRIKE)) {
            play();
        }
    }

    private boolean restart() {
        view.show(THREE_STRIKE_MESSAGE);
        view.show(GAME_RESTART_OR_TERMINATE_MESSAGE);
        return user.generateRestart(view.input()) == GAME_RESTART_VALUE;
    }
}
