package baseball.controller;

import baseball.dto.Score;
import baseball.service.BaseballService;
import baseball.system.conversion.Converter;
import baseball.system.conversion.StringToIntegerListConverter;
import baseball.system.conversion.StringToRestartConverter;
import baseball.system.validation.NumberValidator;
import baseball.system.validation.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.vo.Restart;

import java.util.List;

public class BaseBallController {
    public Restart startGame() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        while (true) {
            String input = inputView.getUserInput();

            Converter<String, List<Integer>> converter = new StringToIntegerListConverter();
            List<Integer> inputList = converter.convert(input);

            Validator<List<Integer>> validator = new NumberValidator();
            validator.validate(inputList);

            BaseballService baseballService = new BaseballService();
            Score score = baseballService.compareInputWithAnswer(inputList);

            outputView.printResult(score);

            if (score.didWin()) {
                break;
            }
        }

        outputView.printWinnerMessage();
        String restartingInput = inputView.getRestartingInput();
        Converter<String, Restart> converter = new StringToRestartConverter();

        return converter.convert(restartingInput);
    }
}
