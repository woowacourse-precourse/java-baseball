package baseball.utils.converter;

import baseball.model.BaseNumber;
import baseball.repository.BaseNumberRepository;
import baseball.model.InputNumbers;
import baseball.model.Result;

import java.util.HashMap;
import java.util.Map;

import static baseball.resources.GameConfig.BALL_COUNT;
import static baseball.resources.GameConfig.STRIKE_COUNT;

public class InputNumbersToResultConverter implements Converter<InputNumbers, Result> {
    private final BaseNumberRepository repository;

    public InputNumbersToResultConverter(BaseNumberRepository repository) {
        this.repository = repository;
    }

    @Override
    public Result convert(InputNumbers source) {
        BaseNumber baseNumber = repository.findBaseNumber();
        Map<String, Integer> count = new HashMap<>();
        count.put(BALL_COUNT, source.count(inputNumber -> inputNumber.isBall(baseNumber)));
        count.put(STRIKE_COUNT, source.count(inputNumber -> inputNumber.isStrike(baseNumber)));
        return new Result(count);
    }
}
