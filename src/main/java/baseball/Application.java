package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        new BaseballController(new NumbersGenerator(),
                new Console(new Output())).run();
    }
}

class BaseballController {
    private final int COUNT_OF_NUMBERS = 3;

    private NumbersGenerator numbersGenerator;
    private Console console;

    BaseballController(NumbersGenerator numbersGenerator, Console console) {
        this.numbersGenerator = numbersGenerator;
        this.console = console;
    }
    public void run() {
        Numbers answer = numbersGenerator.generate(COUNT_OF_NUMBERS);
        console.printOutput("숫자 야구 게임을 시작합니다.");
    }
}

class Output {
    public void printOutput(String message) {
        System.out.println(message);
    }
}

class Console {
    Output output;

    Console(Output output) {
        this.output = output;
    }

    public void printOutput(String message) {
        output.printOutput(message);
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
