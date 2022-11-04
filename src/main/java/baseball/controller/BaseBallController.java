package baseball.controller;

import baseball.dto.Score;
import baseball.service.BaseballService;
import baseball.system.conversion.Converter;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.vo.Restart;
import baseball.vo.UserNumber;

import java.util.List;

public class BaseBallController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BaseballService baseballService;
    private final Converter<String, Restart> stringToRestartConverter;
    private final Converter<String, List<Integer>> stringToIntegerListConverter;
    private final Converter<List<Integer>, UserNumber> integerListToUserNumberConverter;

    public BaseBallController(InputView inputView, OutputView outputView,
                              BaseballService baseballService, Converter<String, Restart> stringToRestartConverter,
                              Converter<String, List<Integer>> stringToIntegerListConverter,
                              Converter<List<Integer>, UserNumber> integerListToUserNumberConverter) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.baseballService = baseballService;
        this.stringToRestartConverter = stringToRestartConverter;
        this.stringToIntegerListConverter = stringToIntegerListConverter;
        this.integerListToUserNumberConverter = integerListToUserNumberConverter;
    }

    public Restart startGame() {
        while (true) {
            String input = inputView.getUserInput();
            List<Integer> inputList = stringToIntegerListConverter.convert(input);
            UserNumber userNumber = integerListToUserNumberConverter.convert(inputList);

            Score score = baseballService.compareInputWithAnswer(userNumber);

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
