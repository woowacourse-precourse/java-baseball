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
        String inputNum = Console.readLine();
        List<String> splittedNum = List.of(inputNum.split(""));
        List<Integer> digits = splittedNum.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

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
        System.out.println(ballCnt + "볼 " + strikeCnt + "스트라이크");
    }
}
