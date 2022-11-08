package baseball.view;

import baseball.domain.Hint;

public class OutputView {
    public static void printHint(Hint hint) {
        int strike = hint.getStrike();
        int ball = hint.getBall();

        if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
            return;
        }

        if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
            return;
        }

        if (strike != 0) {
            System.out.println(strike + "스트라이크");
            return;
        }
        System.out.println("낫싱");
    }

    public static void printAnswerMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printRetryOrExitMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
