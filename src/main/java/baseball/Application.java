package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        new BaseballController(new NumbersGenerator()).run();
    }
}

class BaseballController {
    private final int COUNT_OF_NUMBERS = 3;

    private NumbersGenerator numbersGenerator;

    BaseballController(NumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
    }
    public void run() {
        Numbers answer = numbersGenerator.generate(COUNT_OF_NUMBERS);
    }
}

class Numbers {
    private List<Integer> numbers;

    Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}

class NumbersGenerator {
    Numbers generate(int count) {

        return new Numbers(
                Stream.generate(() -> Randoms.pickNumberInRange(1, 9))
                        .distinct()
                        .limit(count)
                        .collect(Collectors.toList()));
    }
}
