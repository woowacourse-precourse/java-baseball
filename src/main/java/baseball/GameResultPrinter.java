package baseball;

import java.util.List;

public class GameResultPrinter {

    public String convertGameResult(List<Integer> gameResult) {
        String converter = "";
        if (gameResult.get(2) != 0) {
            return "낫싱";
        }
        if (gameResult.get(0) != 0) {
            return gameResult.get(0) + " 스트라이크";
        }
        if (gameResult.get(1) != 0) {
            return gameResult.get(1) + " 볼";
        }


        return "";
    }
}
