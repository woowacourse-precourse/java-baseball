package baseball;

import java.util.HashMap;
import java.util.List;

import static baseball.Constant.*;

public class Score {
    private static List<Integer> userNumbers;
    private static List<Integer> computerNumbers;
    public void userNumbers(List<Integer> users) {
        userNumbers = users;
    }

    public void computerNumbers(List<Integer> computers) {
        computerNumbers = computers;
    }

    public static HashMap<String, Integer> total() {
        System.out.println("정답" +computerNumbers.get(0)+" " + computerNumbers.get(1) + " " + computerNumbers.get(2));
        HashMap<String, Integer> totalScore = new HashMap<>();
        totalScore.put(STRIKE, getStrike());
        totalScore.put(BALL, getBall());
        return totalScore;
    }
    
    private static Integer getStrike() {
        int strike = 0;
        for (int i = 0; i < NUMBERS_LENGTH; i++) {
            if (isStrike(computerNumbers.get(i), userNumbers.get(i))) {
                strike += 1;
            }
        }
        return strike;
    }

    private static void strikeOut() {
        UserInput userInput = new UserInput();
        PrintMessage.gameEnd();
        userInput.chooseReStartOrQuit();
    }

    public static Integer getBall() {
        int ball = 0;
        for (int i = 0; i < NUMBERS_LENGTH; i++) {
            if (isBall(computerNumbers, userNumbers.get(i))
                        && !isStrike(computerNumbers.get(i), userNumbers.get(i))) {
                ball += 1;
            }
        }
        return ball;
    }

    private static boolean isStrike(Integer computerNumber, Integer userNumber) {
        return computerNumber.equals(userNumber);
    }

    private static boolean isBall(List<Integer> computerNumbers, Integer userNumber) {
        return computerNumbers.contains(userNumber);
    }
}
