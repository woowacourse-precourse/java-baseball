package baseball.view;

import baseball.dto.Result;

import static baseball.Const.THREE_STRIKE;

public class PrintGameResult {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";

    public void startGame() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void result(Result result) {
        int strike = result.getStrike();
        int ball = result.getBall();

        isNothing(strike, ball);
        isThreeStrike(strike);
        isOnlyStrike(strike, ball);
        isOnlyBall(strike, ball);
        isStrikeAndBall(strike, ball);
    }

    private void restartOrQuitGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private void endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void isThreeStrike(int strike) {
        if (strike == THREE_STRIKE) {
            System.out.println(strike + STRIKE);
            endGame();
            restartOrQuitGame();
        }
    }

    private void isNothing(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println(NOTHING);
        }
    }

    private void isOnlyStrike(int strike, int ball) {
        if (strike < THREE_STRIKE && strike > 0 && ball == 0) {
            System.out.println(strike + STRIKE);
        }
    }

    private void isOnlyBall(int strike, int ball) {
        if (strike == 0 && ball != 0) {
            System.out.println(ball + BALL);
        }
    }

    private void isStrikeAndBall(int strike, int ball) {
        if (strike != 0 && ball != 0) {
            System.out.println(ball + BALL + " " + strike + STRIKE);
        }
    }
}
