package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {

    private static final int RESTART = 1;

    private final Computer computer;

    public BaseBallGame(Computer computer) {
        this.computer = computer;
    }

    public void start() {
        Printer.printGameStart();
        do {
            init();
            play();
        } while (inputRestartCommand() == RESTART);
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

    private int inputRestartCommand() {
        Printer.printGameRestart();
        String commandInput = Console.readLine();
        return Integer.parseInt(commandInput);
    }
}
