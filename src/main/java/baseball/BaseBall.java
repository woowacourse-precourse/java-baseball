package baseball;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.*;
import static camp.nextstep.edu.missionutils.Randoms.*;

public class BaseBall {

    private int strike;
    private int ball;
    private boolean isRestart;
    private List<String> randomList;

    public BaseBall() {
        this.strike = 0;
        this.ball = 0;
        this.isRestart = true;
        this.randomList = new ArrayList<>();
    }

    public void playBaseBall() {
        System.out.println(START_GAME);
        randomList = makeRandom();
        while (true) {
            initGame();
            playGame();
            boolean isStrike3 = isStrike3();
            if (isStrike3) {
                restart();
            }
            if (this.isRestart == true) {
                continue;
            } else {
                break;
            }
        }
    }

}
