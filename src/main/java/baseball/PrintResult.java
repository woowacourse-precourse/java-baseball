package baseball;

import baseball.dto.GameScore;

public class PrintResult {
    public void printResult(GameScore gameScore) {
        if (gameScore.getStrike() > 0 && gameScore.getBall() > 0) {
            System.out.println(gameScore.getBall() + "볼 " + gameScore.getStrike() + "스트라이크");
        }

        if (gameScore.getStrike() > 0 && gameScore.getBall() == 0) {
            System.out.println(gameScore.getStrike() + "스트라이크");
        }

        if (gameScore.getStrike() == 0 && gameScore.getBall() > 0) {
            System.out.println(gameScore.getBall() + "볼");
        }

        if (gameScore.getStrike() == 0 && gameScore.getBall() == 0) {
            System.out.println("낫싱");
        }
    }
}
