package baseball;

import baseball.game.NumberBaseballGame;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final int RESTART_INPUT = 1;
    private static final int TERMINATE_INPUT = 2;

    public static void main(String[] args) {
        NumberBaseballGame.powerOn();
        do {
            NumberBaseballGame.start();
        } while (isRestartingGame());
        NumberBaseballGame.powerOff();
    }

    protected static boolean isRestartingGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int playerInput = Integer.parseInt(Console.readLine());
        if (playerInput != RESTART_INPUT && playerInput != TERMINATE_INPUT) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
        return playerInput == RESTART_INPUT;
    }
}
