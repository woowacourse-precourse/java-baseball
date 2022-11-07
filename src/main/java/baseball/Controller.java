package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Exception.ProcessException;
import camp.nextstep.edu.missionutils.Randoms;

public class Controller {

    public static void run(Scanner scanner) throws ProcessException {

        boolean restartStatus;
        Game game = new Game(scanner);
        GameOver gameOver = new GameOver(scanner);

        do {
            List<Integer> targetNumber = makeRandomWithoutDuplicate();
            System.out.println(targetNumber);
            game = game.play(targetNumber);
            restartStatus = gameOver.work();
        } while (restartStatus);
    }

    private static List<Integer> makeRandomWithoutDuplicate() {

        List<Integer> randomValues = new ArrayList<>();
        while (randomValues.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomValues.contains(randomNumber)) {
                randomValues.add(randomNumber);
            }
        }
        return randomValues;
    }
}
