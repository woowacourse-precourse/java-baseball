package baseball.controller;

import baseball.dto.Score;
import baseball.service.BaseballService;
import baseball.system.conversion.Converter;
import baseball.system.validation.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.vo.Restart;

import java.util.List;

public class BaseBallController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BaseballService baseballService;
    private final Converter<String, Restart> stringToRestartConverter;
    private final Converter<String, List<Integer>> StringToIntegerListConverter;
    private final Validator<List<Integer>> numberValidator;

    public BaseBallController(InputView inputView,
                              OutputView outputView,
                              BaseballService baseballService,
                              Converter<String, Restart> stringToRestartConverter,
                              Converter<String, List<Integer>> stringToIntegerListConverter,
                              Validator<List<Integer>> numberValidator) {

        this.inputView = inputView;
        this.outputView = outputView;
        this.baseballService = baseballService;
        this.stringToRestartConverter = stringToRestartConverter;
        this.StringToIntegerListConverter = stringToIntegerListConverter;
        this.numberValidator = numberValidator;
    }

    public Restart startGame() {
        while (true) {
            String input = inputView.getUserInput();
            List<Integer> inputList = StringToIntegerListConverter.convert(input);
            numberValidator.validate(inputList);

            Score score = baseballService.compareInputWithAnswer(inputList);

            outputView.printResult(score);

            if (score.didWin()) {
                break;
            }
        }

        outputView.printWinnerMessage();
        String restartingInput = inputView.getRestartingInput();

        return stringToRestartConverter.convert(restartingInput);
    }
}
