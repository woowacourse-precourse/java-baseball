package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.Announce.finishAnnounce;
import static baseball.BallAndStrike.caseOfAllBallAndStrike;
import static baseball.BallAndStrike.countBallAndStrike;
import static baseball.Number.getRandomNumber;

public class Game {

    public static void caseOfAllStrike(String enterOneOrTwo) {
        if (enterOneOrTwo.equals("1")) {
            game();
        }
        if (!enterOneOrTwo.equals("1") && !enterOneOrTwo.equals("2")) {
            throw new IllegalArgumentException("숫자를 1, 2 중에 하나를 입력해주세요!");
        }
    }
    public static void announceBallAndStrike(List<Integer> randomNumber, List<Integer> ballAndStrikeNumber) {
        if (ballAndStrikeNumber.get(1) == 3) {
            finishAnnounce();
            String oneOrTwo = Console.readLine();
            caseOfAllStrike(oneOrTwo);
        }
        if (ballAndStrikeNumber.get(1) < 3) {
            caseOfAllBallAndStrike(ballAndStrikeNumber);
            repeatGameUntilSuccess(randomNumber);
        }
    }
    public static void repeatGameUntilSuccess(List<Integer> randomNumber) {
        System.out.print("숫자를 입력해주세요 : ");
        String userEnterNumber = Console.readLine();
        List<Integer> enterNumber = getEnterNumber(userEnterNumber);
        List<Integer> ballAndStrikeNumber = countBallAndStrike(randomNumber, enterNumber);
        announceBallAndStrike(randomNumber, ballAndStrikeNumber);
    }
    public static void game() {
        List<Integer> randomNumber = getRandomNumber();
        repeatGameUntilSuccess(randomNumber);
    }
}
