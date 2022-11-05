package baseball.controller;

import baseball.dto.Score;
import baseball.service.BaseballService;
import baseball.system.holder.ConverterHolder;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.vo.Restart;
import baseball.vo.UserNumber;

import java.util.List;

public class BaseBallController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BaseballService baseballService;

    public BaseBallController(InputView inputView,
                              OutputView outputView,
                              BaseballService baseballService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.baseballService = baseballService;
    }

    public Restart startGame() {
        while (true) {
            UserNumber userNumber = getUserNumber();
            Score score = baseballService.compareInputWithAnswer(userNumber);
            outputView.printResult(score);
            if (score.didWin()) {
                break;
            }
        }

        return handleWinning();
    }

    private UserNumber getUserNumber() {
        String input = inputView.getUserInput();
        List<Integer> inputList = ConverterHolder.convert(input, List.class);
        UserNumber userNumber = ConverterHolder.convert(inputList, UserNumber.class);
        return userNumber;
    }

    private Restart handleWinning() {
        outputView.printWinnerMessage();
        String restartingInput = inputView.getRestartingInput();
        return ConverterHolder.convert(restartingInput, Restart.class);
    }
}
