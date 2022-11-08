package baseball;

import static baseball.Computer.calcResult;
import static baseball.Computer.printResult;
import static baseball.Computer.shouldGuessAgain;
import static baseball.Number.readNum;

import java.util.List;

public class Player {
    public static boolean guessAnswer(int opponentNum) {
        int playerNum = readNum();
        List<Integer> result = calcResult(opponentNum, playerNum);

        printResult(result);

        return shouldGuessAgain(result);
    }
}
