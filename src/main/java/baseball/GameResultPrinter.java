package baseball;

import java.util.List;

public class GameResultPrinter {

    public String convertGameResult(List<Integer> gameResult) {
        String converter = "";
        if (gameResult.get(2) == 0) {
            return "낫싱";
        }

        return "";
    }
}
