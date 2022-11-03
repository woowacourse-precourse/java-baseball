package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    static final int START  = 1;
    static final int EXIT   = 2;
    static final int LENGTH_OF_BASEBALL_NUMBER = 3;
    static final int MAXIMUM_STRIKE = 3;
    static final int STRIKE_COUNT_INDEX = 0;
    static final int BALL_COUNT_INDEX = 1;

    public static void main(String[] args) {
        int gameStatus = START;
        while (gameStatus == START) {
            try {
                playNumberBaseball();
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
            gameStatus = askRestartOrExit();
        }
    }

    private static void playNumberBaseball() throws IllegalArgumentException {
        String computer = getComputerNumberInString();
        boolean userGetRightAnswer = false;
        while (userGetRightAnswer == false) {
            String user = getUserAnswerInString();
            List<Integer> scoreOfStrikeAndBall = compareComputerAndUser(computer, user);
            userGetRightAnswer = isRightAnswer(scoreOfStrikeAndBall);
            printResult(scoreOfStrikeAndBall);
        }
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

    private static String getUserAnswerInString() throws IllegalArgumentException {
        String user = Console.readLine();
        isValidAnswer(user);
        return user;
    }

    private static void isValidAnswer(String answer) throws IllegalArgumentException {
        boolean answerIsValid = isValidValue(answer) && isValidLength(answer) && isValidOfDuplication(answer);
        if (!answerIsValid) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isValidLength(String answer) {
        return answer.length() == LENGTH_OF_BASEBALL_NUMBER;
    }

    private static boolean isValidOfDuplication(String answer) {
        Long distinctCount = Stream.of(answer).distinct().count();
        return answer.length() == distinctCount;
    }

    private static boolean isValidValue(String answer) {
        boolean result = true;
        try {
            Integer.valueOf(answer);
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    private static List<Integer> compareComputerAndUser(String computer, String user) {
        List<Integer> scoreOfStrikeAndBall = new ArrayList<>();
        scoreOfStrikeAndBall.add(countStrike(computer, user));
        scoreOfStrikeAndBall.add(countBall(computer, user));
        return scoreOfStrikeAndBall;
    }

    private static int countStrike(String computer, String user) {
        int count = 0;
        for (int i = 0; i < LENGTH_OF_BASEBALL_NUMBER; i++) {
            if (computer.charAt(i) == user.charAt(i)) {
                count++;
            }
        }
        return count;
    }
    private static int countBall(String computer, String user) {
        int count = 0;
        for (int i = 0; i < LENGTH_OF_BASEBALL_NUMBER; i++) {
            int nextIndex = (i + 1) % LENGTH_OF_BASEBALL_NUMBER;
            int nextNextIndex = (i + 2) % LENGTH_OF_BASEBALL_NUMBER;
            if (user.charAt(i) == computer.charAt(nextIndex) ||
                    user.charAt(i) == computer.charAt(nextNextIndex)) {
                count++;
            }
        }
        return count;
    }
    private static boolean isRightAnswer(List<Integer> scoreOfStrikeAndBall) {
        return scoreOfStrikeAndBall.get(STRIKE_COUNT_INDEX) == MAXIMUM_STRIKE;
    }
    private static void printResult(List<Integer> scoreOfStrikeAndBall) {
        if (isRightAnswer(scoreOfStrikeAndBall)) {
            printThreeStrike();
            return;
        } else if (isNoMatchAnswer(scoreOfStrikeAndBall)) {
            printNothingMatch();
        }
        printStrike(scoreOfStrikeAndBall.get(STRIKE_COUNT_INDEX));
        printBall(scoreOfStrikeAndBall.get(BALL_COUNT_INDEX));
    }

    private static boolean isNoMatchAnswer(List<Integer> scoreOfStrikeAndBall) {
        return scoreOfStrikeAndBall.get(STRIKE_COUNT_INDEX) == 0 && scoreOfStrikeAndBall.get(BALL_COUNT_INDEX) == 0;
    }
    private static void printNothingMatch() {
        System.out.println("낫싱");
    }
    private static void printThreeStrike() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    private static void printStrike(int strikeCount) {}
    private static void printBall(int ballCount) {}

    private static int askRestartOrExit() {
        int result = EXIT;
        return result;
    }
}
