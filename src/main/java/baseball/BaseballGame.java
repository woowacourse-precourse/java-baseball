package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private final List<Integer> computerNumber;
    private int ball;
    private int strike;
    private int nothing;
    private final int NUMBER_LENGTH = 3;

    BaseballGame() {
        this.computerNumber = this.createComputerNumber();
        this.ball = 0;
        this.strike = 0;
        this.nothing = 0;
    }

    public List<Integer> createComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }
}