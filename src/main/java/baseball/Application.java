package baseball;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    static final int START  = 1;
    static final int EXIT   = 2;
    static final int LENGTH_OF_BASEBALL_NUMBER = 3;
    static final int BALL_COUNT = 1;
    static final int STRIKE_COUNT = 0;

    public static void main(String[] args) {
        int gameStatus = START;
        while (gameStatus == START) {
            boolean isWork = playNumberBaseball();
            if (!isWork) {
                break;
            }
            gameStatus = askRestartOrExit();
        }
    }

    private static boolean playNumberBaseball() {
        String computer = getComputerNumberInString();
        boolean userGetRightAnswer = false;
        boolean isWork = true;
        while (userGetRightAnswer == false) {
            String user = getUserAnswerInString();
            if (isValidAnswer(user)) {
                isWork = false;
            }
            List<Integer> scoreOfStrikeAndBall = compareComputerAndUser(computer, user);
            userGetRightAnswer = isRightAnswer(scoreOfStrikeAndBall);
            printResult(scoreOfStrikeAndBall);
        }
        return isWork;
    }

    private static String getComputerNumberInString() {
        String computer = "";
        while(computer.length() < LENGTH_OF_BASEBALL_NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (computer.contains(String.valueOf(randomNumber))) {
                computer += randomNumber;
            }
        }
        return computer;
    }

    private static String getUserAnswerInString() {
        String user = Console.readLine();
        return user;
    }
    private static List<Integer> compareComputerAndUser(String computer, String user) {}
    private static boolean isRightAnswer(List<Integer> scoreOfStrikeAndBall) {}
    private static void printResult(List<Integer> scoreOfStrikeAndBall) {}

    private static int askRestartOrExit() {
        int result = EXIT;
        return result;
    }
}
