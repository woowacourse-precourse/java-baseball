package baseball.domain;

import baseball.exception.GameException;
import baseball.view.Instruction;
import baseball.view.Result;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    private static final int START = 1;
    private static final int THREE_STRIKE = 3;
    Result result = new Result();
    Instruction instruction = new Instruction();
    GameException gameException = new GameException();
    Comparator comparator;
    Computer computer;
    Player player;

    public void initGame() {
        instruction.printStart();
        startGame();
    }

    private void startGame() {
        setComputer();
        do {
            setPlayer();
        } while (!canSuccess());
        if (setRunCode() == START) {
            startGame();
        }
    }

    private int setRunCode() {
        instruction.printRunCode();
        String stringRunCode = inputRunCode(Console.readLine());
        return toInt(stringRunCode);
    }

    private String inputRunCode(String runCode) {
        gameException.runCodeLengthException(runCode);
        return runCode;
    }

    private int toInt(String runCode) {
        int intRunCode = Integer.parseInt(runCode);
        gameException.runCodeValidation(intRunCode);
        return intRunCode;
    }

    private void setComputer() {
        computer = new Computer();
    }

    private void setPlayer() {
        instruction.printInputData();
        player = new Player(Console.readLine());
    }

    private boolean canSuccess() {
        comparator = new Comparator(computer.getRandomNumbers(), player.getPlayerNumbers());
        int[] ballAndStrike = comparator.getResult();
        int ball = ballAndStrike[0];
        int strike = ballAndStrike[1];
        if (strike != 0) {
            if (ball != 0) {
                result.printBallAndStrike(ball, strike);
                return false;
            }
            result.printStrike(strike);
            if (strike == THREE_STRIKE) {
                result.printSuccess();
                return true;
            }
            return false;
        }
        if (ball != 0) {
            result.printBall(ball);
            return false;
        }
        result.printNothing();
        return false;
    }
}
