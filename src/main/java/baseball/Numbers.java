package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public void validate() {
        validateRange();
        validateSize();
    }

    private void validateSize() {
        Set<Integer> numberSet = new HashSet<>(numbers);

        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException("숫자를 " + NUMBERS_SIZE + "개 입력해주세요.");
        }
        if (numberSet.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력해주세요.");
        }
    }

    private void validateRange() {
        String expression = "^[1-9]+$";
        StringBuilder stringBuilder = new StringBuilder();

        for (Integer number : numbers) {
            stringBuilder.append(number);
        }

        String numbersString = stringBuilder.toString();
        if (!numbersString.matches(expression)) {
            throw new IllegalArgumentException("잘못된 입력입니다. 1~9 범위의 숫자만 입력해주세요.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
