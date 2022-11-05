package baseball;

import java.util.List;

import static baseball.Answer.makeAnswer;
import static baseball.Choice.*;
import static baseball.Constant.*;
import static baseball.GameSituation.*;
import static baseball.Guess.*;
import static baseball.Hint.finalHint;

public class Application {
    private static void playGame() {
        String hint = "";
        List<Integer> realAnswer = makeAnswer();

        while (!hint.equals(PERFECT)) {
            String input = takeGuess();
            checkGuess(input);
            List<Integer> userAnswer = splitGuess(input);

            hint = finalHint(realAnswer, userAnswer);
            printHint(hint);

            if (input.contains("0"))
                printNoZero();
        }

        printCorrect();
        printFinish();

        printRetry();
        String choose = takeChoice();
        checkChoice(choose);

        if (choose.equals(NEW_GAME))
            playGame();
    }

    public static void main(String[] args) {
        printStart();
        playGame();
        printFinish();
    }
}
