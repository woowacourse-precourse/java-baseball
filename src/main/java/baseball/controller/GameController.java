package baseball.controller;


import static baseball.type.GameType.WRONG_ANSWER;

import static baseball.type.RetryOrExitType.EXIT;
import static baseball.type.RetryOrExitType.RETRY;
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

        do {
            startGame();
        }while(retryOrExit().equals(RETRY.getString()));
    }

    private static void startGame() {
        boolean gameStatus = WRONG_ANSWER.getValue();
        List<Integer> computerNumbers = ComputerNumberService.generate();

        while (gameStatus == WRONG_ANSWER.getValue()) {
            InputView.printTypoNumber();
            List<Integer> userNumbers = UserNumberService.generate();

            Hint hint = HintService.initialize();
            hint.countHint(userNumbers, computerNumbers);
            HintService.printHint(hint);

            gameStatus = HintService.isAnswer(hint);
        }
    }

    private static String retryOrExit() {
        OutputView.printAnswer();
        OutputView.printRetryOrExit();

        String retryOrExit = readLine();

        if (!retryOrExit.equals(RETRY.getString()) && !retryOrExit.equals(EXIT.getString())) {
            throw new IllegalArgumentException();
        }

       return retryOrExit;
    }

}
