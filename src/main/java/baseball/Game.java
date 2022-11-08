package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {

    private final BaseballNumber computer;

    public Game() {
        this.computer = new BaseballNumber();
    }

    public PlayResult playGame(BaseballNumber baseballNumber) {
        int strike = computer.getStrike(baseballNumber);
        int ball = computer.getBall(baseballNumber);

        return new PlayResult(strike, ball);
    }
}
