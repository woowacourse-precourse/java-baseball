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
        System.out.println("컴퓨터 랜덤 숫자 : " + computerNumberResult);
        System.out.println(countStrike(inputNumber,computerNumberResult) + "스트라이크");
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
        if (userInput.substring(0,1).equals(computerInput.substring(0,1))) {
            strikeCount ++;
        }
        if (userInput.substring(1,2).equals(computerInput.substring(1,2))) {
            strikeCount ++;
        }
        if (userInput.substring(2,3).equals(computerInput.substring(2,3))) {
            strikeCount ++;
        }
        return  strikeCount;
    }
}