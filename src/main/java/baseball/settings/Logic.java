package baseball.settings;

import static baseball.settings.Constants.*;

import baseball.players.Computer;
import baseball.players.User;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Logic {
    private static boolean isGameGoing = true;

    public static void gameStart() {
        System.out.println(GAME_START_MESSAGE);
        Computer computer = new Computer();
        User user = new User();
        List<Integer> dealerNumbers = computer.createThreeDifferentNumbers();

        while (isGameGoing) {
            List<Integer> playerNumbers = user.createThreeDifferentNumbers();
            List<Integer> scores = Calculation.getScoresByNumbers(dealerNumbers, playerNumbers);
            ResultView.printOut(scores);
            checkThreeStrikes(scores.get(STRIKE_INDEX));
        }
        gameShouldContinue();
    }

    public static void checkThreeStrikes(Integer strikeCount) {
        if (strikeCount == 3) {
            isGameGoing = false;
        }
    }

    public static void gameShouldContinue() {
        System.out.println(CONGRATULATIONS_MESSAGE);
        System.out.println(ASK_WHETHER_PLAYING_AGAIN);
        String playerResponse = Console.readLine();
        checkResponseCode(playerResponse);
    }

    public static void checkResponseCode(String responseCode) {
        if (responseCode.equals(ONE_FOR_YES)) {
            isGameGoing = true;
            gameStart();
        }
        if (!responseCode.equals(ONE_FOR_YES) && !responseCode.equals(TWO_FOR_NO)) {
            throw new IllegalArgumentException();
        }
    }
}
