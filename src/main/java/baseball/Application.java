package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import static baseball.Validator.*;
import static baseball.Constants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        gameStart();

        int intUserInput = Integer.parseInt(Console.readLine());

        Validator validate = new Validator();
        validate.validateInputRange(intUserInput);
        validate.checkDuplicatedNumber(intUserInput);
        validate.validateContainZero(intUserInput);

        String stringUserInput = toStringUserInput(intUserInput);

        List<Integer> computerNumber = generateComputerNumber();
        String computerNumberResult = computerNumberListToString(computerNumber);

        int strikeResult = countStrike(stringUserInput,computerNumberResult);
        int ballResult = countBall(stringUserInput, computerNumberResult);

        System.out.println("컴퓨터 랜덤 숫자 : " + computerNumberResult);

        if (!checkedNotThing(ballResult, strikeResult)) {
            if (countBall(stringUserInput,computerNumberResult) != ZERO) {
                System.out.println(countBall(stringUserInput,computerNumberResult) + "볼 ");
            }
            if (countStrike(stringUserInput,computerNumberResult) != ZERO) {
                System.out.println(countStrike(stringUserInput,computerNumberResult) + "스트라이크");
            }
        }
    }
    static void gameStart() {
        System.out.println(GAME_START_MESSAGE);
    }
    /**
     * 예외처리 후 String 으로 다시 변환함
     */
    static String toStringUserInput(int userNumber) {
        return String.valueOf(userNumber);
    }

    /**
     * 컴퓨터의 랜덤한 세 자리 수를 List에 저장함
     */
    static List<Integer> generateComputerNumber() {
        List<Integer> computerNumberList = new ArrayList<>();
        for (int i = 0; i < RESULT_SIZE; i++) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (computerNumberList.contains(randomNumber)) {
                i--;
            }
            if (!computerNumberList.contains(randomNumber)) {
                computerNumberList.add(randomNumber);
            }
        }
        return computerNumberList;
    }

    /**
     * Integer List를 String 으로 변환함
     */
    static String computerNumberListToString(List<Integer> computerNumberList) {
        return computerNumberList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    /**
     * 유저의 입력값과 컴퓨터의 입력값을 받아 스트라이크 갯수를 리턴
     */
    static int countStrike (String userInput, String computerInput) {
        int strikeCount = 0;
        for (int i = 0; i < RESULT_SIZE; i++) {
            if (userInput.substring(i,i+1).equals(computerInput.substring(i,i+1))) {
                strikeCount ++;
            }
        }
        return  strikeCount;
    }
    /**
     * 유저의 입력값과 컴퓨터의 입력값을 받아 볼의 갯수를 리턴
     */
    static int countBall (String userInput, String computerInput) {

        int ballCount = 0;
        for (int i = 0; i < RESULT_SIZE; i++) {
            if (userInput.contains(computerInput.substring(i,i+1))) {
                ballCount ++;
            }
        }
        return ballCount - countStrike(userInput,computerInput);
    }

    /**
     * 볼의 갯수와 스트라이크의 갯수를 입력 받아서 '낫싱'을 확인
     */
    static boolean checkedNotThing (int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0 ){
            System.out.println("낫싱");
            return true;
        }
        return false;
    }
}