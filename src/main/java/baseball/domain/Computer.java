package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    int strikeCount;
    int ballCount;
    List<Integer> gameNumbers;

    public Computer(List<Integer> gameNumbers) {
        this.gameNumbers = gameNumbers;
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

    public void clearCount() {
        strikeCount = 0;
        ballCount = 0;
    }

    public void increaseStrikeCount() {
        strikeCount += 1;
    }

    public void increaseBallCount() {
        ballCount += 1;
    }

}
