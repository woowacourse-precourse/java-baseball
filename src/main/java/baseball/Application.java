package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        new BaseballController(new Console(new Input(), new Output()),
                new GameStatus(),
                new BaseballGame(new Validator(), new Computer(new NumbersGenerator(), new Numbers()), new Player(new Numbers())))
                .run();
    }
}

class BaseballController {
    private final int COUNT_OF_NUMBERS = 3;

    private Console console;
    private GameStatus gameStatus;
    private BaseballGame baseballGame;

    BaseballController(Console console, GameStatus gameStatus, BaseballGame baseballGame) {
        this.console = console;
        this.gameStatus = gameStatus;
        this.baseballGame = baseballGame;
        console.printOutput("숫자 야구 게임을 시작합니다.");
    }

    public void run() {
        Numbers answer = initProcess();

        while (gameStatus.isRunning()) {
            playGame(answer, COUNT_OF_NUMBERS);
        }
    }

    private Numbers initProcess() {
        return baseballGame.generateNumbers(COUNT_OF_NUMBERS);
    }

    private void playGame(Numbers answer, int count) {
        try {
            console.printOutput("숫자를 입력해주세요 : ");
            Numbers inputNumbers = baseballGame.convertToNumbers(console.getInput());

            BallCount ballCount = baseballGame.countBall(answer, inputNumbers);
            console.printOutput(ballCount.toString());

            if (ballCount.isAllStrike(COUNT_OF_NUMBERS)) {
                gameStatus.quitProgram();
                checkGoOrStop(ballCount);
            }

        } catch (IllegalArgumentException e) {
            console.printOutput(e.getMessage());
        }
    }

    private void checkGoOrStop(BallCount ballCount) {
        console.printOutput(COUNT_OF_NUMBERS + "개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        switch (console.getInput()) {
            case "1":
                gameStatus.restartProgram();
                run();
                break;
            case "2":
                console.printOutput("게임이 종료되었습니다.");
                gameStatus.quitProgram();
        }
    }
}

class BaseballGame {
    Validator validator;
    Computer computer;
    Player player;

    BaseballGame(Validator validator, Computer computer, Player player) {
        this.validator = validator;
        this.computer = computer;
        this.player = player;
    }

    public Numbers generateNumbers(int count) {
        return computer.getRandomNumbers(count);
    }

    public Numbers convertToNumbers(String inputString) {
        if (validator.isRightFormat(inputString)) {
            return player.parseToNumbers(inputString);
        }
        throw new IllegalArgumentException("잘못된 입력입니다.");
    }

    public BallCount countBall(Numbers answer, Numbers inputNumbers) {
        AtomicInteger strike = new AtomicInteger();
        AtomicInteger ball = new AtomicInteger();

        answer.indexedForEach((a, i) -> {

            inputNumbers.indexedForEach((n, j) -> {
                if (!a.equals(n)) return;
                if (i.equals(j)) strike.addAndGet(1);
                else ball.addAndGet(1);
            });
        });

        return new BallCount(ball.get(), strike.get());
    }
}

class Computer {
    private NumbersGenerator numbersGenerator;
    private Numbers numbers;

    public Computer(NumbersGenerator numbersGenerator, Numbers numbers) {
        this.numbersGenerator = numbersGenerator;
        this.numbers = numbers;
    }

    public Numbers getRandomNumbers(int count) {
        return numbersGenerator.generate(count);
    }
}

class Player {
    private Numbers numbers;

    public Player(Numbers numbers) {
        this.numbers = numbers;
    }

    public Numbers parseToNumbers(String inputString) {
        return numbers.parseToNumbers(inputString);
    }
}

class BallCount {
    private int ball;
    private int strike;

    BallCount(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public boolean isAllStrike(int count) {
        if (strike == count) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String result = "";

        if (ball != 0) {
            result += ball + "볼 ";
        }

        if (strike != 0) {
            result += strike + "스트라이크";
        }

        if (result.length() == 0) {
            result = "낫싱";
        }

        return result;
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

    public void quitProgram() {
        this.status = false;
    }

    public void restartProgram() {
        this.status = true;
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

    public void indexedForEach(BiConsumer<Integer, Integer> consumer) {
        for (int i = 0; i < numbers.size(); i++) {
            consumer.accept(numbers.get(i), i);
        }
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
