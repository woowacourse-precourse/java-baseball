package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballScore {
    private final int ALL_STRIKE = BaseballNumber.NUMBER_COUNT;
    private final int NOTHING = 0;

    private final String STRIKE_STRING = "스트라이크";
    private final String BALL_STRING = "볼";
    private final String NOTHING_MESSAGE = "낫싱";
    private final String ALL_STRIKE_MESSAGE = Integer.toString(ALL_STRIKE) + "개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private int strikes;
    private int ball;


    BaseballScore(int strikes, int ball) {
        this.strikes = strikes;
        this.ball = ball;
    }

    @Override
    public String toString() {
        if (is_nothing()) {
            return NOTHING_MESSAGE;
        }

        List<String> stringList = new ArrayList<>();

        if (ball != NOTHING) {
            stringList.add(Integer.toString(ball) + BALL_STRING);
        }

        if (strikes != NOTHING) {
            if (stringList.size() > 0) {
                stringList.add(" ");
            }
            stringList.add(Integer.toString(strikes) + STRIKE_STRING);
        }

        if (is_all_strike()) {
            stringList.add(System.lineSeparator() + ALL_STRIKE_MESSAGE);
        }

        return String.join("", stringList);
    }

    public boolean is_nothing() {
        return this.strikes == NOTHING && this.ball == NOTHING;
    }

    public boolean is_all_strike() {
        return strikes == ALL_STRIKE;
    }

}
