package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {
    private Numbers randomNumbers;
    private Numbers predictNumbers;

    private void pickRandomNumbers() {
        randomNumbers = new Numbers();
        while (randomNumbers.size() < 3) {
            randomNumbers.add(Randoms.pickNumberInRange(0, 9));
        }
    }

    private void getPredictNumbers(int number) {
        predictNumbers = new Numbers();
        while (number > 0) {
            predictNumbers.add(number % 10);
            number /= 10;
        }
        predictNumbers.validateNumbers();
    }

    public void run() {
        pickRandomNumbers();
    }
}
