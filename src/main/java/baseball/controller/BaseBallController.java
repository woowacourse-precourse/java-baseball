package baseball.controller;

import baseball.service.BaseballService;
import baseball.system.conversion.Converter;
import baseball.system.conversion.StringToIntegerListConverter;
import baseball.system.validation.NumberValidator;
import baseball.system.validation.Validator;
import baseball.view.InputView;

import java.util.List;

public class BaseBallController {
    public void startGame() {
        InputView inputView = new InputView();
        String input = inputView.getUserInput();

        Converter<String, List<Integer>> converter = new StringToIntegerListConverter();
        List<Integer> inputList = converter.convert(input);

        Validator<List<Integer>> validator = new NumberValidator();
        validator.validate(inputList);

        BaseballService baseballService = new BaseballService();
        baseballService.compareInputWithAnswer(inputList);
    }
}
