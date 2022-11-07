package baseball;


import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;
import static camp.nextstep.edu.missionutils.Randoms.*;

public class BaseBall {

    private int strike;
    private int ball;
    private int nothing;

    public BaseBall() {
        this.strike = 0;
        this.ball = 0;
        this.nothing = 0;
    }

    public void playBaseBall() {
        while (true) {
            playGame();
            boolean isStrike3 = isStrike3();
            if (isStrike3) {
                restart();
            }
        }

}
