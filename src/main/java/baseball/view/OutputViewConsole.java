package baseball.view;

import baseball.domain.BaseballGameResult;

public class OutputViewConsole implements OutputView {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GET_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String BALL_MESSAGE = "볼 ";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String THREE_STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    @Override
    public void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    @Override
    public void printInputMessage() {
        System.out.print(GET_INPUT_MESSAGE);
    }

    @Override
    public void printRestartMessage() {
        System.out.println(RESTART_MESSAGE);
    }

    @Override
    public void print3StrikeMessage() {
        System.out.println(THREE_STRIKE_MESSAGE);
    }

    @Override
    public void printBaseballGameResult(BaseballGameResult result) {
        if (result.getBall() == 0 && result.getStrike() == 0) {
            System.out.println(NOTHING_MESSAGE);
            return;
        }
        if (result.getBall() != 0) {
            System.out.print(result.getBall() + BALL_MESSAGE);
        }
        if (result.getStrike() != 0) {
            System.out.print(result.getStrike() + STRIKE_MESSAGE);
        }
        System.out.println();
    }
}
