package baseball;

import baseball.util.BaseBallGame;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Application {
    private static final int RESTART_CODE = 1;
    private static final int END_CODE = 2;

    public static void main(String[] args) {
        Integer restartOrEnd;

        do {
            BaseBallGame baseBallGame = new BaseBallGame(Randoms.pickUniqueNumbersInRange(0, 9, 3));


            restartOrEnd = Integer.valueOf(Console.readLine());
        } while (restartOrEnd == RESTART_CODE);

        if (restartOrEnd != END_CODE) {
            throw new IllegalArgumentException();
        }

    }
}
