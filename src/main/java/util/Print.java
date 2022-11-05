package util;

import baseball.game.GameResult;

public class Print {
    public static void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printWaitForInput() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printGameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
    public static void printScore(GameResult gameResult) {

        if (gameResult.isBallScoreValid()) {
            System.out.print(gameResult.getBall() + "볼 ");
        }

        if (gameResult.isStrikeScoreValid()) {
            System.out.print(gameResult.getStrike() + "스트라이크 ");
        }

        if (gameResult.isNoScore()) {
            System.out.print("낫싱");
        }
        System.out.println();
    }
}
