package baseball.view;

import baseball.BaseballScore;
import java.util.Map;

public class GameMessage {
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printGameResult(Map<BaseballScore, Integer> resultScore) {
        String resultString = "";
        resultString += getBallCountResult(resultScore.get(BaseballScore.BALL));
        resultString += getStrikeCountResult(resultScore.get(BaseballScore.STRIKE));


    }

    public String getStrikeCountResult(int strikeCount) {
        if(strikeCount > 0) {
            return strikeCount + BaseballScore.STRIKE.getScoreName();
        }
        return "";
    }

    public String getBallCountResult(int ballCount) {
        if(ballCount > 0) {
            return ballCount + BaseballScore.BALL.getScoreName();
        }
        return "";
    }
}
