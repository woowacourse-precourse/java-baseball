package baseball.domain;

import baseball.checker.CommandChecker;
import baseball.checker.GuessChecker;
import baseball.view.Printer;
import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {

    private static final int RESTART = 1;

    private final Computer computer;

    public BaseBallGame() {
        this.computer = new Computer();
    }

    public void start() {
        Printer.printGameStart();
        do {
            init();
            play();
        } while (getRestartCommand() == RESTART);
    }

    private void play() {
        int result;
        do {
            String userGuess = inputUserGuess();
            GuessChecker.check(userGuess);
            result = Referee.judge(userGuess, computer.getRandomNumbers());
        } while (result == Referee.CONTINUATION);
        Printer.printGameEnd();
    }

    private void init() {
        computer.generateUniqueRandomNumbers();
    }

    private String inputUserGuess() {
        Printer.printInputNumber();
        return Console.readLine();
    }

    private int getRestartCommand() {
        Printer.printGameRestart();
        String commandInput = Console.readLine();
        CommandChecker.check(commandInput);
        return Integer.parseInt(commandInput);
    }
}
