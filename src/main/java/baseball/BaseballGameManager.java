package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BaseballGameManager {

    public final static int NUMBER_COUNT_TO_CREATED = 3;

    private MessageCreator messageCreator = new MessageCreator();
    private List<Integer> randomNumbers = new ArrayList<>();
    private int strikeCount;
    private int ballCount;

    public void createRandomNumbers() {
        while (randomNumbers.size() < NUMBER_COUNT_TO_CREATED) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
    }

    public void printResult(String input) {
        calculateBallCount(input);
        messageCreator.printResultMessage(strikeCount, ballCount);
    }

    public boolean isGameClear() {
        if (strikeCount == 3) {
            randomNumbers.clear();
            return true;
        }
        return false;
    }

    private void calculateBallCount(String input) {
        strikeCount = (int) IntStream.range(0, 3)
                .filter(idx -> randomNumbers.get(idx).equals(Integer.parseInt(String.valueOf(input.charAt(idx)))))
                .count();

        ballCount = (int) IntStream.range(0, 3)
                .filter(idx -> input.contains(String.valueOf(randomNumbers.get(idx))))
                .filter(idx -> !randomNumbers.get(idx).equals(Integer.parseInt(String.valueOf(input.charAt(idx)))))
                .count();
    }
}
