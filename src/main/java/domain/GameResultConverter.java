package domain;

import java.util.List;

public class GameResultConverter {
    public String convertGameResult(List<Integer> gameResult) {
        String converter = "";
        if (isNothing(gameResult)) {
            return "낫싱";
        }
        if (isOnlyBall(gameResult)) {
            return gameResult.get(1) + "볼";
        }
        if (isOnlyStrike(gameResult)) {
            return gameResult.get(0) + "스트라이크";
        }
        return gameResult.get(1) + "볼 " + gameResult.get(0) + "스트라이크";
    }
    private static boolean isNothing(List<Integer> gameResult) {
        return gameResult.get(2) != 0;
    }
    private static boolean isOnlyBall(List<Integer> gameResult) {
        return gameResult.get(1) != 0 && gameResult.get(0) == 0;
    }
    private static boolean isOnlyStrike(List<Integer> gameResult) {
        return gameResult.get(0) != 0 && gameResult.get(1) == 0;
    }
}
