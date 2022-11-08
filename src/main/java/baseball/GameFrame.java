package baseball;

import baseball.dto.InputParameters;
import baseball.model.*;
import baseball.view.InputView;
import baseball.view.ResultView;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class GameFrame {
    private static final Pattern BUTTON = Pattern.compile("^[1-2]$");
    public static final String RE_START = "1";

    public void startGuide() {
        InputView.printGuide();
    }

    public void start(BaseBallGame baseBallGame, List<Character> homeRunNumbers) {
        BallNumbers hits = getInputParameters().hits();
        Map<BaseBallHitsType, Integer> hitTypeResult = hitTypeResult(baseBallGame, hits, homeRunNumbers);

        String result = BaseBallResult.hitResult(hitTypeResult);

        if (BaseBallResult.end(hitTypeResult)) {
            ResultView.ballProcess(result);
            ResultView.endGreeting();
            reStartHandle(InputView.printRestartButton());
            return;
        }

        ResultView.ballProcess(result);
        start(baseBallGame, homeRunNumbers);
    }

    public void reStartHandle(String button) {
        wrong(button);

        press(button);
    }

    private void press(String restart) {
        if (restart.matches(RE_START)) {
            restart();
        }
    }

    private void wrong(String restart) {
        if (!BUTTON.matcher(restart).matches()) {
            throw new BallInputException("1과 2이외의 문자가 들어왔습니다.");
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
