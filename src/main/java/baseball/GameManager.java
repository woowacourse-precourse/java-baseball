package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.stream.IntStream;

import static baseball.Computer.randomNumberResult;
import static baseball.Constants.*;
import static baseball.User.inputUserNumber;
import static baseball.message.ExceptionMessage.ILLEGAL_ERR_MSG;
import static baseball.message.OutputMessage.*;
import static baseball.message.OutputMessage.printGameSetMessage;

public class GameManager {
    public void playGame() {
        int strikeResult;
        int ballResult;
        String computerNumberResult = randomNumberResult(); //
        do {
            numberInputMessage();
            String userInput = inputUserNumber();
            ballResult = countBall(userInput, computerNumberResult);
            strikeResult = countStrike(userInput, computerNumberResult);
            printResult(ballResult, strikeResult);
        } while (strikeResult != 3);
        printGameSetMessage();
    }

    private void printResult(int ball, int strike) {
        if (ball == ZERO && strike == ZERO) {
            System.out.println("낫싱");
            return;
        }
        if (ball > ZERO) {
            System.out.print(ball+ "볼 ");
        }
        if (strike > ZERO) {
            System.out.print(strike+ "스트라이크 ");
        }
    }


    public boolean retryGame() {
        String reGameInput = Console.readLine();
        if (reGameInput.equals("1")) {
            return true;
        }
        if (reGameInput.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException(ILLEGAL_ERR_MSG);
    }

    private int countStrike (String userInputNumber, String computerInputNumber) {
        return (int) IntStream.range(0,3)
                .filter(i -> userInputNumber.charAt(i) == computerInputNumber.charAt(i))
                .count();
    }

    /**
     * 유저의 입력값과 컴퓨터의 입력값을 받아 볼의 갯수를 리턴
     */
    private int countBall (String userInputNumber, String computerInputNumber) {
        return (int) userInputNumber.chars()
                .map(value -> (char) value - INT_TO_CHAR_CONVERSION_CONSTANT)
                .mapToObj(String::valueOf)
                .filter(computerInputNumber::contains)
                .count() - countStrike(userInputNumber,computerInputNumber);
    }
}
