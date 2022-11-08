package baseball.domain;

import baseball.constants.ComparingResults;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class QuestionNumberSetter {

    private List<Integer> randomNumbers = new ArrayList<>();
    private List<Integer> inputNumbers = new ArrayList<>();
    private Map<ComparingResults, Integer> comparingResult = new TreeMap<>();

    public List<Integer> pickThreeRandomNumbers() {
        randomNumbers.clear();

        while (randomNumbers.size() < 3) {
            int uniqueNumber = pickUniqueRandomNumber();
            randomNumbers.add(uniqueNumber);
        }

        return randomNumbers;
    }

    private int pickUniqueRandomNumber() {
        int uniqueNumber = 0;

        do {
            uniqueNumber = Randoms.pickNumberInRange(1, 9);
        } while (randomNumbers.contains(uniqueNumber));

        return uniqueNumber;
    }


    public Map<ComparingResults, Integer> compareWithRandomNumbers(
            List<Integer> inputNumbersParameter) {
        this.comparingResult.clear();
        this.inputNumbers = inputNumbersParameter;

        for (int inputNumber : inputNumbers) {
            if (randomNumbers.contains(inputNumber)) {
                countBallOrStrike(inputNumber);
            }
        }

        if (comparingResult.isEmpty() == true) {
            comparingResult.put(ComparingResults.NOTHING, 1);
        }

        return comparingResult;
    }

    private void countBallOrStrike(int inputNumber) {
        int inputNumberPosition = inputNumbers.indexOf(inputNumber);
        int randomNumberPosition = randomNumbers.indexOf(inputNumber);

        if (randomNumberPosition == inputNumberPosition) {
            countStrike();
        } else {
            countBall();
        }
    }

    private void countStrike() {
        int count = 1;

        if (comparingResult.containsKey(ComparingResults.STRIKE)) {
            count = comparingResult.get(ComparingResults.STRIKE) + 1;
        }

        comparingResult.put(ComparingResults.STRIKE, count);
    }

    private void countBall() {
        int count = 1;

        if (comparingResult.containsKey(ComparingResults.BALL)) {
            count = comparingResult.get(ComparingResults.BALL) + 1;
        }

        comparingResult.put(ComparingResults.BALL, count);
    }
}
