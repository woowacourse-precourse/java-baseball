package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {

    private final Computer computer;

    public BaseBallGame(Computer computer) {
        this.computer = computer;
    }

    public void start() {
        Printer.printGameStart();
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
        Printer.printGameEnd();
        Printer.printGameRestart();
    }

    private void init() {
        computer.generateUniqueRandomNumbers();
    }

    private String inputUserGuess() {
        Printer.printInputNumber();
        return Console.readLine();
    }
}
