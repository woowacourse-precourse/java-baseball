package baseball;

import static baseball.ConstantAndMessage.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println(GAME_START_MESSAGE);
        while (true) {
            List<Integer> computer = NonDuplicateRandomNumber.makingNumbers();
            NumberBaseBallGame game = new NumberBaseBallGame(computer);
            game.play();
            System.out.println(RESTART_MESSAGE);
            Restart restart = new Restart(Console.readLine());
            restart.errorChecking();
            if (restart.wantTerminate()) {
                break;
            }
        }
    }
}
