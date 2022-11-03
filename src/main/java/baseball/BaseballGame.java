package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BaseballGame {

    public final static int NUMBER_COUNT_TO_CREATED = 3;

    private List<Integer> computerNumbers = new ArrayList<>();
    private int strikeCount;
    private int ballCount;
    private String message;

    public void start() {
        createComputerNumbers();
        inputAnswer();
    }

    private void inputAnswer() {
        while (true) {
            String input = Console.readLine();
            System.out.println("숫자를 입력해주세요 : " + input);
            isWrongInputValue(input);
            calculateBallCount(input);
            String msg = answerMessage();

            if (msg.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                computerNumbers.clear();
                break;
            }
        }
    }


    private String answerMessage() {

        if (strikeCount == 0 && ballCount != 0) {
            message = ballCount + "볼";
            System.out.println(message);
            return message;
        }

        if (strikeCount != 0 && ballCount == 0) {
            message = strikeCount + "스트라이크";
            System.out.println(message);
            return message;
        }

        if (strikeCount != 0 && ballCount != 0) {
            message = ballCount + "볼 " + strikeCount + "스트라이크";
            System.out.println(message);
            return message;
        }

        message = "낫싱";
        System.out.println(message);
        return message;
    }

    private void calculateBallCount(String input) {
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

    private void createComputerNumbers() {
        while (computerNumbers.size() < NUMBER_COUNT_TO_CREATED) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }
}
