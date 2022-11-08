package baseball.Util;

import baseball.GameState;

import java.util.ArrayList;

public class GameResultHandler {
    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private ArrayList<String> output;

    public GameResultHandler() {
        output = new ArrayList<>();
    }

    public GameState out(CountResult count) {
        if (count.ball != 0) {
            addBallCount(count.ball);
        }
        if (count.strike != 0) {
            addStrikeCount(count.strike);
        }
        if (count.strike == 0 && count.ball == 0) {
            output.add(NOTHING);
        }
        System.out.println(String.join(" ", output));

        if (count.strike == 3) {
            return GameState.END;
        } else
            return GameState.GAME_STATE;
    }

    private void addBallCount(int count) {
        output.add(count + BALL);
    }

    private void addStrikeCount(int count) {
        output.add(count + STRIKE);
    }

}