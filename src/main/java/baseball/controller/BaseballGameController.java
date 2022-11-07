package baseball.controller;

import baseball.model.AnswerNumber;
import baseball.model.PlayerNumber;
import baseball.service.HintService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {

    private final HintService hintService;
    private final AnswerNumber answerNumber;
    private final PlayerNumber playerNumber;

    public BaseballGameController() {

        hintService = new HintService();
        answerNumber = new AnswerNumber();
        playerNumber = new PlayerNumber();
    }

    public void start() {

        answerNumber.getNewAnswer();
        do {
            receiveInputNumberFromPlayer();
            OutputView.printHintMessage(hintService.getHint(answerNumber.getAnswer(), playerNumber.getPlayerNumber()));
            System.out.println(answerNumber.getAnswer());
        } while (!hintService.isThreeStrike());
        OutputView.printPlayerCorrectAnswerMessage();
    }

    public void receiveInputNumberFromPlayer() {

        playerNumber.setPlayerNumber(InputView.setPlayerNumber());
    }

}
