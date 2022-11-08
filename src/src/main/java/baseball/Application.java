package baseball;

import baseball.utils.ConsoleUtil;
import baseball.utils.GameUtil;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Application {
    private static final int PICK_NUMBER_LENGTH = 3;

    public static void main(String[] args) {
        Queue<Integer> computeNumbers = new LinkedList<>(List.of(135, 589));
        boolean isExecute = true;

        ConsoleUtil.printIntro();
        ConsoleUtil.printHowToPlay();

        while (isExecute) {
            computeNumbers.add(GameUtil.pickNumber(PICK_NUMBER_LENGTH));
            isExecute = executeGame(computeNumbers.poll());
        }

        ConsoleUtil.printQuit();
    }

    private static boolean executeGame(int computerNumber) {
        Game game = new Game(computerNumber);
        game.run(PICK_NUMBER_LENGTH);

        ConsoleUtil.printFinish(PICK_NUMBER_LENGTH);

        String newGameFlag = ConsoleUtil.printGameRestartQuestion();
        return GameUtil.parseInt(newGameFlag) == 1;
    }
}
