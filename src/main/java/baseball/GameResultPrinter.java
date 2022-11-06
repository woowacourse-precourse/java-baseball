package baseball;

import java.util.List;

public class GameResultPrinter {

    public String convertGameResult(List<Integer> gameResult) {
        String converter = "";
        if (isNothing(gameResult)) {
            return "낫싱";
        }
        if (isStrike(gameResult)) {
            return gameResult.get(0) + " 스트라이크";
        }
        if (isBall(gameResult)) {
            return gameResult.get(1) + " 볼";
        }
        return "";
    }

    private static boolean isBall(List<Integer> gameResult) {
        return gameResult.get(1) != 0;
    }

    private static boolean isStrike(List<Integer> gameResult) {
        return gameResult.get(0) != 0;
    }

    private static boolean isNothing(List<Integer> gameResult) {
        return gameResult.get(2) != 0;
    }
}
