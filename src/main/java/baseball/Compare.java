package baseball;

import java.util.ArrayList;
import java.util.List;

public class Compare {
    public static final int INPUT_LENGTH = 3;
    public static final int STRIKE_INDEX = 0;
    public static final int BALL_INDEX = 1;
    private List<Integer> src;
    private List<Integer> dest;
    private List<Integer> answer;

    public Compare(List<Integer> src, List<Integer> dest) {
        this.src = src;
        this.dest = dest;
    }

    public List<Integer> getAnswer() {
        answer = new ArrayList<>();
        answer.add(getStrikeNum());
        answer.add(getBallNum());
        return answer;
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
        int ballNum;
        int strikeNum = answer.get(0);

        ballNum = getContainNum() - strikeNum;
        return ballNum;
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
