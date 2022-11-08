package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private static final int FIXED_NUMBER_LENGTH = 3;

    public List<Integer> getComputerRandomNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            checkDuplicateNumber(computer, randomNumber);
        }

        return computer;
    }

    private void checkDuplicateNumber(List<Integer> computer, Integer randomNumber) {
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
    }

    public List<Integer> enterNumber() {
        String input = Console.readLine();
        checkNumberValidation(input);

        return toInts(input);
    }

    private void checkNumberValidation(String number) {
        List<Integer> numbers = toInts(number);

        InputValidation.checkNumberLength(number, FIXED_NUMBER_LENGTH);

        for (Integer num : numbers) {
            InputValidation.checkNumberRange(num);
            InputValidation.checkDuplicateNumber(numbers, num);
        }
    }

    private List<Integer> toInts(String number) {
        List<String> numbers = Arrays.asList(number.split(""));

        return numbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
