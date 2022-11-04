package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGameLauncher {

    public final static String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public final static String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public final static String GAME_CLOSE_MESSAGE = "게임을 완전히 종료합니다.";
    public final static String INVALID_VALUE_MESSAGE = "올바른 값을 입력해주세요";

    public final static String RESTART_GAME = "1";
    public final static String CLOSE_GAME = "2";

    public void run() {
        System.out.println(GAME_START_MESSAGE);
        BaseballGame baseballGame = new BaseballGame();
        do {
            baseballGame.start();
        } while (isRestartGame());
        System.out.println(GAME_CLOSE_MESSAGE);
    }

    private boolean isRestartGame() {
        System.out.println(GAME_RESTART_MESSAGE);

        String input = Console.readLine();

        if (input.equals(RESTART_GAME)) {
            return true;
        }

        if (input.equals(CLOSE_GAME)) {
            return false;
        }

        System.out.println(INVALID_VALUE_MESSAGE);
        return isRestartGame();
    }
}
