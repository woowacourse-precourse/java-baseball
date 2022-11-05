package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    private static final int NUMBER_LENGTH = 3;
    private static int strikeCnt;
    private static int ballCnt;

    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }

    private static List<Integer> generateComputerNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static List<Integer> readUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        List<Integer> userNum = convertStringToList(userInput);

        return userNum;
    }

    private static List<Integer> convertStringToList(String userInput) {
        List<String> splittedUserInput = List.of(userInput.split(""));
        List<Integer> digits = splittedUserInput.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        validateUserNumber(digits);
        return digits;
    }

    private static void validateUserNumber(List<Integer> digits) {
        if (digits.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }

        HashSet<Integer> nonDuplicateDigits = new HashSet<>(digits);
        if (nonDuplicateDigits.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private static void countStrikeAndBall(List<Integer> userNumber, List<Integer> computerNumber) {
        strikeCnt = 0;
        ballCnt = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            int userDigit = userNumber.get(i);
            int computerDigit = computerNumber.get(i);

            if (userDigit == computerDigit) {
                strikeCnt++;
            } else if (computerNumber.contains(userDigit)) {
                ballCnt++;
            }
        }
    }

    private static void printResult() {
        if (strikeCnt == NUMBER_LENGTH) {
            System.out.println(strikeCnt + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }
        if (strikeCnt == 0 && ballCnt == 0) {
            System.out.println("낫싱");
            return;
        }
        if (strikeCnt == 0) {
            System.out.println(ballCnt + "볼");
            return;
        }
        if (ballCnt == 0) {
            System.out.println(strikeCnt + "스트라이크");
            return;
        }
        System.out.println(ballCnt + "볼 " + strikeCnt + "스트라이크");
    }

    private static boolean restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();
        if (userInput.equals("1")) {
            return true;
        }
        if (userInput.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException();
    }

    private static void readAndCompare(List<Integer> computerNumber) {
        while (strikeCnt < NUMBER_LENGTH) {
            List<Integer> userNumber = readUserNumber();
            countStrikeAndBall(userNumber, computerNumber);
            printResult();
        }
    }
}
