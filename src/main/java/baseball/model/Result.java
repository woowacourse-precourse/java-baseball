package baseball.model;

import baseball.process.Comparison;

public class Result {
    int strikeCount;
    int ballCount;
    Game game;
    Comparison comparison;

    public Result(Game game, Comparison comparison) {
        this.game = game;
        this.comparison = comparison;

        this.strikeCount = comparison.getStrikeCount();
        this.ballCount = comparison.getBallCount();
    }

    public String getResultMsg() {
        String resultMsg = "";
        if (ballCount == 0 && strikeCount == 0) {
            resultMsg += "낫싱";
        }
        if (ballCount != 0) {
            resultMsg += ballCount + "볼 ";
        }
        if (strikeCount != 0) {
            resultMsg += strikeCount + "스트라이크";
        }

        return resultMsg.trim();
    }

    public boolean is3Strike() {
        if (strikeCount == 3) {
            return true;
        }
        return false;
    }

}
