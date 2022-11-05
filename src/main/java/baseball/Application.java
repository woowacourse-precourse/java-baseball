package baseball;

import java.util.List;

import static baseball.Answer.makeAnswer;
import static baseball.Choice.*;
import static baseball.Constant.*;
import static baseball.GameSituation.*;
import static baseball.Guess.*;
import static baseball.Hint.finalHint;

public class Application {
    public static void main(String[] args) {
        String choose;
        String input;
        String hint;
        List<Integer> realAnswer;
        List<Integer> userAnswer;

        choose = NEW_GAME;
        realAnswer = makeAnswer();
        printStart();

        while (choose.equals(NEW_GAME)) {
            input = takeGuess();
            checkGuess(input);
            userAnswer = splitGuess(input);

            hint = finalHint(realAnswer, userAnswer);
            printHint(hint);

            if (hint.equals(PERFECT)) {
                printCorrect();
                printFinish();
                printRetry();
                choose = takeChoice();
                checkChoice(choose);
                realAnswer = makeAnswer();
            }
        }
        printFinish();
    }
}
