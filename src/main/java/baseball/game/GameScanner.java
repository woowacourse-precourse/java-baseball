package baseball.game;

import baseball.game.input.FinishInput;
import baseball.game.number.Number;
import camp.nextstep.edu.missionutils.Console;

public class GameScanner {
    public Number readPlayerNumber() {
        String numberString = Console.readLine();
        return new Number(numberString);
    }

    public FinishInput readFinishInput() {
        String finishInputString = Console.readLine();
        return FinishInput.numberOf(finishInputString);
    }
}
