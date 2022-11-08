package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> baseballNumber = BaseballNumber.create();
        List<Integer> inputNumber = new ArrayList<>();

        while (!baseballNumber.equals(inputNumber)) {
            inputNumber = inputNumber();
            int strike = BaseballNumber.countStrike(baseballNumber,inputNumber);
            int ball = BaseballNumber.countBall(baseballNumber,inputNumber);
            BaseballNumber.printMessage(strike, ball);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
    }

    private static List<Integer> inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputData = Console.readLine();
        validateNumber(inputData);

        List<Integer> inputNumber = new ArrayList<>();
        for (char digit : inputData.toCharArray()) {
            inputNumber.add(digit - 48);
        }

        return inputNumber;
    }

    private static void validateNumber(String inputData) {
        try {
            Integer.parseInt(inputData);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("the input only allows integer");
        }

        if (inputData.length() != 3) {
            throw new IllegalArgumentException("the input only allows three-digit numbers");
        }

        for (char digit : inputData.toCharArray()) {
            if (digit == '0') {
                throw new IllegalArgumentException("each digit only allows 1~9");
            }
        }
    }
}