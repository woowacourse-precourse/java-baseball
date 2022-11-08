package baseball;

import baseball.dto.InputParameters;
import baseball.model.*;
import baseball.view.InputView;
import baseball.view.ResultView;

import java.util.List;
import java.util.Map;

public class GameFrame {

    public void startGuide() {
        InputView.printGuide();
    }

    public void start(BaseBallGame baseBallGame, List<Character> homeRunNumbers) {
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
        start(baseBallGame, homeRunNumbers);
    }

    private void ballProcess(String result) {
        ResultView.ballProcess(result);
    }

    public void reStartHandle(Button button) {
        press(button);
    }

    private void press(Button button) {
        if (button.reStart()) {
            restart();
        }
    }

    private void restart() {
        List<Character> homeRun = new HomeRunStrategy().createBallNumbers();
        BaseBallGame restartGame = new BaseBallGame();
        GameFrame gameFrame = new GameFrame();
        gameFrame.start(restartGame, homeRun);
    }

    private InputParameters getInputParameters() {
        return InputView.printStartGame();
    }

    private Map<BaseBallHitsType, Integer> hitTypeResult(BaseBallGame baseBallGame, BallNumbers hits, List<Character> homeRunNumbers) {
        return baseBallGame.baseBallHitsTypeMap(homeRunNumbers, hits);
    }
}
