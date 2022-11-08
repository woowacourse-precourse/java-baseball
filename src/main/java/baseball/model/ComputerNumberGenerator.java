package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ComputerNumberGenerator {

    public final List<Integer> VALIDATED_NUM;

    public ComputerNumberGenerator() {
        List<Integer> numbers;
        do {
            numbers = generateNumbers();
        } while (NumberValidator.checkIfIsNotDuplicatedNum(numbers));
        VALIDATED_NUM = numbers;
    }

    private static List<Integer> generateNumbers() {
        return IntStream.rangeClosed(1, 3)
                .map(num -> Randoms.pickNumberInRange(1, 9))
                .boxed()
                .collect(Collectors.toList());
    }
}
