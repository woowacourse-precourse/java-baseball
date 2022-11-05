package baseball.domain.number.randomnumber;

import baseball.domain.number.SingleNumber;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberFactory {

    public static RandomNumbers newInstance() {
        return new RandomNumbers(generateSingleNumberList());
    }

    private static List<SingleNumber> generateSingleNumberList() {
        List<Integer> randomNumbers = generateRandomNumber();
        return IntStream.range(0, 3)
                .mapToObj(i -> new SingleNumber(i, randomNumbers.get(i)))
                .collect(Collectors.toList());
    }

    private static List<Integer> generateRandomNumber() {
        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }

        return randomNumbers;
    }
}
