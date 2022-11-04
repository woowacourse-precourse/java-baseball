package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGameLauncher {

    public final static String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public final static String RESTART_GAME = "1";
    public final static String CLOSE_GAME = "2";

    private BaseballGame baseballGame;
    
    public void run() {
        System.out.println(GAME_START_MESSAGE);
        baseballGame = new BaseballGame();
        do {
            baseballGame.start();
        } while (isRestartGame());
        System.out.println("게임을 완전히 종료합니다.");
    }

    private boolean isRestartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = Console.readLine();

        if (input.equals(RESTART_GAME)) {
            return true;
        }

        if (input.equals(CLOSE_GAME)) {
            return false;
        }

        System.out.println("올바른 값을 입력해주세요");
        return isRestartGame();
    }
}
