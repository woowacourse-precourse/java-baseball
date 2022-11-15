package baseball.game;

import baseball.game.input.FinishInput;
import baseball.game.number.GameNumber;
import camp.nextstep.edu.missionutils.Console;

public class GameScanner {
    public GameNumber readPlayerNumber() {
        String numberString = Console.readLine();
        return GameNumber.of(numberString);
    }

    public FinishInput readFinishInput() {
        String finishInputString = Console.readLine();
        return FinishInput.numberOf(finishInputString);
    }
}
