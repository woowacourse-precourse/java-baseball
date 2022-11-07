package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import static baseball.Validator.*;
import static baseball.Constants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        printGameStartMessage(); //
        do {
            playGame();
            retryGameMessage();
        } while (retryGame());
        /*
        1. 난수 생성
        2. 유저 입력
        3. 볼 스트라이크 체크
        4. 다시하기
        큰 함수를 봤을 때 흐름이 보여야 한다.
         */
    }
    static void playGame() {
        int strikeResult;
        int ballResult;
        List<Integer> computerNumber = generateComputerNumber();
        String computerNumberResult = computerNumberListToString(computerNumber);
        do {
            numberInputMessage();
            String userInput = Console.readLine();
            System.out.println("컴퓨터의 숫자 : " + computerNumberResult);
            checkedValidate(userInput);
            strikeResult = countStrike(userInput, computerNumberResult);
            ballResult = countBall(userInput, computerNumberResult);
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
    public static void numberInputMessage(){
        System.out.println(NUMBER_INPUT_MSG);
    }
    public static void retryGameMessage(){
        System.out.println(REGAME_SUGGESTION_MSG);
    }
    public static boolean retryGame() {
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

    static void printGameStartMessage() {
        System.out.println(GAME_START_MSG);
    }

    static void printGameSetMessage(){
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
        return (int) IntStream.range(0,3)
                .filter(i -> userInput.charAt(i) == computerInput.charAt(i))
                .count();
    }
    /**
     * 유저의 입력값과 컴퓨터의 입력값을 받아 볼의 갯수를 리턴
     */
    static int countBall (String userInput, String computerInput) {
        return (int) userInput.chars()
                .map(value -> (char) value)
                .mapToObj(String::valueOf)
                .filter(computerInput::contains)
                .count() - countStrike(userInput,computerInput);
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