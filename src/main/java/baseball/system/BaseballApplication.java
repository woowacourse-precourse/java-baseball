package baseball.system;

import baseball.controller.BaseBallController;
import baseball.controller.ComputerController;
import baseball.dto.Score;
import baseball.service.BaseballService;
import baseball.system.conversion.Converter;
import baseball.system.conversion.StringToIntegerListConverter;
import baseball.system.conversion.StringToRestartConverter;
import baseball.system.validation.NumberValidator;
import baseball.system.validation.StringToIntegerListConversionValidator;
import baseball.system.validation.Validator;
import baseball.system.voter.BaseballVoter;
import baseball.system.voter.Voter;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.vo.Restart;

import java.util.List;

public class BaseballApplication {
    private final InputView inputView;
    private final OutputView outputView;
    private final ComputerController computerController;
    private final BaseBallController baseBallController;
    private final BaseballService baseballService;

    private final Validator<List<Integer>> numberValidator;
    private final Converter<String, Restart> stringToRestartConverter;
    private final Converter<String, List<Integer>> stringToIntegerListConverter;
    private final Voter<List<Integer>, Score> voter;

    public BaseballApplication() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.voter = new BaseballVoter();
        this.numberValidator = new NumberValidator();
        this.stringToRestartConverter = new StringToRestartConverter();
        this.stringToIntegerListConverter
                = new StringToIntegerListConverter(new StringToIntegerListConversionValidator());

        this.baseballService = new BaseballService(voter);
        this.computerController = new ComputerController();
        this.baseBallController = new BaseBallController(
                inputView, outputView, baseballService,
                stringToRestartConverter, stringToIntegerListConverter, numberValidator);
    }

    public void run() {
        computerController.createAnswer();
        Restart restart = baseBallController.startGame();

        if (restart == Restart.RESTART) {
            run();
        }

        doAfterRun();
    }

    private void doAfterRun() {
        AnswerHolder.clearHolder();
    }
}
