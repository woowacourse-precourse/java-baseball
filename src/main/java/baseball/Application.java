package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        new BaseballController(new IOManager(new Input(), new Output(), new Validator()),
                new GameStatus(),
                new BaseballGame(new Computer(new NumbersGenerator(), new Numbers()), new Player(new Numbers())))
                .run();
    }
}

class BaseballController {
    private final int COUNT_OF_NUMBERS = 3;

    private IOManager ioManager;
    private GameStatus gameStatus;
    private BaseballGame baseballGame;

    BaseballController(IOManager ioManager, GameStatus gameStatus, BaseballGame baseballGame) {
        this.ioManager = ioManager;
        this.gameStatus = gameStatus;
        this.baseballGame = baseballGame;
        ioManager.printOutput("숫자 야구 게임을 시작합니다.");
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
        ioManager.printOutput("숫자를 입력해주세요 : ");
        String inputString = "";

        try {
            inputString = ioManager.getInput();
        } catch (IllegalArgumentException e) {
            ioManager.printOutput(e.getMessage());
        }
        
        Numbers inputNumbers = baseballGame.convertToNumbers(inputString);

        BallCount ballCount = baseballGame.countBall(answer, inputNumbers);
        ioManager.printOutput(ballCount.toString());

        if (ballCount.isAllStrike(COUNT_OF_NUMBERS)) {
            gameStatus.quitProgram();
            checkGoOrStop(ballCount);
        }

    }

    private void checkGoOrStop(BallCount ballCount) {
        ioManager.printOutput(COUNT_OF_NUMBERS + "개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        switch (ioManager.getInput()) {
            case "1":
                gameStatus.restartProgram();
                run();
                break;
            case "2":
                ioManager.printOutput("게임이 종료되었습니다.");
                gameStatus.quitProgram();
        }
    }
}

class BaseballGame {
    Computer computer;
    Player player;

    BaseballGame(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public Numbers generateNumbers(int count) {
        return computer.getRandomNumbers(count);
    }

    public Numbers convertToNumbers(String inputString) {
        return player.parseToNumbers(inputString);
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

    public String input() {
        return Console.readLine();
    }
}

class Output {
    public void printOutput(String message) {
        System.out.println(message);
    }
}

class IOManager {
    Input input;
    Output output;
    Validator validator;

    IOManager(Input input, Output output, Validator validator) {
        this.input = input;
        this.output = output;
        this.validator = validator;
    }

    public String getInput() {
        String inputString = input.input();
        if (validator.isRightFormat(inputString)) {
            return inputString;
        }
        throw new IllegalArgumentException("잘못된 입력입니다.");
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
