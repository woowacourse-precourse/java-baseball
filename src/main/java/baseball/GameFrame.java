package baseball;

import baseball.dto.InputParameters;
import baseball.model.*;
import baseball.view.InputView;
import baseball.view.ResultView;

import java.util.List;
import java.util.Map;

public class GameFrame {

    private final BaseBallGame baseBallGame;

    public GameFrame(BaseBallGame baseBallGame) {
        this.baseBallGame = baseBallGame;
    }

    public void startGuide() {
        InputView.printGuide();
    }

    public void start(List<Character> homeRunNumbers) {
        BallNumbers hits = getInputParameters().hits();
        Map<BaseBallHitsType, Integer> hitTypeResult = hitTypeResult(baseBallGame, hits, homeRunNumbers);

        String result = BaseBallResult.hitResult(hitTypeResult);

        if (BaseBallResult.end(hitTypeResult)) {
            ballProcess(result);
            ResultView.endGreeting();
            reStartHandle(InputView.printRestartButton());
            return;
        }

        ballProcess(result);
        start(homeRunNumbers);
    }

    private void ballProcess(String result) {
        ResultView.ballProcess(result);
    }

    private void reStartHandle(Button button) {
        press(button);
    }

    private void press(Button button) {
        if (button.reStart()) {
            restart();
        }
    }

    private void restart() {
        List<Character> homeRun = new HomeRunStrategy().createBallNumbers();
        start(homeRun);
    }

    private InputParameters getInputParameters() {
        return InputView.printStartGame();
    }

    private Map<BaseBallHitsType, Integer> hitTypeResult(BaseBallGame baseBallGame, BallNumbers hits, List<Character> homeRunNumbers) {
        return baseBallGame.baseBallHitsTypeMap(homeRunNumbers, hits);
    }
}
