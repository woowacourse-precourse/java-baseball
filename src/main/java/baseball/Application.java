package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        boolean keepPlaying = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (keepPlaying) {
            List<Integer> targetNumber = createTargetNumber();
            guessNumber(targetNumber);
            inputKeepPlaying();
        }
    }

    private static List<Integer> createTargetNumber() {
        List<Integer> targetNumber = new ArrayList<>();
        while (targetNumber.size() < 3) {
            int newNumber = Randoms.pickNumberInRange(1, 9);
            if (!targetNumber.contains(newNumber)) {
                targetNumber.add(newNumber);
            }
        }
        return targetNumber;
    }

    private static void guessNumber(List<Integer> targetNumber) {
        List<Integer> BallStrikeCount = Arrays.asList(0, 0);
        while (BallStrikeCount.get(1) < 3) {
            List<Integer> userNumber = inputUserNumber();
            BallStrikeCount = judgeUserNumber(targetNumber, userNumber);
            printResult(BallStrikeCount);
        }
    }

    private static List<Integer> inputUserNumber() {
        String userInput = Console.readLine();
        verifyInput(userInput);
        List<Integer> userNumber = new ArrayList<>();
        for (String s : userInput.split("")) {
            Integer parseInt = Integer.parseInt(s);
            userNumber.add(parseInt);
        }
        return userNumber;
    }

    private static void verifyInput(String userInput) {
        String pattern = "^[1-9]{3}$";
        boolean isNonzeroThreeDigits = Pattern.matches(pattern, userInput);
        if (!isNonzeroThreeDigits) {
            throw new IllegalArgumentException();
        } else if (new HashSet<>(Arrays.asList(userInput.split(""))).size() < 3) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> judgeUserNumber(List<Integer> targetNumber, List<Integer> userNumber) {
        List<Integer> BallStrikeCount = Arrays.asList(0, 0);
        for (int position = 0; position < 3; position++) {
            int judgeResult = judgeEachNumber(targetNumber, position, userNumber.get(position));
            // Ball인 경우 0, Strike인 경우 1 Nothing인 경우 -1
            if (judgeResult == 0 || judgeResult == 1) {
                BallStrikeCount.set(judgeResult, BallStrikeCount.get(judgeResult) + 1);
            }
        }
        return BallStrikeCount;
    }

    private static int judgeEachNumber(List<Integer> targetNumber, int position, int userInt) {
        return 0;
    }

    private static void printResult(List<Integer> ballStrikeCount) {
    }

    private static void inputKeepPlaying() {
    }
}