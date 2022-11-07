package baseball.game;

import baseball.game.input.FinishInput;
import baseball.game.number.Number;
import camp.nextstep.edu.missionutils.Console;

public class GameScanner {
    public Number readPlayerNumber() {
        String line = Console.readLine();
        int input = Integer.parseInt(line);
        return new Number(input);
    }

    public FinishInput readFinishInput() {
        int inputNumber = Integer.parseInt(Console.readLine());
        return FinishInput.numberOf(inputNumber);
    }
}
