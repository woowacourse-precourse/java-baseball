package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    private static final int RESULT_SIZE = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");
        String inputNumber = Console.readLine();

        List<Integer> computerNumber = generateComputerNumber();
        String computerNumberResult = computerNumberListToString(computerNumber);
        int strikeResult = countStrike(inputNumber,computerNumberResult);
        int ballResult = countBall(inputNumber, computerNumberResult);
        System.out.println("컴퓨터 랜덤 숫자 : " + computerNumberResult);

        if (!checkedNotThing(ballResult, strikeResult)) {
            System.out.println(countBall(inputNumber,computerNumberResult) + "볼");
            System.out.println(countStrike(inputNumber,computerNumberResult) + "스트라이크");
        }


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
        // 볼이 되려면 우선적으로 같은 자리 같은 숫자가 없는 조건을 걸어야함 그리고 거기서 해당 숫자들의 contains를 확인해야한다.
        // 볼의 갯수를 먼저 센 다음에 볼에서 스트라이크의 숫자를 빼면 진짜 볼의 갯수가 나올 듯 ?
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