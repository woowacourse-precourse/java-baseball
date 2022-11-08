package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
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
        ioManager.printIntro();
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
        ioManager.printRequestInput();

        try {
            String inputString = ioManager.getInputNumbers();
            Numbers inputNumbers = baseballGame.convertToNumbers(inputString);

            BallCount ballCount = baseballGame.countBall(answer, inputNumbers);
            ioManager.printHint(ballCount);

            if (ballCount.isAllStrike(COUNT_OF_NUMBERS)) {
                gameStatus.quitProgram();
                checkGoOrStop(ballCount);
            }

        } catch (IllegalArgumentException e) {
            ioManager.printError();
            gameStatus.quitProgram();
        }
    }

    private void checkGoOrStop(BallCount ballCount) {
        ioManager.printAllStrike(COUNT_OF_NUMBERS);

        try {
            switch (OrderType.getMenuType(ioManager.getInputOrder())) {
                case RESTART:
                    gameStatus.restartProgram();
                    run();
                    break;
                case STOP:
                    ioManager.printExit();
            }
        } catch (IllegalArgumentException e) {
            ioManager.printError();
        }
    }
}

enum OrderType {
    RESTART("1"),
    STOP("2");

    private final String orderType;

    OrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderType() {
        return orderType;
    }

    public static OrderType getMenuType(String inputString) {
        for (OrderType type : OrderType.values()) {
            if (type.getOrderType().equals(inputString)) return type;
        }
        throw new IllegalArgumentException(Message.WRONG_ORDER_MESSAGE.toString());
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
            result += ball + Message.BALL_MESSAGE.toString();
        }

        if (strike != 0) {
            result += strike + Message.STRIKE_MESSAGE.toString();
        }

        if (result.length() == 0) {
            result = Message.NOTHING_MESSAGE.toString();
        }

        return result;
    }
}

class Validator {
    private static final Pattern pattern = Pattern.compile("^[1-9]{3}");
    private static List<Character> inputs = new ArrayList<>();

    public boolean isRightFormat(String inputString) {
        inputs.clear();
        if (isThree(inputString) && isDuplicate(inputString)) {
            return true;
        }
        return false;
    }

    public boolean isThree(String inputString) {
        return pattern.matcher(inputString).matches();
    }

    public boolean isDuplicate(String inputString) {
        char[] input = inputString.toCharArray();
        for (char number : input) {
            if (inputs.contains(number)) {
                return false;
            }
            inputs.add(number);
        }
        return true;
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

class Output<T> {
    public void printOutput(T message) {
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

    public String getInputNumbers() {
        String inputString = input.input();
        if (validator.isRightFormat(inputString)) {
            return inputString;
        }
        throw new IllegalArgumentException(Message.WRONG_ORDER_MESSAGE.toString());
    }

    public String getInputOrder() {
        return input.input();
    }

    public void printIntro() {
        output.printOutput(Message.INTRO_MESSAGE);
    }

    public void printRequestInput() {
        output.printOutput(Message.INPUT_NUMBER_MESSAGE);
    }

    public void printHint(BallCount ballCount) {
        output.printOutput(ballCount);
    }

    public void printAllStrike(int count) {
        output.printOutput(count + Message.SUCCESS_MESSAGE.toString());
    }

    public void printError() {
        output.printOutput(Message.WRONG_ORDER_MESSAGE.toString() + Message.EXIT_MESSAGE.toString());
    }

    public void printExit() {
        output.printOutput(Message.EXIT_MESSAGE);
    }
}

enum Message {
    INTRO_MESSAGE("숫자 야구 게임을 시작합니다."),
    INPUT_NUMBER_MESSAGE("숫자를 입력해주세요 : "),
    SUCCESS_MESSAGE("개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    WRONG_ORDER_MESSAGE("잘못된 입력입니다."),
    EXIT_MESSAGE("게임이 종료되었습니다."),

    BALL_MESSAGE("볼 "),
    STRIKE_MESSAGE("스트라이크"),
    NOTHING_MESSAGE("낫싱");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
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
