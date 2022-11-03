package baseball.domain.computer;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerImpl implements Computer {

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

    private int anotherNumber(int number) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        while (number == randomNumber) {
            randomNumber = Randoms.pickNumberInRange(1,9);
        }
        return randomNumber;
    }

}
