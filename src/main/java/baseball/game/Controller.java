package baseball.game;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Controller {

    public static void playBaseballGame() {

        Output.startGame();

        while (true) {

            List<Integer> computer = Service.getRandomNum();
            System.out.println(computer);

            Service.startGame(computer);

            Output.endGame();
            Output.restartOrEnd();

            int checkNum = Integer.parseInt(Console.readLine());
            if(Boolean.TRUE.equals(Service.restartCheck(checkNum))) {
                break;
            }
        }
    }
}
