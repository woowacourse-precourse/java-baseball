package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final int DIGIT_LENGTH = 3;
    private static final String INPUT_PATTERN = "\\d".repeat(DIGIT_LENGTH);

    /**
     * 게임을 시작 할 때 생성하는 랜덤 넘버 3개 (이때 각 숫자는 중복이 없다)
     *
     * @return 랜덤으로 생성된 숫자를 가지는 List
     */
    public static List<Integer> generateRandomNumber() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < DIGIT_LENGTH) {
            int randomValue = Randoms.pickNumberInRange(1, 9);

            if (randomNumbers.contains(randomValue)) continue;

            randomNumbers.add(randomValue);
        }

        return randomNumbers;
    }


    /**
     * "숫자를 입력해주세요"를 출력하고 사용자의 입력을 받는 함수
     *
     * @return 사용자의 입력
     */
    public static List<Integer> receiveUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInputStr = Console.readLine();

        boolean validation = checkUserInput(userInputStr);

        if (!validation) throw new IllegalArgumentException(String.format("%d자리의 숫자만 입력해야합니다.", DIGIT_LENGTH));

        return userInputStrToIntegerList(userInputStr);
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
     * 사용자가 입력한 문자열이 입력 패턴과 일치하는 지 검사하는 함수
     *
     * @param userInput 사용자가 입력한 문자열
     * @return 패턴 일치 여부
     */
    public static boolean checkUserInput(String userInput) {

        return userInput.matches(INPUT_PATTERN);
    }

    /**
     * 스트라이크 갯수를 파악하는 함수
     *
     * @param answerList    정답
     * @param userInputList 사용자의 입력
     * @return 스트라이크 갯수
     */
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

    /**
     * 볼 갯수를 파악하는 함수
     *
     * @param answerList    정답
     * @param userInputList 사용자 입력
     * @return 볼 갯수
     */
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

    /**
     * 게임 결과를 출력하는 함수
     *
     * @param strike 스트라이크 횟수
     * @param ball   볼 횟수
     */
    public static void printResult(int strike, int ball) {
        String result = "";

        if (strike == 0 && ball == 0) result = "낫싱";

        if (ball > 0) result += String.format("%d볼 ", ball);
        if (strike > 0) result += String.format("%d스트라이크", strike);
        result = result.trim();

        System.out.println(result);
    }

    /**
     * 다음 게임을 진행할지 사용자의 입력을 받아 판단하는 함수
     *
     * @return 다음 게임 진행 여부
     */
    public static boolean checkNextGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String userInput = Console.readLine();

        return userInput.equals("1");
    }

    /**
     * 단판 숫자 야구 게임을 진행하는 함수
     */
    public static void game() {
        List<Integer> randomNumbers = generateRandomNumber();

        while (true) {
            List<Integer> userInput = receiveUserInput();

            int strike = countStrike(randomNumbers, userInput);
            int ball = countBall(randomNumbers, userInput);

            printResult(strike, ball);

            if (strike == DIGIT_LENGTH) {
                System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", DIGIT_LENGTH);
                break;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            game();
        } while (checkNextGame());

    }
}
