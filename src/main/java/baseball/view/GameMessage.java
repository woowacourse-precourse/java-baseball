package baseball.view;

import baseball.model.constants.BaseballScore;
import baseball.model.constants.GameConstants;
import java.util.Map;

public class GameMessage {
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printGameResult(Map<BaseballScore, Integer> resultScore) {
        String nothingString = getNothingResult(resultScore.get(BaseballScore.NOTHING));
        String ballString = getBallCountResult(resultScore.get(BaseballScore.BALL));
        String strikeString = getStrikeCountResult(resultScore.get(BaseballScore.STRIKE));

        String resultString = nothingString + ballString + " " + strikeString;

        System.out.println(resultString.strip());
    }

    public String getNothingResult(int nothingScore) {
        if (nothingScore == GameConstants.NUMBER_LENGTH) {
            return BaseballScore.NOTHING.getScoreName();
        }
        return "";
    }

    public String getStrikeCountResult(int strikeCount) {
        if (strikeCount > 0) {
            return strikeCount + BaseballScore.STRIKE.getScoreName();
        }
        return "";
    }

    public String getBallCountResult(int ballCount) {
        if (ballCount > 0) {
            return ballCount + BaseballScore.BALL.getScoreName();
        }
        return "";
    }
}
