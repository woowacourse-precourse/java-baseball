package baseball.controller;

import baseball.dto.Score;
import baseball.service.BaseballService;
import baseball.system.conversion.Converter;
import baseball.system.exception.ConverterNotFoundException;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.vo.Restart;
import baseball.vo.UserNumber;

import java.util.Iterator;
import java.util.List;

public class BaseBallController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BaseballService baseballService;
    private final List<Converter> converters;

    public BaseBallController(InputView inputView,
                              OutputView outputView,
                              BaseballService baseballService,
                              List<Converter> converters) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.baseballService = baseballService;
        this.converters = converters;
    }

    public Restart startGame() {
        while (true) {
            String input = inputView.getUserInput();
            List<Integer> inputList = convert(input, List.class);
            UserNumber userNumber = convert(inputList, UserNumber.class);

            Score score = baseballService.compareInputWithAnswer(userNumber);

            outputView.printResult(score);

            if (score.didWin()) {
                break;
            }
        }

        outputView.printWinnerMessage();
        String restartingInput = inputView.getRestartingInput();

        return convert(restartingInput, Restart.class);
    }

    private <T extends Object> T convert(Object target, Class convertTo) {
        Iterator<Converter> iterator = converters.iterator();
        while (iterator.hasNext()) {
            Converter converter = iterator.next();
            if (converter.supports(target, convertTo)) {
                return (T) converter.convert(target);
            }
        }
        throw new ConverterNotFoundException();
    }
}
