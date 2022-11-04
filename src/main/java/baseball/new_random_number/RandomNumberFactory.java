package baseball.new_random_number;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberFactory {

    public static Answer createNewAnswer() {
        List<Integer> randomNumbers = generateRandomNumber();
        List<RandomNumber> randomNumberList = IntStream.range(0, randomNumbers.size())
                .mapToObj(i -> new RandomNumber(i, randomNumbers.get(i)))
                .collect(Collectors.toList());

        return new Answer(randomNumberList);
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
