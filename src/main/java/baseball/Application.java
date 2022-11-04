package baseball;

import baseball.util.BaseBallGame;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Application {
    private static final int RESTART_CODE = 1;
    private static final int END_CODE = 2;

    public static void main(String[] args) {
        int statusCode = 0;

        do {
            BaseBallGame baseBallGame = new BaseBallGame(Randoms.pickUniqueNumbersInRange(0, 9, 3));

            baseBallGame.gameStart();

            statusCode = convertUserDataToStatusCode(Console.readLine());

        } while (statusCode == RESTART_CODE);

        if (statusCode != END_CODE) {
            throw new IllegalArgumentException();
        }

    }

    private static int convertUserDataToStatusCode(String restartOrEndOrError) throws IllegalArgumentException {
        if (!restartOrEndOrError.matches("[12]")) {
            throw new IllegalArgumentException();
        }

        return Integer.valueOf(restartOrEndOrError);
    }
}
