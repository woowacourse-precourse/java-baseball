package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        new BaseballController(new NumbersGenerator(),
                new Console(new Input(), new Output()),
                new GameStatus(),
                new BaseballGame(new Numbers(), new Validator())).run();
    }
}

class BaseballController {
    private final int COUNT_OF_NUMBERS = 3;

    private NumbersGenerator numbersGenerator;
    private Console console;
    private GameStatus gameStatus;
    private BaseballGame baseballGame;

    BaseballController(NumbersGenerator numbersGenerator, Console console, GameStatus gameStatus, BaseballGame baseballGame) {
        this.numbersGenerator = numbersGenerator;
        this.console = console;
        this.gameStatus = gameStatus;
        this.baseballGame = baseballGame;
    }
    public void run() {
        Numbers answer = numbersGenerator.generate(COUNT_OF_NUMBERS);
        console.printOutput("숫자 야구 게임을 시작합니다.");

        while (gameStatus.isRunning()) {
            try {
                console.printOutput("숫자를 입력해주세요 : ");
                Numbers inputNumbers = baseballGame.convertToNumbers(console.getInput());
            } catch (IllegalArgumentException e) {
                console.printOutput(e.getMessage());
            }
        }
    }
}
class BaseballGame {
    Numbers numbers;
    Validator validator;

    BaseballGame(Numbers numbers, Validator validator) {
        this.numbers = numbers;
        this.validator = validator;
    }

    public Numbers convertToNumbers(String inputString) {
        if (validator.isRightFormat(inputString)) {
            return numbers.parseToNumbers(inputString);
        }
        throw new IllegalArgumentException("잘못된 입력입니다.");
    }
}

class Validator {
    private static final Pattern pattern = Pattern.compile("^[1-9]{3}");

    public boolean isRightFormat(String inputString) {
        return pattern.matcher(inputString).matches();
    }
}

class GameStatus {
    private Boolean status = true;

    public boolean isRunning() {
        return status;
    }
}

class Input {
    Scanner scanner = new Scanner(System.in);

    public String input() {
        return scanner.nextLine();
    }
}

class Output {
    public void printOutput(String message) {
        System.out.println(message);
    }
}

class Console {
    Input input;
    Output output;

    Console(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public String getInput() {
        return input.input();
    }

    public void printOutput(String message) {
        output.printOutput(message);
    }
}

class Numbers {
    private List<Integer> numbers;

    Numbers() {
    }

    Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Numbers parseToNumbers(String inputString) {
        List<Integer> numbers = inputString.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());

        return new Numbers(numbers);
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
