package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

import static baseball.Constant.*;

public class Game {


    public static void playGame() {
        System.out.println(START_MESSAGE);
        List<Integer> computerAnswer = Computer.generateNumber();
        do {
            Computer.countStrikeBall(computerAnswer, Player.getPlayerAnswer());
        } while (!Computer.getResult());
    }

    public static boolean restartGame() {
        System.out.println(RESTART_MESSAGE);
        String s = Console.readLine();
        if (s.equals(RESTART_GAME)) {
            return true;
        } else if (s.equals(QUIT_APP)) {
            return false;
        } else {
            throw new IllegalArgumentException(RESTART_ERROR_MESSAGE);
        }
    }
}
