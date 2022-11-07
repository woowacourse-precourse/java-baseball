
package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static baseball.rule.Digit.DIGITS;

public class Referee {

    private final boolean[] usedNumber = new boolean[9];

    private final List<Integer> numbers = new ArrayList<>();

    private final BallCount ballCount;

    public Referee() {
        this.ballCount = new BallCount();
    }

    public List<Integer> makeRandomValues() {
        initNumbers();
        while(numbers.size() < DIGITS){
            int picked = Randoms.pickNumberInRange(1, 9);
            if (checkDuplicate(picked)) {
                numbers.add(picked);
            }
        }
        return numbers;
    }

    public String checkCounts(List<Integer> inputs) {
        ballCount.init();

        inputs.stream()
                .filter(numbers::contains)
                .forEach(input -> ballCount.increaseBall());

        for (int i = 0; i < DIGITS; i++) {
            if (numbers.get(i).equals(inputs.get(i))) {
                ballCount.decreaseBall();
                ballCount.increaseStrike();
            }
        }
        return ballCount.toString();
    }

    public boolean isAllStrike() {
        return ballCount.isAllStrike();
    }

    private void initNumbers() {
        numbers.clear();
        initUsedNumbers();
    }

    private boolean checkDuplicate(int number) {
        if (!usedNumber[number - 1]) {
            usedNumber[number - 1] = true;
            return true;
        }
        return false;
    }

    private void initUsedNumbers() {
        Arrays.fill(usedNumber, false);
    }
}
