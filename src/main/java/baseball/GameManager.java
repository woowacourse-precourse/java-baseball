package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.stream.IntStream;

import static baseball.Constants.*;
import static baseball.message.ExceptionMessage.ILLEGAL_ERR_MSG;
import static baseball.message.OutputMessage.*;
import static baseball.message.OutputMessage.printGameSetMessage;

public class GameManager {
    Computer computer = new Computer();
    User user = new User();
    public void playGame() {
        int strikeResult;
        int ballResult;
        String computerNumberResult = computer.randomNumberResult(); //
        do {
            printNumberInputMessage();
            String userInput = user.inputUserNumber();
            ballResult = countBall(userInput, computerNumberResult);
            strikeResult = countStrike(userInput, computerNumberResult);
            printResult(ballResult, strikeResult);
        } while (strikeResult != THREE_STRIKE);
        printGameSetMessage();
    }


    private int countStrike (String userInputNumber, String computerInputNumber) {
        return (int) IntStream.range(0,3)
                .filter(i -> userInputNumber.charAt(i) == computerInputNumber.charAt(i))
                .count();
    }

    private int countBall (String userInputNumber, String computerInputNumber) {
        return (int) userInputNumber.chars()
                .map(value -> (char) value - INT_TO_CHAR_CONVERSION_CONSTANT)
                .mapToObj(String::valueOf)
                .filter(computerInputNumber::contains)
                .count() - countStrike(userInputNumber,computerInputNumber);
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
    // 유저에게 게임을 다시할껀지 물어봄
    public String inputReGameStartNumber() {
        return Console.readLine();
    }

    public boolean checkRetryGame(String reGameInputNumber) {
        if (reGameInputNumber.equals("1")) {
            return true;
        }
        if (reGameInputNumber.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException(ILLEGAL_ERR_MSG);
    }
}
