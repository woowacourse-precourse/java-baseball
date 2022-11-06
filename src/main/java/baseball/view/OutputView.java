package baseball.view;

import baseball.domain.BaseballGameResult;

public enum OutputView {
    INSTANCE;

    private final static String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final static String END_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printGameStart() {
        System.out.println(START_GAME_MESSAGE);
    }

    public void printGameEnd() {
        System.out.println(END_GAME_MESSAGE);
    }

    public void printGameResult(BaseballGameResult baseballGameResult) {
        System.out.println(baseballGameResult);
    }
}
