package baseball.domain;

import static baseball.global.constants.Constants.*;
import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> randomNumbers;

    private Computer() {

    }

    public static Computer of() {
        return new Computer();
    }

    public void init() {
        generateRandomNumbers();
    }

    private void generateRandomNumbers() {
        randomNumbers = new ArrayList<>(THREE_DIGITS);

        while (randomNumbers.size() < THREE_DIGITS) {
            int number = pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!randomNumbers.contains(number)) {
                randomNumbers.add(number);
            }
        }
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    public int getBallCounts(List<Integer> userNumbers) {
        int ballCount = 0;
        for (int i = 0; i < THREE_DIGITS; i++) {
            final int userNumber = userNumbers.get(i);
            final int randomNumber = randomNumbers.get(i);
            if (userNumber != randomNumber && randomNumbers.contains(userNumber)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public int getStrikeCounts(List<Integer> userNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < THREE_DIGITS; i++) {
            final int userNumber = userNumbers.get(i);
            final int randomNumber = randomNumbers.get(i);
            if (userNumber == randomNumber) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    // === 테스트 메서드 ===
    public void generateTestNumbers() {
        randomNumbers = List.of(1, 2, 3);
    }
}
