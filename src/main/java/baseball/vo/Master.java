package baseball.vo;

import java.util.List;

public class Master {
    int strikeCount;
    int ballCount;
    List<Integer> gameNumbers;

    public Master(List<Integer> numberList) {
        gameNumbers = numberList;
    }

    public void initCount() {
        strikeCount = 0;
        ballCount = 0;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public List<Integer> getGameNumbers() {
        return gameNumbers;
    }

    public void strike() {
        strikeCount += 1;
    }

    public void ball() {
        ballCount += 1;
    }

}
