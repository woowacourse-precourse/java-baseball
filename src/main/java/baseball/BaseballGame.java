package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashMap;

public class BaseballGame {



    private int ball;
    private int strike;

    BaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        this.strike = 0;
        this.ball = 0;
    }

    void ballReader(int userball, int computerball, boolean isStrike) {
        if (isStrike && userball == computerball) {
            this.strike++;
        } else if (userball == computerball) {
            this.ball++;
        }
    }


}
