package baseball.model;

import static baseball.util.Constants.BALL_LENGTH;
import static baseball.util.Constants.BALL_MAX;
import static baseball.util.Constants.BALL_MIN;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Computer {


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
        return Randoms.pickNumberInRange(BALL_MIN, BALL_MAX);
    }


    public int getNumberByPosition(int position) {
        return computerNumber.get(position);
    }

    public boolean hasCommonNumber(int playerNumber) {
        return computerNumber.contains(playerNumber);
    }
}
