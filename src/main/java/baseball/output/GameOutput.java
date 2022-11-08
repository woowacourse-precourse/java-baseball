package baseball.output;

import baseball.domain.GameResult;

public abstract class GameOutput {

    private static String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static String INPUT_USER_NUMBER_MESSAGE = "숫자를 입력해 주세요 : ";
    private static String GAME_CLEAR_MESSAGE = "3개의 숫자를 모두 맞히셨습니다!\n게임 종료";
    private static String RESTART_QUESTION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static String NOTHING = "낫싱";

    public static void startMessageOutput() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void inputUserNumberMessageOutput() {
        System.out.print(INPUT_USER_NUMBER_MESSAGE);
    }

    public static void gameClearMessageOutput() {
        System.out.println(GAME_CLEAR_MESSAGE);
    }

    public static void restartQuestionMessageOutput() {
        System.out.println(RESTART_QUESTION_MESSAGE);
    }

    public static String makeGameResult(GameResult gameResult) {
        String output = "";
        if (gameResult.getStrike() == 0 && gameResult.getBall() == 0)
            return NOTHING;

        if (gameResult.getStrike() != 0)
            output = gameResult.getStrike() + "스트라이크";
        if (gameResult.getBall() > 0)
            output = gameResult.getBall() + "볼 " + output;
        return output.trim();
    }

    public static void gameResultOutput(GameResult gameResult) {
        System.out.println(makeGameResult(gameResult));
    }
}