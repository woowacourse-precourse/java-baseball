package baseball.settings;

import static baseball.settings.Constants.*;

import baseball.players.Computer;
import baseball.players.User;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Controller {
    private static boolean isGameGoing = true;

    public static void start() {
        System.out.println(GAME_START_MESSAGE);
        List<Integer> computerNumber = Computer.createThreeDigitNumber();

        while (isGameGoing) {
            List<Integer> userNumber = User.createThreeDigitNumber();
            List<Integer> scores = Calculator.getScoresByNumbers(computerNumber, userNumber);
            ResultViewer.printOut(scores);
            checkIfThreeStrikes(scores.get(STRIKE_INDEX));
        }
        shouldContinue();
    }

    public static void checkIfThreeStrikes(Integer strikeCount) {
        if (strikeCount == 3) {
            isGameGoing = false;
        }
    }

    public static void shouldContinue() {
        System.out.println(CONGRATULATIONS_MESSAGE);
        System.out.println(WHETHER_TO_PLAY_AGAIN_MESSAGE);
        String userResponse = Console.readLine();
        checkResponseCode(userResponse);
    }

    public static void checkResponseCode(String response) {
        if (!response.equals(ONE_FOR_YES) && !response.equals(TWO_FOR_NO)) {
            throw new IllegalArgumentException();
        }
        if (response.equals(ONE_FOR_YES)) {
            isGameGoing = true;
            start();
        }
    }
}
