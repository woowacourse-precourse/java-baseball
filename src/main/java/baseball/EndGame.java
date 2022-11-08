package baseball;

import camp.nextstep.edu.missionutils.Console;

public class EndGame {
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String RESTART = "1";
    private static final String GAME_OVER = "2";

    public static void askRestart() {
        System.out.println(END_MESSAGE);
        System.out.println(RESTART_MESSAGE);
        String action = Console.readLine();
        validateAction(action);
    }

    public static void validateAction(String action) {
        if (action.equals(RESTART)) {
            System.out.println(RESTART);
            Game.run();
        }
        if (action.equals(GAME_OVER)) {
            // 게임 종료
            System.out.println(GAME_OVER);
        }
        if (!action.equals(RESTART) && !action.equals(GAME_OVER)) {
            throw new IllegalArgumentException("Enter 1 to re-start, or 2 to quit.");
        }
    }
}
