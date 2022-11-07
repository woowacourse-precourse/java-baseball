package baseball;

import baseball.Util.Valid;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameSimulation {
    private Computer computer;
    private Integer strike;
    private Integer ball;
    private static final boolean INVALID = false;

    public GameSimulation(Computer computer) {
        this.computer = computer;
        this.strike = 0;
        this.ball = 0;
    }

    public void init() {
        computer.init();
        strike = 0;
        ball = 0;
    }

    public void playGame() {
        List<Integer> userNumber;

        while (strike < 3) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = readLine();
            validateDataType(userInput);
            userNumber = makeList(userInput);

            validateCount(userNumber);
            validateRange(userNumber);

            ball = computer.addBallScore(userNumber);
            strike = computer.addStrikeScore(userNumber);

            System.out.println(checkResult());
        }
    }

    private void validateRange(List<Integer> userNumber) {
        for (int number : userNumber) {
            if (number < 1 || 9 < number) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateDataType(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> makeList(String userInput) {
        String[] bitInput = userInput.split("");
        return Arrays
                .stream(bitInput)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void validateCount(List<Integer> userNumber) {

        if (userNumber.size() != 3) {
            throw new IllegalArgumentException("올바른 숫자가 아닙니다. 다시 입력해주세요.");
        }
        if (userNumber.stream().distinct().count() != userNumber.size()) {
            throw new IllegalArgumentException();
        }

        }

        public String checkResult () {
            if (ball != 0 && strike != 0) {
                return (ball + "볼" + " " + strike + "스트라이크");
            }
            if (ball == 0 && strike != 0) {
                return (strike + "스트라이크");
            }
            if (ball != 0 && strike == 0) {
                return (ball + "볼");
            }

            return ("낫싱");
        }

    }
