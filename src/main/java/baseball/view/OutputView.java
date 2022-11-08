package baseball.view;

import baseball.model.BallStrikeResult;

public class OutputView {
    private final String START_GAME_ALERT = "숫자 야구 게임을 시작합니다.";
    private final String PUT_INPUT_ALERT = "숫자를 입력해주세요 : ";
    private final String GAME_END_ALERT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String AFTER_GAME_END_ALERT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printBallStrikeResult(BallStrikeResult result) {
        System.out.println(result.toString());
    }

    public void printStartGameAlert() {
        System.out.println(START_GAME_ALERT);
    }

    public void printAfterGameEndAlert() {
        System.out.println(AFTER_GAME_END_ALERT);
    }

    public void printGameEndAlert() {
        System.out.println(GAME_END_ALERT);
    }

    public void printInputNumberAlert() {
        System.out.print(PUT_INPUT_ALERT);
    }
}
