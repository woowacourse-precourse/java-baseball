package baseball.view;

import baseball.exception.PlayException;
import camp.nextstep.edu.missionutils.Console;

public class NextGameRequester {
    private final PlayException afterGamePlayException = new PlayException();

    public int askNextGame() {
        String numberAfterGameEnd = Console.readLine();
        afterGamePlayException.askAfterResultException(numberAfterGameEnd);
        return Integer.parseInt(numberAfterGameEnd);
    }
}