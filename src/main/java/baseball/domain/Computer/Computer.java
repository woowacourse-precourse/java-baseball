package baseball.domain.Computer;

import baseball.domain.Validation.BallNumber;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> ballNumbers;

    public Computer() {
        ballNumbers = new ArrayList<>();
    }

    public List<Integer> getBallNumbers() {
        return ballNumbers;
    }

    public void generateRandomNumbers() {
        int number;
        while (ballNumbers.size() != 3) {
            number = Randoms.pickNumberInRange(BallNumber.NUMBER_MIN.getValue(), BallNumber.NUMBER_MAX.getValue());
            generateNumberList(number);
        }
    }

    private void generateNumberList(int number) {
        if (ballNumbers.contains(number)) {
            return;
        }
        ballNumbers.add(number);
    }

}
