package baseball;

import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class BaseballGame {
    private Numbers randomNumbers;
    private Numbers predictNumbers;
    private final InputView inputView;

    public BaseballGame() {
        inputView = new InputView();
    }

    public void pickRandomNumbers() {
        randomNumbers = new Numbers();
        while (randomNumbers.size() < 3) {
            randomNumbers.add(Randoms.pickNumberInRange(0, 9));
        }
    }

    public void getPredictNumbers(int number) {
        predictNumbers = new Numbers();
        while (number > 0) {
            predictNumbers.add(number % 10);
            number /= 10;
        }
        predictNumbers.validateNumbers();
    }

    public List<Integer> checkNumbers(){
        List<Integer> counts = new ArrayList<>(Arrays.asList(0,0,0));
        IntStream.range(0,4)
                .map(x-> randomNumbers.check(predictNumbers.get(x), x))
                .forEach(x->counts.set(x, counts.get(x)+1));
        return counts;
    }

    public void run() {
        pickRandomNumbers();
        do {
            getPredictNumbers(inputView.inputNumbers());
        } while (checkNumbers().get(2)==3);
    }
}
