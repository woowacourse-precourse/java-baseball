package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGameModel {
    private int ball, strike;
    private List<Integer> computer;

    public BaseBallGameModel() {
        this.ball = 0;
        this.strike = 0;
    }

    private void createRandomNumber() {
        computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains(randomNumber))
                computer.add(randomNumber);
        }
    }
}
