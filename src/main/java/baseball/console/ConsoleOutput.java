package baseball.console;

import static baseball.console.ConsoleOutputMessage.*;
import static baseball.util.CharacterUtil.ENTER;

public class ConsoleOutput {

    public void printStartGame() {
        print(START_BASEBALL_GAME.getMessage() + ENTER.getUnit());
    }

    public void printHint(String hint) {
        print(hint + ENTER.getUnit());
    }

    public void printWinner() {
        print(WINNER_COMMENT.getMessage() + WINNER_END_COMMENT.getMessage() + ENTER.getUnit());
    }

    public void printExplainAnotherGame() {
        print(EXPLAIN_ANOTHER_GAME.getMessage() + ENTER.getUnit());
    }

    public void printExplainToInputNumbers() {
        print(INPUT_BASEBALL_NUMBER.getMessage());
    }

    private void print(String text) {
        System.out.print(text);
    }
}
