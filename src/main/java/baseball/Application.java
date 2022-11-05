package baseball;

import java.util.List;

import static baseball.Answer.makeAnswer;
import static baseball.Choice.checkChoice;
import static baseball.Choice.takeChoice;
import static baseball.Constant.*;
import static baseball.GameSituation.*;
import static baseball.Guess.*;
import static baseball.Hint.hintPerDigit;
import static baseball.Hint.finalHint;

public class Application {
    public static void main(String[] args) {
        String choose;
        List<Integer> realAnswer;
        List<Integer> userAnswer;

        choose = NEW_GAME;
        realAnswer = makeAnswer();
        printStart();

        while (choose.equals(NEW_GAME)) {
            String input = takeGuess();
            checkGuess(input);
            userAnswer = splitGuess(input);

            String hint = finalHint(realAnswer, userAnswer);
            printHint(hint);

            if (hint.equals(PERFECT)) {
                printCorrect();
                printFinish();

                printRetry();
                choose = takeChoice();
                checkChoice(choose);

                if (choose.equals(QUIT)) break;
                realAnswer = makeAnswer();
            }
        }
    }
}
