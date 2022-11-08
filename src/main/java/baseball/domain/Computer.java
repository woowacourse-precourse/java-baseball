package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

import static baseball.type.BaseballBound.*;

public class Computer {
    private final ComputerNumbers computerNumbers;

    public Computer() {
        this.computerNumbers = new ComputerNumbers(createRandomNumbers());
    }

    public Computer(List<Integer> numbers) {
        this.computerNumbers = new ComputerNumbers(numbers);
    }

    public List<Integer> createRandomNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < BASEBALL_MAX_SIZE.getValue()) {
            Integer number = Randoms.pickNumberInRange(BASEBALL_NUMBER_MIN.getValue(), BASEBALL_NUMBER_MAX.getValue());
            if (!computerNumbers.contains(number)) {
                computerNumbers.add(number);
            }
        }

        return computerNumbers;
    }

    public Hint createHint(String playerGuess) {
        BaseballNumbers baseballNumbers = new BaseballNumbers(playerGuess);
        int strikes = computerNumbers.countStrikes(baseballNumbers);
        int balls = computerNumbers.countBalls(baseballNumbers);

        return new Hint(strikes, balls);
    }
}
