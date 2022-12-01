package baseball.model;

import static baseball.util.Constants.BALL_LENGTH;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Computer {

    private enum Range {
        BALL_MIN(1),
        BALL_MAX(9);

        private final int value;

        Range(int value) {
            this.value = value;
        }
    }

    private final List<Integer> computerNumber;

    private Computer() {
        this.computerNumber = createRandomNumbers();
    }

    public static Computer createByRandomNumber() {
        return new Computer();
    }

    private List<Integer> createRandomNumbers() {
        Set<Integer> numbers = new LinkedHashSet<>();
        while (numbers.size() < BALL_LENGTH) {
            numbers.add(createRandomNumber());
        }
        return new ArrayList<>(numbers);
    }

    private static int createRandomNumber() {
        return Randoms.pickNumberInRange(Range.BALL_MIN.value, Range.BALL_MAX.value);
    }


    public int getNumberByPosition(int position) {
        return computerNumber.get(position);
    }

    public boolean hasCommonNumber(int playerNumber) {
        return computerNumber.contains(playerNumber);
    }
}
