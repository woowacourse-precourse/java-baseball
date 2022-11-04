package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public class Computer {
    private static final int LENGTH_OF_NUMBER = 3;
    private List<Integer> numbers;

    public List<Integer> selectRandomNumbers() {
        numbers = Randoms.pickUniqueNumbersInRange(1, 9, LENGTH_OF_NUMBER);
        return numbers;
    }

    public Integer countStrike(Integer countNumber) {
        List<Integer> countNumbers = Application.convertToList(countNumber);
        Integer count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i).equals(countNumbers.get(i))) {
                count++;
            }
        }
        return count;
    }

    public Integer countBall(Integer countNumber) {
        List<Integer> countNumbers = Application.convertToList(countNumber);
        Integer count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (!numbers.get(i).equals(countNumbers.get(i)) &&
                    countNumbers.contains(numbers.get(i))) {
                count++;
            }
        }
        return count;
    }

    public List<Integer> compare(Integer answer) {
        Integer strike = countStrike(answer);
        Integer ball = countBall(answer);
        return Arrays.asList(strike, ball);
    }


}
