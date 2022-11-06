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
        do {
            playGame();
        } while (reGameMessage());
    }

    static void playGame() {
        int strikeResult;
        int ballResult;
        do {
            System.out.print("숫자를 입력해 주세요 : ");
            String userInput = Console.readLine();
            checkedValidate(userInput);
            List<Integer> computerNumber = generateComputerNumber();
            String computerNumberResult = computerNumberListToString(computerNumber);

            strikeResult = countStrike(userInput, computerNumberResult);
            ballResult = countBall(userInput, computerNumberResult);
            if (!checkedNotThing(ballResult, strikeResult)) {
                if (ballResult != ZERO) {
                    System.out.print(ballResult+ "볼 ");
                }
                if (strikeResult != ZERO) {
                    System.out.print(strikeResult+ "스트라이크 ");
                }
            }
            System.out.println();
        } while (strikeResult != 1);
        gameSet();
    }

    public static boolean reGameMessage() {
        String reGameInput = Console.readLine();
        if (reGameInput.equals("1")) {
            return true;
        }
        if (reGameInput.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException(ILLEGAL_ERR_MSG);
    }

    static void checkedValidate(String input) {
        validateInputRange(input);
        checkDuplicatedNumber(input);
        validateContainZero(input);
    }

    static void gameStart() {
        System.out.println(GAME_START_MSG);
    }

    static void gameSet(){
        System.out.println(GAME_END_MSG);
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
            System.out.print("낫싱");
            return true;
        }
        return false;
    }
}