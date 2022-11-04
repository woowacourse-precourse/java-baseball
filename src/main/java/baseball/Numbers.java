package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private static final int NUMBERS_SIZE = 3;

    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Numbers createRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < NUMBERS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return new Numbers(randomNumbers);
    }

    public static Numbers createInputNumbers() {
        String[] splitInput = Console.readLine().split("");
        List<Integer> numbers = new ArrayList<>();
        for (String input : splitInput) {
            numbers.add(Integer.parseInt(input));
        }
        return new Numbers(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
