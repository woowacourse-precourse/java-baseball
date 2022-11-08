package baseball;

import static baseball.Number.generateRandomNumber;
import static baseball.Player.guessAnswer;

import camp.nextstep.edu.missionutils.Console;

public class GameManager {
    private static final int RESTART_INPUT = 1;
    private static final int END_INPUT = 2;

    public static void startGame() {
        printStartingMessage();

        while (restartGame()) {
        }
    }

    public static boolean restartGame() {
        startOneGame();

        boolean shouldRestartGame = decideWhetherRestartGame();

        return shouldRestartGame;
    }

    public static boolean decideWhetherRestartGame() {
        printEndingMessage();

        int inputNum;
        try {
            inputNum = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (!(inputNum == RESTART_INPUT || inputNum == END_INPUT)) {
            throw new IllegalArgumentException();
        }

        if (inputNum == RESTART_INPUT) {
            return true;
        }
        return false;
    }

    private static void startOneGame() {
        int opponentNum = generateRandomNumber();

        while (guessAnswer(opponentNum)) {
        }
    }

    private static void printStartingMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static void printEndingMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
