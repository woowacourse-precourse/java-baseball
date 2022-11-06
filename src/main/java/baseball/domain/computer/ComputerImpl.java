package baseball.domain.computer;

import baseball.domain.baseballAlgorithm.BaseballAlgorithm;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerImpl implements Computer {

    private final BaseballAlgorithm baseballAlgorithm;

    public ComputerImpl(BaseballAlgorithm baseballAlgorithm) {
        this.baseballAlgorithm = baseballAlgorithm;
    }

    @Override
    public List<Integer> generateRandomNumber() {
        List<Integer> randomNumber = new ArrayList<>();
        int number = Randoms.pickNumberInRange(1, 9);
        randomNumber.add(number);
        for (int i = 1; i < 3; i++) {
            number = anotherNumber(number);
            randomNumber.add(number);
        }
        return randomNumber;
    }

    @Override
    public String baseballResult(List<Integer> randomNumber, String userInput) {
        return baseballAlgorithm.checkBaseballResult(randomNumber, userInput);
    }

    private int anotherNumber(int number) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        while (number == randomNumber) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
        }
        return randomNumber;
    }

}
