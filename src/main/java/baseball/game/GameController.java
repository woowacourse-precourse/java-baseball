package baseball.game;

import baseball.computer.Computer;
import baseball.user.User;
import camp.nextstep.edu.missionutils.Console;

import static baseball.game.GameConst.*;
import static baseball.RuleConst.*;

public class GameController {
    private final Computer computer;
    private final User user;

    public GameController() {
        computer = new Computer();
        user = new User();
    }

    private void ready() {
        computer.generateNumber();
        user.generateNumber();
    }

    private boolean isStrike(int index) {
        return computer.getNumbers().get(index)
                .equals(user.getNumbers().get(index));
    }

    private boolean isBall(int index) {
        if (computer.getNumbers().contains(user.getNumbers().get(index))) {
            return !isStrike(index);
        }
        return false;
    }

    private String generateOutput(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return NOTHING;
        } else if (strike == 0 && ball != 0) {
            return ball + BALL;
        } else if (strike != 0 && ball == 0) {
            return strike + STRIKE;
        } else {
            return ball + BALL + " " + strike + STRIKE;
        }
    }

    private boolean judge() {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (isStrike(i)) {
                strike++;
            } else if (isBall(i)) {
                ball++;
            }
        }

        System.out.println(generateOutput(strike, ball));

        return (strike == THREE_STRIKE);
    }

    public void play() {
        System.out.println(GAME_START_MESSAGE);

        int exit = 0;
        while (exit != EXIT_CODE) {
            ready();
            while (!judge()) {
                user.generateNumber();
            }
            System.out.println(GAME_END_MESSAGE);
            System.out.println(RETRY_EXIT_MESSAGE);
            exit = Integer.parseInt(Console.readLine());
        }
    }
}
