package baseball;

import java.util.List;

import static baseball.Refree.*;

public class Application {
    public static void main(String[] args) {
        List<Integer> randomNumbers = RandomNumber.makeRandomNumber();

        while (true) {

            String userInputStr = InputNumber.PleaseInput();


            boolean validation = InputNumber.checkUserInput(userInputStr);

            if (!validation) throw new IllegalArgumentException("3자리의 숫자만 입력해야합니다.");

            List<Integer> userInput = InputNumber.InputNumber(userInputStr);

            int strike = countStrike(randomNumbers, userInput);
            int ball = countBall(randomNumbers, userInput);

            printResult(strike, ball);


            if (strike == DIGIT_LENGTH)
                break;
        }
    }
}