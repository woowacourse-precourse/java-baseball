package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import net.bytebuddy.asm.Advice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Application {
    private static final int RESULT_SIZE = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int MIN_ACCESS_INPUT_NUMBER = 122;
    private static final int MAX_ACCESS_INPUT_NUMBER = 987;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        /*
         * 사용자가 잘못된 값을 입력하는 경우의 수
         * 1. length가 3이 아닐 때
         * 2. 숫자에 0이 포함되어 있을 때
         * 3. 연속된 숫자가 존재할 때
         */

        int intUserInput = Integer.parseInt(Console.readLine());

        if (intUserInput < MIN_ACCESS_INPUT_NUMBER || intUserInput > MAX_ACCESS_INPUT_NUMBER) {
            throw new IllegalArgumentException("INPUT_ERROR");
        }
        if (intUserInput % 100 < 10 || intUserInput % 10 == 0) {
            throw new IllegalArgumentException("INPUT_ERROR");
        }
        // 연속된 숫자가 있는지 없는지 확인하기
        Set<Integer> userInputList = new HashSet<>();
        userInputList.add(intUserInput / 100);
        userInputList.add(intUserInput % 100 / 10);
        userInputList.add(intUserInput % 10);
        if (userInputList.size() != RESULT_SIZE) {
            throw new IllegalArgumentException("INPUT_ERROR");
        }

        String stringUserInput = toStringUserInput(intUserInput);

        List<Integer> computerNumber = generateComputerNumber();
        String computerNumberResult = computerNumberListToString(computerNumber);

        int strikeResult = countStrike(stringUserInput,computerNumberResult);
        int ballResult = countBall(stringUserInput, computerNumberResult);

        System.out.println("컴퓨터 랜덤 숫자 : " + computerNumberResult);

        if (!checkedNotThing(ballResult, strikeResult)) {
            if (countBall(stringUserInput,computerNumberResult) != 0) {
                System.out.println(countBall(stringUserInput,computerNumberResult) + "볼 ");
            }
            if (countStrike(stringUserInput,computerNumberResult) != 0) {
                System.out.println(countStrike(stringUserInput,computerNumberResult) + "스트라이크");
            }
        }
    }

    /*
     * 예외처리 이후 String 으로 다시 변환함
     */
    static String toStringUserInput(int userNumber) {
        return String.valueOf(userNumber);
    }

    /*
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

    /*
     * Integer List를 String 으로 변환함
     */
    static String computerNumberListToString(List<Integer> computerNumberList) {
        return computerNumberList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    static int countStrike (String userInput, String computerInput) {
        int strikeCount = 0;
        for (int i = 0; i < RESULT_SIZE; i++) {
            if (userInput.substring(i,i+1).equals(computerInput.substring(i,i+1))) {
                strikeCount ++;
            }
        }
        return  strikeCount;
    }

    static int countBall (String userInput, String computerInput) {

        int ballCount = 0;
        for (int i = 0; i < RESULT_SIZE; i++) {
            if (userInput.contains(computerInput.substring(i,i+1))) {
                ballCount ++;
            }
        }
        return ballCount - countStrike(userInput,computerInput);
    }
    static boolean checkedNotThing (int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0 ){
            System.out.println("낫싱");
            return true;
        }
        return false;
    }
}