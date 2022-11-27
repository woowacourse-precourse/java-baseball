package baseball.domain;

import baseball.utils.BaseballNumbersGenerator;
import baseball.utils.Constants;
import java.util.List;

public class Baseball {

    private final List<Integer> computerNumbers;

    public Baseball(BaseballNumbersGenerator numbersGenerator) {
        Numbers numbers = new Numbers(numbersGenerator.generate());
        this.computerNumbers = numbers.getNumbers();
    }

    public boolean isGameContinue(Numbers user) {
        return !(countStrike(user) == Constants.NUMBERS_SIZE);
    }

    public int countStrike(Numbers user) {
        int strikeCount = 0;
        for (int i = 0; i < Constants.NUMBERS_SIZE; i++) {
            if (user.getNumbers().get(i) == computerNumbers.get(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int countBall(Numbers numbers) {
        int sameNumberCount = 0;
        for (int number : numbers.getNumbers()) {
            if (computerNumbers.contains(number)) {
                sameNumberCount++;
            }
        }
        return sameNumberCount - countStrike(numbers);
    }
}
