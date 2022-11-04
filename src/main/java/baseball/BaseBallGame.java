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
        int result;
        do {
            String userGuess = inputUserGuess();
            GuessChecker.check(userGuess);
            result = Referee.judge(userGuess, computer.getRandomNumbers());
        } while (result == Referee.CONTINUATION);
    }

    private void init() {
        computer.generateUniqueRandomNumbers();
    }

    private String inputUserGuess() {
        Printer.gameInputMessage();
        return Console.readLine();
    }
}
