package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.Constant.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int startOrEnd = START_GAME;
        while (startOrEnd == START_GAME) {
            List<Integer> uniqueRandomNumbers = pickUniqueNumbersInRange(END_INCLUSIVE, START_INCLUSIVE, RANGE);
            GameNumber gameNumber = new GameNumber(uniqueRandomNumbers);

            System.out.println(GAME_START_MESSAGE);
            System.out.print(ASK_NUMBER_MESSAGE);

            playGame(gameNumber);

            String reGameAnswer = Console.readLine();
            Exceptions.isValidReGameAnswer(reGameAnswer);
            startOrEnd = Integer.parseInt(reGameAnswer);
        }
        System.out.println(GAME_OVER_MESSAGE);
    }

    public static List<Integer> pickUniqueNumbersInRange(
            int startInclusive,
            int endInclusive,
            int range
    ) {
        List<Integer> uniqueNumbers = new ArrayList<>();

        while (uniqueNumbers.size() < range) {
            int randomNumber = Randoms.pickNumberInRange(startInclusive, endInclusive);
            saveUniqueNumber(uniqueNumbers, randomNumber);
        }

        return uniqueNumbers;
    }

    private static void playGame(GameNumber gameNumber) {
        while (true) {
            String userNumbersInString = Console.readLine();
            UserNumber userNumber = new UserNumber(userNumbersInString);

            int strikes = gameNumber.getStrikes(userNumber);
            int balls = gameNumber.getBalls(userNumber);

            if (strikes + balls == NOTHING_POINT) {
                System.out.println(NOTHING_MESSAGE);
                continue;
            }
            if (strikes == WIN_POINT) {
                showWinResult(strikes);
                break;
            }

            StringBuilder roundResult = new StringBuilder();
            showRoundResult(strikes, balls, roundResult);
        }
    }

    private static void showWinResult(int strikes) {
        System.out.println(strikes + STRIKE_MESSAGE);
        System.out.println(WIN_GAME_MESSAGE);
        System.out.println(RE_GAME_ASK_MESSAGE);
    }

    private static void showRoundResult(int strikes, int balls, StringBuilder roundResult) {
        if (balls != 0) {
            roundResult.append(balls).append(BALL_MESSAGE);
        }
        if (strikes != 0) {
            roundResult.append(strikes).append(STRIKE_MESSAGE);
        }

        System.out.println(roundResult);
    }


    public static void saveUniqueNumber(List<Integer> uniqueNumbers, int randomNumber) {
        if (isExistNumber(uniqueNumbers, randomNumber)) {
            return;
        }
        uniqueNumbers.add(randomNumber);
    }

    public static boolean isExistNumber(List<Integer> uniqueNumbers, int randomNumber) {
        if (uniqueNumbers.contains(randomNumber)) {
            return true;
        }
        return false;
    }
}
