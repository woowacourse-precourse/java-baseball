package baseball.controller;

import static baseball.type.GameType.*;
import static baseball.type.NumberType.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.ComputerNumberGenerator;
import baseball.UserNumberGenerator;
import baseball.domain.Hint;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {
    public static void playGame() {
        InputView.printStart();
        startGame();
    }

    public static void startGame() {
        boolean gameStatus = NO_ANSWER;
        List<Integer> computerNumbers = ComputerNumberGenerator.generate();

        while (gameStatus == NO_ANSWER) {
            Hint hint = new Hint(STRIKE_ZERO, BALL_ZERO);
            InputView.printTypoNumber();

            List<Integer> userNumbers = UserNumberGenerator.generate();

            hint.countHint(userNumbers, computerNumbers);
            OutputView.printHint(hint);
            gameStatus = HintController.isAnswer(hint);

            int ReTryOrExit = EXIT;
            if (gameStatus == YES_ANSWER) {
                OutputView.printAnswer();
                OutputView.printReTryOrExit();
                ReTryOrExit = Integer.parseInt(readLine());
            }

            if (ReTryOrExit == RETRY) {
                startGame();
            }
        }
    }


}
