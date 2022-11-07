package baseball;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import static baseball.Messages.*;

public class Game {
    private static final Integer THREE_STRIKE = Application.NUMBER_LENGTH();

    public static void runGame() {
        startGame();
        checkContinue();
    }

    public static void startGame() {
        int balls = 0;
        int strikes = 0;

        RandomNumberList randomNumberList = new RandomNumberList();
        while (!isThreeStrikes(strikes)) {
            UserNumberList userNumberList = new UserNumberList(inputNumber());
            balls = countBalls(userNumberList.UserNumberList(), randomNumberList.randomNumberList());
            strikes = countStrikes(userNumberList.UserNumberList(), randomNumberList.randomNumberList());
            printGameResult(balls, strikes);
        }
        printClearMessage();
    }

    private static void checkContinue() {
        printAskContinue();
        String s = Console.readLine();

        if (s.equals(String.valueOf(CONTINUE_VALUE))) {
            runGame();
            return;
        }
        if (s.equals(String.valueOf(END_VALUE))) {
            printEndMessage();
            return;
        }
        throw new IllegalArgumentException("지정되지 않은 문자가 입력되었습니다.");
    }


    private static String inputNumber() {
        printInputNumberMessage();
        return Console.readLine();
    }

    public static int countBalls(List<BaseBallNumber> userNumberList, List<BaseBallNumber> randomNumberList) {
        int ballCount = 0;
        for (int i = 0; i < userNumberList.size(); i++) {
            if (isBall(userNumberList, randomNumberList, i)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private static boolean isBall(List<BaseBallNumber> userNumberList, List<BaseBallNumber> randomNumberList, int index) {
        int userNumber = userNumberList.get(index).getValue();

        for (int i = 0; i < userNumberList.size(); i++) {
            if (i == index) {
                continue;
            }

            int nowNumber = randomNumberList.get(i).getValue();
            if (userNumber == nowNumber) {
                return true;
            }
        }
        return false;
    }

    public static int countStrikes(List<BaseBallNumber> userNumberList, List<BaseBallNumber> randomNumberList) {
        int strikeCount = 0;
        for (int i = 0; i < userNumberList.size(); i++) {
            if (isStrike(userNumberList.get(i), randomNumberList.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private static boolean isStrike(BaseBallNumber userNumber, BaseBallNumber randomNumber) {
        return userNumber.getValue() == randomNumber.getValue();
    }

    private static boolean isThreeStrikes(int strikes) {
        if (strikes == THREE_STRIKE) {
            return true;
        }
        return false;
    }
}
