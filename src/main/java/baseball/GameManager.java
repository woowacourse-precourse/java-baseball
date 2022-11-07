package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.Number.generateRandomNumber;
import static baseball.Player.guessAnswer;

public class GameManager {
    private static final int RESTART_INPUT = 1;
    private static final int END_INPUT = 2;

    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (startRound()) {
        }
    }

    public static boolean startRound() {
        int opponentNum = generateRandomNumber();

        while (guessAnswer(opponentNum)) {
        }

        boolean shouldRestartGame = endRound();

        return shouldRestartGame;
    }

    public static boolean endRound() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

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
}
