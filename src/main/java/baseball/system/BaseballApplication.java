package baseball.system;

import baseball.controller.BaseBallController;
import baseball.controller.ComputerController;
import baseball.dto.Score;
import baseball.service.BaseballService;
import baseball.system.conversion.*;
import baseball.system.holder.AnswerHolder;
import baseball.system.holder.ConverterHolder;
import baseball.system.holder.ValidatorHolder;
import baseball.system.validation.NumberValidator;
import baseball.system.validation.StringToIntegerListConversionValidator;
import baseball.system.voter.BaseballVoter;
import baseball.system.voter.Voter;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.vo.Restart;
import baseball.vo.UserNumber;

import java.util.List;

public class BaseballApplication {
    private final InputView inputView;
    private final OutputView outputView;
    private final ComputerController computerController;
    private final BaseBallController baseBallController;
    private final BaseballService baseballService;
    private final Voter<UserNumber, Score> voter;

    public BaseballApplication() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.voter = new BaseballVoter();
        this.baseballService = new BaseballService(voter);
        this.computerController = new ComputerController();
        this.baseBallController = new BaseBallController(inputView, outputView, baseballService);

        setValidators();
        setConverters();
    }

    public void run() {
        outputView.printStartMessage();
        while (true) {
            computerController.createAnswer();
            Restart restart = baseBallController.startGame();

            if (restart == Restart.EXIT) {
                break;
            }
        }

        doAfterRun();
    }

    private void setConverters() {
        ConverterHolder.setConverters(List.of(
                new StringToRestartConverter(),
                new StringToIntegerListConverter(),
                new IntegerListToUserNumberConverter(),
                new ScoreToMessageConverter()
        ));
    }

    private void setValidators() {
        ValidatorHolder.setValidators(List.of(
                new NumberValidator(),
                new StringToIntegerListConversionValidator()
        ));
    }

    private void doAfterRun() {
        AnswerHolder.clearHolder();
        ValidatorHolder.clearHolder();
        ConverterHolder.clearHolder();
    }
}
