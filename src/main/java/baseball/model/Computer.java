package baseball.model;

import baseball.dto.Hints;
import baseball.util.Rules;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.util.Rules.*;

public class Computer {

    private Numbers computerNumbers;

    public Computer () {}

    public void pickRandomNumbers() {
        List<Integer> randomNumbers = newUniqueRandomNumbers(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX, COUNT_NUMBER);
        int newNumbers = 0;
        for (int index = 0; index < randomNumbers.size(); index++) {
            newNumbers = (int) (newNumbers + (randomNumbers.get(index) * Math.pow(10, index)));
        }
        this.computerNumbers = Numbers.createNumbers(newNumbers);
    }

    private List<Integer> newUniqueRandomNumbers(int min, int max, int count) {
        List<Integer> numbers = new ArrayList<>();
        for (int index = 0; index < count; index++) {
            Integer randomNumber = Randoms.pickNumberInRange(min, max);
            while (numbers.contains(randomNumber)) {
                randomNumber = Randoms.pickNumberInRange(min, max);
            }
            numbers.add(randomNumber);
        }
        return numbers;
    }

    public Hints drawUserNumbers(User user) {
        Hints hints = new Hints();
        for (int index = 0; index < Rules.COUNT_NUMBER; index++) {
            Hint hint = computerNumbers.getHint(index, user.findUserNumber(index));
            hints.addHint(hint);
        }
        return  hints;
    }
}
