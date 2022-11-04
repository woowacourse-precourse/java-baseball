package baseball.application;

import baseball.repository.BaseNumberRepository;
import baseball.model.InputNumbers;
import baseball.model.Result;
import baseball.utils.converter.InputNumbersToResultConverter;
import baseball.utils.converter.StringToInputNumbersConverter;

import static baseball.resources.GameConfig.RESTART;
import static baseball.utils.InputValidator.validate;

public class NumberBaseBallGame {
    private boolean isProceeding;
    private BaseNumberRepository baseNumberRepository;
    private StringToInputNumbersConverter stringToInputNumbersConverter;
    private InputNumbersToResultConverter inputNumbersToResultConverter;

    public NumberBaseBallGame(BaseNumberRepository baseNumberRepository) {
        this.baseNumberRepository = baseNumberRepository;
        this.stringToInputNumbersConverter = new StringToInputNumbersConverter();
        this.inputNumbersToResultConverter = new InputNumbersToResultConverter(baseNumberRepository);
    }

    public void start(){
        isProceeding = true;
        baseNumberRepository.createBaseNumber();
    }

    public boolean isProceeding() {
        return isProceeding;
    }

    public void end() {
        isProceeding = false;
    }

    public void restart(String restart) {
        if (restart.equals(RESTART)) {
            isProceeding = true;
            baseNumberRepository.createBaseNumber();
        }
    }

    public void validateInputNumber(String input) {
        validate(input);
    }

    public Result result(String input) {
        InputNumbers inputNumbers = stringToInputNumbersConverter.convert(input);
        return inputNumbersToResultConverter.convert(inputNumbers);
    }
}
