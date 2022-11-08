package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.Refree.*;

public class Application {

    public static void game() {
        List<Integer> randomNumbers = RandomNumber.makeRandomNumber();

        while (true) {

            String userInputStr = InputNumber.PleaseInput();


            boolean validation = InputNumber.checkUserInput(userInputStr);

            if (!validation) throw new IllegalArgumentException("3자리의 숫자만 입력해야합니다.");

            List<Integer> userInput = InputNumber.InputNumber(userInputStr);

            int strike = countStrike(randomNumbers, userInput);
            int ball = countBall(randomNumbers, userInput);

            printResult(strike, ball);


            if (strike == DIGIT_LENGTH){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }

        }
    }
    public static boolean checkNextGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String userInput = Console.readLine();

        return userInput.equals("1");
    }
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            game();
        } while (checkNextGame());

    }
}