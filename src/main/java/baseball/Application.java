package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        new BaseballController(new NumbersGenerator(),
                new Console(new Input(), new Output()),
                new GameStatus()).run();
    }
}

class BaseballController {
    private final int COUNT_OF_NUMBERS = 3;

    private NumbersGenerator numbersGenerator;
    private Console console;
    private GameStatus gameStatus;

    BaseballController(NumbersGenerator numbersGenerator, Console console, GameStatus gameStatus) {
        this.numbersGenerator = numbersGenerator;
        this.console = console;
        this.gameStatus = gameStatus;
    }
    public void run() {
        Numbers answer = numbersGenerator.generate(COUNT_OF_NUMBERS);
        console.printOutput("숫자 야구 게임을 시작합니다.");

        while (gameStatus.isRunning()) {
            console.printOutput("숫자를 입력해주세요 : ");
            String inputString = console.getInput();
        }
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
