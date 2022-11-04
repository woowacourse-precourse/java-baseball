package baseball;

import static baseball.Computer.NUMBER_COUNT_TO_CREATED;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.IntStream;

public class BaseballGame {

    private int strikeCount;
    private int ballCount;

    private Computer computer;
    private MessageCreator messageCreator;

    public BaseballGame() {
        this.computer = new Computer();
        this.messageCreator = new MessageCreator();
    }

    public void start() {
        computer.createRandomNumbers();
        do {
            String input = inputAnswer();
            calculateBallCount(input);
            messageCreator.printResultMessage(strikeCount, ballCount);
        } while ((strikeCount != 3));

        computer.clearRandomNumbers();
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private String inputAnswer() {
        String input = Console.readLine();
        isWrongInputValue(input);
        System.out.println("숫자를 입력해주세요 : " + input);
        return input;
    }

    private void calculateBallCount(String input) {
        List<Integer> computerNumbers = computer.getRandomNumbers();
        strikeCount = (int)IntStream.range(0, 3)
                .filter(idx -> computerNumbers.get(idx).equals(Integer.parseInt(String.valueOf(input.charAt(idx)))))
                .count();

        ballCount = (int) IntStream.range(0, 3)
                .filter(idx -> input.contains(String.valueOf(computerNumbers.get(idx))))
                .filter(idx -> !computerNumbers.get(idx).equals(Integer.parseInt(String.valueOf(input.charAt(idx)))))
                .count();
    }

    private void isWrongInputValue(String input) {
        if (input.length() != NUMBER_COUNT_TO_CREATED) {
            throw new IllegalArgumentException();
        }

        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }

        if (input.contains("0")) {
            throw new IllegalArgumentException();
        }

        if (input.length() != input.chars().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }
}
