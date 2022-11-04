package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {

    private final Computer computer;

    public BaseBallGame(Computer computer) {
        this.computer = computer;
    }

    public void start() {
        Printer.gameStartMessage();
        init();
        play();
    }

    private void play() {
        String userGuess = inputUserGuess();
    }

    private void init() {
        computer.generateUniqueRandomNumbers();
    }

    private String inputUserGuess() {
        Printer.gameInputMessage();
        return Console.readLine();
    }
}
