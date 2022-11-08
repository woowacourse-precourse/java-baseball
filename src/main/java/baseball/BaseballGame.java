package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BaseballGame {
    private final View view;
    private final BaseballService baseballService;

    public BaseballGame(View view, BaseballService baseballService) {
        this.view = view;
        this.baseballService = baseballService;
    }

    public void start() {
        while (true) {
            List<Integer> baseballNumberList = createBaseballNumberList();
            BaseBallDto result = baseballService.getResult(baseballNumberList);
            view.printBaseBallResult(result);
            //3스트라이크 체크 후 다음 동작
            if (isFinished(result)) {
                break;
            }
            baseballService.resetNumberList();
        }

    }

    private boolean isFinished(BaseBallDto result) {
        if (result.isStrikeOut()) {
            String input = view.inputExitOrRestart();
            GameOption gameOption = createGameOption(input);
            return gameOption.equals(GameOption.EXIT);
        }
        return false;
    }

    private GameOption createGameOption(String input) {
        BaseballValidator.validDateSelectOption(input);
        return GameOption.of(input);
    }

    private List<Integer> createBaseballNumberList() {
        String baseballNumber = view.inputBaseballNumber();
        BaseballValidator.validateBaseballNumber(baseballNumber);
        return Stream.of(baseballNumber.split(""))
                     .map(Integer::parseInt)
                     .collect(Collectors.toCollection(ArrayList::new));
    }

}
