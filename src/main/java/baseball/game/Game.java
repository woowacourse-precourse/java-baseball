package baseball.game;

import camp.nextstep.edu.missionutils.Console;

import static baseball.game.Const.*;

public class Game {
    private final User user;
    private final Computer computer;

    private Game(Computer computer, User user) {
        this.computer = computer;
        this.user = user;
    }

    public static Game create(Computer computer, User user) {
        return new Game(computer, user);
    }

    public void start() {
        System.out.println(GAME_START_MESSAGE);
        init();
        loop();
    }

    private void init() {
        computer.generateNumbers();
        user.setNumbers(receiveInput(GAME_INPUT_WAIT_MESSAGE));
    }

    private String receiveInput(String message) {
        System.out.print(message);
        return Console.readLine();
    }

    private void loop() {
        while (true) {
            if (isGameOver()) {
                return;
            }
            user.setNumbers(receiveInput(GAME_INPUT_WAIT_MESSAGE));
        }
    }

    private boolean isGameOver() {
        Score score = Score.calculate(computer.getNumbers(), user.getNumbers());
        if (score.isWin()) {
            System.out.println(GAME_WIN_MESSAGE);
            Flag flag = restartOrExit();
            return flag.isExit();
        }
        return false;
    }

    private Flag restartOrExit() {
        String input = receiveInput(GAME_RESTART_MESSAGE);
        if (input.equals("1")) {
            computer.generateNumbers();
            return Flag.RESTART;
        }
        if (input.equals("2")) {
            return Flag.EXIT;
        }
        throw new IllegalArgumentException(GAME_EXCEPTION_RESTART_MESSAGE);
    }

    private enum Flag {
        RESTART(false), EXIT(true);

        private final boolean exit;

        Flag(boolean exit) {
            this.exit = exit;
        }

        public boolean isExit() {
            return exit;
        }
    }
}
