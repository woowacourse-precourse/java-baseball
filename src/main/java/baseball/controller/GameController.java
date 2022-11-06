package baseball.controller;

import static baseball.type.GameType.*;
import static baseball.type.NumberType.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.domain.Hint;
import baseball.service.ComputerNumberService;
import baseball.service.HintService;
import baseball.service.UserNumberService;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {

    public static void playGame() {
        InputView.printStart();
        startGame();
    }

    private static void startGame() {
        boolean gameStatus = NO_ANSWER;
        List<Integer> computerNumbers = ComputerNumberService.generate();

        while (gameStatus == NO_ANSWER) {
            InputView.printTypoNumber();
            List<Integer> userNumbers = UserNumberService.generate();

            Hint hint = HintService.initialize();
            hint.countHint(userNumbers, computerNumbers);
            HintService.printHint(hint);
            gameStatus = HintService.isAnswer(hint);
        }

        if (retryOrExit() == RETRY) {
            startGame();
        }
    }

    private static int retryOrExit() {
        OutputView.printAnswer();
        OutputView.printRetryOrExit();

        int retryOrExit = Integer.parseInt(readLine());

        if (retryOrExit != RETRY && retryOrExit != EXIT) {
            throw new IllegalArgumentException();
        }

       return retryOrExit;
    }

}
