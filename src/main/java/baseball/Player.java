package baseball;

import java.util.List;

import static baseball.Computer.calcResult;
import static baseball.Computer.printResult;
import static baseball.Number.readNum;

public class Player {
    public static boolean guessAnswer(int opponentNum) {
        int playerNum = readNum();
        List<Integer> result = calcResult(opponentNum, playerNum);

        boolean shouldGuessAgain = printResult(result);

        return shouldGuessAgain;
    }
}
