package baseball;

import java.util.Map;

public class GameMessageDisplay {
    public void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void printInputRequestMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }
    public void printGameResultMessage(Map<String, Integer> gameResult) {
        String gameResultMessage = getGameResultMessage(gameResult);
        System.out.print(gameResultMessage);
    }
    public String getGameResultMessage(Map<String, Integer> gameResult) {
        int ball = gameResult.get("ball");
        int strike = gameResult.get("strike");

        if (strike == 3) {
            return "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }
        if (strike == 0) {
            return String.format("%d볼", ball);
        }
        if (ball == 0) {
            return String.format("%d스트라이크", strike);
        }
        return String.format("%d볼 %d스트라이크", ball, strike);
    }
}
