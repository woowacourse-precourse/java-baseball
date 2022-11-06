package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {
    private Numbers randomNumbers;

    private void pickRandomNumbers() {
        randomNumbers = new Numbers();
        while (randomNumbers.size() < 3) {
            randomNumbers.add(Randoms.pickNumberInRange(0, 9));
        }
    }

    public void run() {
        pickRandomNumbers();

    }
}
