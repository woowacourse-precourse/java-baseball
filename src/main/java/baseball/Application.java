package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

/** 기능 목록
 * 1. 컴퓨터가 1 ~ 9 까지 서로 다른 임의의 수 3개를 선택
 *   1-1. 요구사항에 나와있는 라이브러리를 사용하여 구현한다.
 *
 * 2. 사용자로부터 입력받기
 *   2-1. 예외 사항 처리
 *      a) 자릿수가 3자리가 아닌 경우
 *      b) 각 자리수가 중복이 아닌 경우
 *      c) 각 자리수가 1 ~ 9 가 아닌 경우
 *
 * 3. 볼/스트라이크 여부 확인
 *   3-1. 숫자 포함 여부를 인덱스로 판단
 *   3-2. 얻은 인덱스를 별도의 BullsAndCowsResult 객체를 통해 판단
 *
 **/

public class Application {
    public static void main(String[] args) {

        while (true) {
            BullsAndCows bullsAndCows = new BullsAndCows(creatRandomNumber(), new BullsAndCowsResult());

            while (!bullsAndCows.bullsAndCowsResult.finish()) {
                bullsAndCows.start();
            }

            boolean bullsAndCowsContinue = bullsAndCows.isContinue();
            if (!bullsAndCowsContinue) {
                break;
            }
        }
    }

    private static List<Integer> creatRandomNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {

            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    static class BullsAndCows {

        List<Integer> computerNumber;
        BullsAndCowsResult bullsAndCowsResult;

        public BullsAndCows(List<Integer> computerNumber, BullsAndCowsResult bullsAndCowsResult) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            this.computerNumber = computerNumber;
            this.bullsAndCowsResult = bullsAndCowsResult;
        }

        void start() {

            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();
            List<Integer> userInputNumber = checkExceptionAndInputToList(userInput);

            bullsAndCowsResult.init();

            for (int i = 0; i < computerNumber.size(); i++) {
                int userIndex = findNumberIndex(userInputNumber, computerNumber.get(i));
                bullsAndCowsResult.addCount(userIndex, i);
            }

            bullsAndCowsResult.printResult();
        }

        boolean isContinue() {

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String answer = Console.readLine();

            return answer.equals("1");
        }
    }

    private static int findNumberIndex(List<Integer> userInputNumber, int c) {

        if (userInputNumber.contains(c)) {
            return userInputNumber.indexOf(c);
        } else {
            return -1;
        }
    }

    private static List<Integer> checkExceptionAndInputToList(String userInput) throws IllegalArgumentException {

        if (userInput.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자가 아닙니다.");
        }

        List<Integer> userInputNumber = new ArrayList<>();

        char[] charArray = userInput.toCharArray();

        for (char c : charArray) {

            int number = (int) c - '0';

            if (!isValidNumber(number)) {
                throw new IllegalArgumentException("1 ~ 9 사이 숫자가 아닙니다.");
            }

            if (userInputNumber.contains(number)) {
                throw new IllegalArgumentException("서로 다른 숫자가 아닙니다.");
            }

            userInputNumber.add(number);
        }

        return userInputNumber;
    }

    private static boolean isValidNumber(int number) {
        return 1 <= number && number <= 9;
    }

    static class BullsAndCowsResult {

        int ballCount;
        int strikeCount;

        void init() {
            ballCount = 0;
            strikeCount = 0;
        }

        void addCount(int userIndex, int computerIndex) {

            if (userIndex == -1) {
                return;
            }

            if (userIndex == computerIndex) {
                strikeCount++;
                return;
            }

            ballCount++;
        }

        void printResult() {

            if (ballCount == 0 && strikeCount == 0) {
                System.out.println("낫싱");
            } else if (strikeCount == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다!! 게임 종료");
            } else {
                System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
            }
        }

        boolean finish() {
            return strikeCount == 3;
        }
    }
}
