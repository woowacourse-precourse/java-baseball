package baseball.game.baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

public class BaseBallGameRunner implements GameRunner {

    private final String RESTART = "1";
    private final String END = "2";

    public BaseBallGameRunner() {
    }

    public void run() {
        do {
            GameService game = new BaseBallGameService();
            game.execute();
        } while (isContinue());
    }

    private boolean isContinue() {
        String input = Console.readLine();
        if (Objects.equals(input, RESTART)) return true;
        if (Objects.equals(input, END)) return false;
        throw new IllegalArgumentException();
    }
}
