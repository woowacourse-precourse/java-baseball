package baseball;

import static baseball.Computer.NUMBER_COUNT_TO_CREATED;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.IntStream;

public class BaseballGame {

    private Computer computer;
    private int strikeCount;
    private int ballCount;

    public BaseballGame() {
        this.computer = new Computer();
    }

    public void start() {
        computer.createRandomNumbers();
        do {
            String input = inputAnswer();
            calculateBallCount(input);
            answerMessage();
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


    private void answerMessage() {
        if (strikeCount == 0 && ballCount != 0) {
            System.out.println(ballCount + "볼");
        }

        if (strikeCount != 0 && ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        }

        if (strikeCount != 0 && ballCount != 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }

        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        }
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
