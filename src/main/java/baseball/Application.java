package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    static final int START  = 1;
    static final int EXIT   = 2;
    static final int LENGTH_OF_BASEBALL_NUMBER = 3;
    static final int MAXIMUM_STRIKE = 3;
    static final int STRIKE_COUNT_INDEX = 0;
    static final int BALL_COUNT_INDEX = 1;

    public static void main(String[] args) throws IllegalArgumentException {
        int gameStatus = START;
        while (gameStatus == START) {
            playNumberBaseball();
            gameStatus = askRestartOrExit();
        }
    }

    static void playNumberBaseball() throws IllegalArgumentException {
        String computer = getComputerNumberInString();
        boolean userGetRightAnswer = false;
        while (!userGetRightAnswer) {
            String userAnswer = getUserAnswerInString("숫자를 입력해주세요 : ");
            isValidBaseballNumber(userAnswer);
            List<Integer> scoreOfStrikeAndBall = compareComputerAndUser(computer, userAnswer);
            userGetRightAnswer = isRightAnswer(scoreOfStrikeAndBall);
            printResult(scoreOfStrikeAndBall);
        }
    }

    static String getComputerNumberInString() {
        String computer = "";
        while(computer.length() < LENGTH_OF_BASEBALL_NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(String.valueOf(randomNumber))) {
                computer += randomNumber;
            }
        }
        return computer;
    }

    static String getUserAnswerInString(String question) {
        System.out.print(question);
        return Console.readLine();
    }

    static void isValidBaseballNumber(String answer) throws IllegalArgumentException {
        boolean answerIsValid = isValidValue(answer) && isValidLength(answer) && isValidOfDuplication(answer);
        if (!answerIsValid) {
            throw new IllegalArgumentException();
        }
    }

    static boolean isValidLength(String answer) {
        return answer.length() == LENGTH_OF_BASEBALL_NUMBER;
    }

    static boolean isValidOfDuplication(String answer) {
        return answer.length() == answer.chars().distinct().count();
    }

    static boolean isValidValue(String answer) {
        boolean result = true;
        try {
            Integer.valueOf(answer);
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    static List<Integer> compareComputerAndUser(String computer, String user) {
        List<Integer> scoreOfStrikeAndBall = new ArrayList<>();
        scoreOfStrikeAndBall.add(countStrike(computer, user));
        scoreOfStrikeAndBall.add(countBall(computer, user));
        return scoreOfStrikeAndBall;
    }

    static int countStrike(String computer, String user) {
        return (int)computer.chars()
                .filter(i -> i == user.charAt(computer.indexOf(i)))
                        .count();
    }
    static int countBall(String computer, String user) {
        return (int)user.chars()
                .filter(i -> i != computer.charAt(user.indexOf(i)))
                .filter(i -> computer.contains(String.valueOf((char)i)))
                .count();
    }
    static boolean isRightAnswer(List<Integer> scoreOfStrikeAndBall) {
        return scoreOfStrikeAndBall.get(STRIKE_COUNT_INDEX) == MAXIMUM_STRIKE;
    }
    static void printResult(List<Integer> scoreOfStrikeAndBall) {
        if (isRightAnswer(scoreOfStrikeAndBall)) {
            printThreeStrike();
        } else if (isNoMatchAnswer(scoreOfStrikeAndBall)) {
            printNothingMatch();
        } else {
            printBall(scoreOfStrikeAndBall.get(BALL_COUNT_INDEX));
            printStrike(scoreOfStrikeAndBall.get(STRIKE_COUNT_INDEX));
        }
    }

    static boolean isNoMatchAnswer(List<Integer> scoreOfStrikeAndBall) {
        return scoreOfStrikeAndBall.get(STRIKE_COUNT_INDEX) == 0 && scoreOfStrikeAndBall.get(BALL_COUNT_INDEX) == 0;
    }
    static void printNothingMatch() {
        System.out.println("낫싱");
    }
    static void printThreeStrike() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    static void printStrike(int strikeCount) {
        System.out.printf(" %d스트라이크\n", strikeCount);
    }
    static void printBall(int ballCount) {
        System.out.printf("%d볼", ballCount);
    }

    static int askRestartOrExit() throws IllegalArgumentException {
        String userAnswer = getUserAnswerInString("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        if (!isValidAnswer(userAnswer)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(userAnswer);
    }

    static boolean isValidAnswer(String userAnswer) {
        return userAnswer.equals(String.valueOf(START)) || userAnswer.equals(String.valueOf(EXIT));
    }
}
