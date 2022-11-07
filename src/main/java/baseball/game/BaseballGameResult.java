package baseball.game;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameResult implements GameResult {

    private final static String BALL = "볼";
    private final static String STRIKE = "스트라이크";
    private final static String NOTHING = "낫싱";
    private final List<String> result = new ArrayList<>();

    public BaseballGameResult(int strikeCount, int ballCount) {
        if (ballCount != 0) result.add(ballCount + BALL);
        if (strikeCount != 0) result.add(strikeCount + STRIKE);
    }

    @Override
    public void showResult() {
        if (result.isEmpty()) {
            System.out.println(NOTHING);
        }
        System.out.println(String.join(" ", result));
    }
}
