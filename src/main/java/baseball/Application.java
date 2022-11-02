package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        List<String> userInputList = Arrays.asList(userInput.split(""));
        verifyInput(userInputList);
        List<Integer> userNumber = userInputList.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
        return userNumber;
    }

    private static void verifyInput(List<String> userInputList) {
    }


    private static List<Integer> judgeUserNumber(List<Integer> targetNumber, List<Integer> userNumber) {
        return new ArrayList<>();
    }


    private static void printResult(List<Integer> ballStrikeCount) {
    }


    private static void inputKeepPlaying() {
    }
}
