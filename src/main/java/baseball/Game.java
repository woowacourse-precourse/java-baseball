package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private Computer computer;

    private void start() {
        computer = new Computer();
        play();
    }

    private void play() {
        while (true) {
            final String playerInput = Console.readLine();
        }
    }
}
