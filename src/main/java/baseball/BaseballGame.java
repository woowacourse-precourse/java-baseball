package baseball;

import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class BaseballGame {
    private Numbers randomNumbers;
    private Numbers predictNumbers;
    private final InputView inputView;
    private final OutputView outputView;

    public BaseballGame() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void pickRandomNumbers() {
        randomNumbers = new Numbers();
        while (randomNumbers.size() < 3) {
            addRandomNumbers(Randoms.pickNumberInRange(0, 9));
        }
    }

    private void addRandomNumbers(int number) {
        if (!randomNumbers.isContaining(number)) {
            randomNumbers.add(number);
        }
    }

    public void getPredictNumbers(int number) {
        predictNumbers = new Numbers();
        Arrays.stream(String.valueOf(number).split(""))
                .map(Integer::parseInt)
                .forEach(x -> predictNumbers.add(x));
    }

    public List<Integer> checkNumbers() {
        List<Integer> counts = new ArrayList<>(Arrays.asList(0, 0, 0));
        IntStream.range(0, 3)
                .map(x -> randomNumbers.check(predictNumbers.get(x), x))
                .forEach(x -> counts.set(x, counts.get(x) + 1));
        return counts;
    }

    public void run() {
        List<Integer> counts;
        pickRandomNumbers();
        do {
            getPredictNumbers(validateStringToInteger(inputView.inputNumbers()));
            predictNumbers.validateNumbers();
            counts = checkNumbers();
            outputView.printResult(counts);
        } while (counts.get(2) != 3);
    }

    public boolean checkRetry(String retry) {
        return validateRetry(retry) == 1;
    }

    private int validateRetry(String retry) {
        int retryInt = validateStringToInteger(retry);
        if (retryInt != 1 && retryInt != 2) {
            throw new IllegalArgumentException("1 혹은 2가 입력되어야 합니다.");
        }
        return retryInt;
    }

    public int validateStringToInteger(String retry) {
        try {
            return Integer.parseInt(retry);
        } catch (NumberFormatException ok) {
            throw new IllegalArgumentException("숫자만 입력되어야 합니다.");
        }
    }
}