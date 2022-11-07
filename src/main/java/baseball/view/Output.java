package baseball.view;

import baseball.model.BallCounts;

public class Output {
    public static void outputStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void outputBallCounts(BallCounts ballCounts) {
        outputBall(ballCounts.getBall());
        outputStrike(ballCounts.getStrike());
        outputNothing(ballCounts.getIsNothing());
        System.out.println();
    }
    public static void outputRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static void outputBall(int countBall) {
        if (countBall != 0) {
            System.out.print(countBall + "볼 ");
        }
    }

    private static void outputStrike(int countStrike) {
        if (countStrike != 0) {
            System.out.print(countStrike + "스트라이크");
        }
    }

    private static void outputNothing(boolean isNothing) {
        if (isNothing) {
            System.out.print("낫싱");
        }
    }

}
