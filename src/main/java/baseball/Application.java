package baseball;

import baseball.dto.InputParameters;
import baseball.model.BaseBallGame;
import baseball.model.BaseBallHitsType;
import baseball.model.BaseBallResult;
import baseball.model.HomeRunStrategy;
import baseball.view.InputView;
import baseball.view.ResultView;

import java.util.Map;

public class Application {
    public static void main(String[] args) {
        InputParameters inputParameters = InputView.printStartGame();

        BaseBallGame baseBallGame = new BaseBallGame();
        HomeRunStrategy homeRunStrategy = new HomeRunStrategy();

        String result = BaseBallResult.result(baseBallGame.baseBallHitsTypeMap(inputParameters.getParameters(), homeRunStrategy));

        ResultView resultView = new ResultView();
        resultView.printResult(result);
    }
}
