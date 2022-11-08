package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber implements Number {
    @Override
    public List<Integer> getNumberList() {

        List<Integer> numbers = new ArrayList<>(Config.MAX_BALLS_SIZE);

        while (numbers.size() < Config.MAX_BALLS_SIZE) {
            addNumber(Randoms.pickNumberInRange(1, 9), numbers);
        }

        return numbers;
    }

    private void addNumber(int number, List<Integer> numbers) {
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }
}
