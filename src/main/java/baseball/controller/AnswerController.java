package baseball.controller;

import baseball.service.AnswerService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class AnswerController {
    private static AnswerController instance;
    private static AnswerService answerService;

    private AnswerController() {
    }

    public static AnswerController getInstance() {
        if (instance == null) {
            instance = new AnswerController();
            answerService = AnswerService.getInstance();
        }
        return instance;
    }

    public void setCorrectAnswer() {
        answerService.setRandomNumbers();
    }

    public String getInputAnswer() {
        OutputView.alertInputAnswer();
        String input = InputView.getInput();
        answerService.validateInputAnswer(input);
        return input;
    }
}
