package baseball.controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.stream.IntStream;

import static baseball.Constants.*;
import static baseball.domain.Computer.*;
import static baseball.domain.User.*;
import static baseball.message.ExceptionMessage.*;
import static baseball.message.OutputMessage.*;

public class BaseballGame {

    public static void run(){
        printGameStartMessage(); //
        do {
            playGame();
            retryGameMessage();
        } while (retryGame());
    }
    private static void playGame() {
        int strikeResult;
        int ballResult;
        String computerNumberResult = computerRandomNumberResult();
        do {
            numberInputMessage();
            String userNumberResult = inputUserNumber();
            ballResult = countBall(userNumberResult, computerNumberResult);
            strikeResult = countStrike(userNumberResult, computerNumberResult);
            if (!checkedNotThing(ballResult, strikeResult)) {
                if (ballResult > ZERO) {
                    System.out.print(ballResult+ "볼 ");
                }
                if (strikeResult > ZERO) {
                    System.out.print(strikeResult+ "스트라이크 ");
                }
            }
        } while (strikeResult != 3);
        printGameSetMessage();
    }
    private static boolean retryGame() {
        String reGameInput = Console.readLine();
        if (reGameInput.equals("1")) {
            return true;
        }
        if (reGameInput.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException(ILLEGAL_ERR_MSG);
    }

    /**
     * 유저의 입력값과 컴퓨터의 입력값을 받아 스트라이크 갯수를 리턴
     */
    private static int countStrike (String userInputNumber, String computerInputNumber) {
        return (int) IntStream.range(0,3)
                .filter(i -> userInputNumber.charAt(i) == computerInputNumber.charAt(i))
                .count();
    }

    /**
     * 유저의 입력값과 컴퓨터의 입력값을 받아 볼의 갯수를 리턴
     */
    private static int countBall (String userInputNumber, String computerInputNumber) {
        return (int) userInputNumber.chars()
                .map(value -> (char) value - INT_TO_CHAR_CONVERSION_CONSTANT)
                .mapToObj(String::valueOf)
                .filter(computerInputNumber::contains)
                .count() - countStrike(userInputNumber,computerInputNumber);
    }

    /**
     * 볼의 갯수와 스트라이크의 갯수를 입력 받아서 '낫싱'을 확인
     */
    private static boolean checkedNotThing (int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0 ){
            System.out.print("낫싱");
            return true;
        }
        return false;
    }
}
