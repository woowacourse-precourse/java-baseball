package baseball;

import static baseball.Constants.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Controller {
    private static boolean isGameGoing = true;

    public static void gameStart() {
        Dealer dealer = new Dealer();
        Player player = new Player();
        List<Integer> dealerNumbers = dealer.createThreeDifferentNumbers();

        while (isGameGoing) {
            List<Integer> playerNumbers = player.createThreeDifferentNumbers();
            List<Integer> scores = Calculator.getScoresBy(dealerNumbers, playerNumbers);
            ResultViewer.printOut(scores);
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

    public static void main(String[] args) {
        gameStart();
    }
}
