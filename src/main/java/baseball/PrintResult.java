package baseball;

import baseball.dto.GameScore;

public class PrintResult {

    // 게임 결과를 출력하기 위한 메소드, GameScore DTO에서 스트라이크와 볼 수를 받아 각 경우에 맞는 호출문을 실행
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
