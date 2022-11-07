package baseball.Controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static baseball.Constants.*;
import static baseball.Domain.Computer.*;
import static baseball.Domain.User.*;
import static baseball.Message.OutputMessage.*;


public class StartBaseBallGame {

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
            String userInput = inputUserNumber();
            System.out.println("컴퓨터의 숫자 : " + computerNumberResult); // 지우는거
            ballResult = countBall(userInput, computerNumberResult); // 판단
            strikeResult = countStrike(userInput, computerNumberResult); // 판단
            if (!checkedNotThing(ballResult, strikeResult)) {
                if (ballResult > ZERO) {
                    System.out.print(ballResult+ "볼 ");
                }
                if (strikeResult > ZERO) {
                    System.out.print(strikeResult+ "스트라이크 ");
                }
            }
            System.out.println();
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
    private static int countStrike (String userInput, String computerInput) {
        return (int) IntStream.range(0,3)
                .filter(i -> userInput.charAt(i) == computerInput.charAt(i))
                .count();
    }
    /**
     * 유저의 입력값과 컴퓨터의 입력값을 받아 볼의 갯수를 리턴
     */
    private static int countBall (String userInput, String computerInput) {
        return (int) userInput.chars()
                .map(value -> (char) value - INT_TO_CHAR_CONVERSION_CONSTANT)
                .mapToObj(String::valueOf)
                .filter(computerInput::contains)
                .count() - countStrike(userInput,computerInput);
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
