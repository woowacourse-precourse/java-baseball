package baseball.view;

import baseball.model.GameResult;

public class OutputView {

    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String REQUEST_NUM = "숫자를 입력해주세요 : ";
    private static final String REQUEST_RE_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void printRequestNum() {
        System.out.print(REQUEST_NUM);
    }

    public static void printGameStart() {
        System.out.println(GAME_START);
    }

    public static void printGameResult(GameResult gameResult) {
        System.out.println(gameResult);
    }

    public static void printRequestReGame() {
        System.out.println(REQUEST_RE_GAME);
    }
}
