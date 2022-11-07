package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final int RESTART_GAME = 1;
    private static final int STOP_PROGRAM = 2;
    private static final int STOP_GAME = 3;
    private static int gameExecution = 0;

    public static void main(String[] args) {
        ResponseMessage.startGame();
        Number computer = new Number();

        while (gameExecution != STOP_PROGRAM) {
            int strikeNumber = playGame(computer);
            stopGame(strikeNumber);
            stopProgram();
            computer = restartGame(computer);
        }
    }

    private static int playGame(Number computer) {
        ResponseMessage.inputNumber();
        Number user = new Number(Console.readLine());
        Exception.handleException(user.getUserNumbers());

        Baseball baseball = new Baseball(computer.getComputers(), user.getUserNumbers());
        System.out.println(baseball.getScore());

        return baseball.getStrike();
    }

    private static void stopGame(int strikeNumber) {
        if (strikeNumber == STOP_GAME) {
            ResponseMessage.allStrike();
            checkExecution();
        }
    }

    private static void checkExecution() {
        gameExecution = Integer.parseInt(Console.readLine());
        Exception.isInvalidInput(gameExecution);
    }

    private static Number restartGame(Number computer) {
        if (gameExecution == RESTART_GAME) {
            gameExecution = 0;
            return new Number();
        }
        return computer;
    }

    private static void stopProgram() {
        if (gameExecution == STOP_PROGRAM) {
            ResponseMessage.stopProgram();
        }
    }
}
