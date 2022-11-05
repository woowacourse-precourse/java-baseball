package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {

    private static final int DIGIT_LENGTH = 3;

    /**
     * 게임을 시작 할 때 생성하는 랜덤 넘버 3개 (이때 각 숫자는 중복이 없다)
     *
     * @return 랜덤으로 생성된 숫자를 가지는 List
     */
    public static List<Integer> generateRandomNumber() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomValue = Randoms.pickNumberInRange(1, 9);

            if (randomNumbers.contains(randomValue)) continue;

            randomNumbers.add(randomValue);
        }

        return randomNumbers;
    }


    /**
     * "숫자를 입력해주세요"를 출력하고 사용자의 입력을 받는 함수
     *
     * @return 사용자의 입력 문자열
     */
    public static String receiveUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    /**
     * 사용자가 입력한 문자열을 Integer List로 변환하는 함수
     *
     * @param userInput 사용자의 입력 문자열
     * @return 변환된 IntegerList
     */
    public static List<Integer> userInputStrToIntegerList(String userInput) {
        List<Integer> userInputList = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            char singleCh = userInput.charAt(i);

            int numericValue = Character.getNumericValue(singleCh);
            userInputList.add(numericValue);
        }

        return userInputList;
    }

    /**
     * 사용자가 입력한 문자열이 오직 숫자 3개인지 확인하는 함수
     *
     * @param userInput 사용자가 입력한 문자열
     * @return 숫자 3개인지 여부
     */
    public static boolean checkUserInput(String userInput) {
        return userInput.matches("\\d\\d\\d");
    }

    public static int countStrike(List<Integer> answerList, List<Integer> userInputList) {
        int strike = 0;
        for (int i = 0; i < DIGIT_LENGTH; i++) {
            int answer = answerList.get(i);
            int userInput = userInputList.get(i);

            if (answer == userInput)
                strike++;
        }

        return strike;
    }

    public static int countBall(List<Integer> answerList, List<Integer> userInputList) {
        int ball = 0;
        for (int i = 0; i < DIGIT_LENGTH; i++) {
            int answer = answerList.get(i);
            int userInput = userInputList.get(i);

            if (answer != userInput && answerList.contains(userInput))
                ball++;
        }

        return ball;
    }

    public static void printResult(int strike, int ball) {
        String result = "";

        if (strike == 0 && ball == 0) result = "낫싱";

        if (ball > 0) result += String.format("%d볼 ", ball);
        if (strike > 0) result += String.format("%d스트라이크", strike);
        result = result.trim();

        System.out.println(result);
    }

    public static void game() {
        List<Integer> randomNumbers = generateRandomNumber();

        while (true) {
            String userInputStr = receiveUserInput();

            boolean validation = checkUserInput(userInputStr);

            if (!validation) throw new IllegalArgumentException("3자리의 숫자만 입력해야합니다.");

            List<Integer> userInput = userInputStrToIntegerList(userInputStr);

            int strike = countStrike(randomNumbers, userInput);
            int ball = countBall(randomNumbers, userInput);

            printResult(strike, ball);

            if(strike == DIGIT_LENGTH)
                break;
        }
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        game();
    }
}
