package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {

    }

    /**
     * 컴퓨터가 생성하는 1-9 사이의 서로 다른 임의의 숫자로 이루어진 3개의 수로 이루어진 리스트를 생성
     */
    private static List<Integer> getThreeRandomNumbersList() {
        List<Integer> computerNumberList = new ArrayList<>();

        while (computerNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumberList.contains(randomNumber)) {
                computerNumberList.add(randomNumber);
            }
        }

        return computerNumberList;
    }

    /**
     * String 형의 유저 입력을 List<Integer>형으로 변환
     */
    private static List<Integer> getStringInputToList(String userInput) {
        String[] splitUserInput = userInput.split("");
        List<String> userInputList = new ArrayList<>(List.of(splitUserInput));
        List<Integer> userInputIntegerList = new ArrayList<>();

        for (String oneInputNumber : userInputList) {
            userInputIntegerList.add(Integer.valueOf(oneInputNumber));
        }

        return userInputIntegerList;
    }

    /**
     * 유저로부터 입력받은 값이 컴퓨터가 생성한 값과 일치하는지 판별
     */
    private static boolean isUserComputerNumberCorrespond(String userInput, List<Integer> computerNumber) {
        List<Integer> userNumbers = getStringInputToList(userInput);

        return userNumbers.equals(computerNumber);
    }

    /**
     * 스트라이크 수를 계산
     */
    private static int getStrikes(List<Integer> userInputNumber, List<Integer> computerNumber) {
        int strike = 0;

        /* 스트라이크 수 계산 */
        for (int i = 0; i < userInputNumber.size(); i++) {
            if (Objects.equals(userInputNumber.get(i), computerNumber.get(i))) {
                strike += 1;
            }
        }

        return strike;
    }

    /**
     * 볼 수를 계산
     */
    private static int getBalls(List<Integer> userInputNumber, List<Integer> computerNumber) {
        int strike = getStrikes(userInputNumber, computerNumber);
        int ball = 0;

        /* 볼 수 계산 */
        for (Integer oneOfUserNum : userInputNumber) {
            if (computerNumber.contains(oneOfUserNum)) {
                ball += 1;
            }
        }
        ball -= strike; // ball 계산하며 strike 중복 계산 제거

        return ball;
    }
}
