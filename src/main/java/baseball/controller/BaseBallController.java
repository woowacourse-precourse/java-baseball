package baseball.controller;

import baseball.model.Score;
import baseball.service.BaseBallService;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class BaseBallController {

    private final BaseBallService baseBallService;

    public BaseBallController(BaseBallService baseBallService) {
        this.baseBallService = baseBallService;
    }

    public void run() {
        baseBallService.init();
        InputView.printStartMessage();
        String input = Console.readLine();
        Score score = baseBallService.inputAndCompareAnswer(input);
        OutputView.printResultMessage(score);
    }
}
