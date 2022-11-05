package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Score {
    public static final int INPUT_LENGTH = 3;
    public static final int STRIKE_INDEX = 0;
    public static final int BALL_INDEX = 1;
    private List<Integer> src;
    private List<Integer> dest;
    private List<Integer> score;

    public Score(List<Integer> src, List<Integer> dest) {
        this.src = src;
        this.dest = dest;
    }

    public List<Integer> getScore() {
        score = new ArrayList<>();
        score.add(getStrikeNum());
        score.add(getBallNum());
        return score;
    }

    private int getStrikeNum() {
        int strikeNum = 0;

        for (int i = 0; i < INPUT_LENGTH; i++) {
            if (src.get(i) == dest.get(i)) {
                strikeNum++;
            }
        }
        return strikeNum;
    }

    private int getBallNum() {
        return getContainNum() - score.get(STRIKE_INDEX);
    }

    private int getContainNum() {
        int containNum = 0;

        for (int i = 0; i < INPUT_LENGTH; i++) {
            if (dest.contains(src.get(i))) {
                containNum++;
            }
        }
        return containNum;
    }
}
