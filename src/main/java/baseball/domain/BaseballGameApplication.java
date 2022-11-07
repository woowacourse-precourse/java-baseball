package baseball.domain;

import baseball.utils.UserInputUtil;
import baseball.ui.BaseballViewer;

public class BaseballGameApplication {

    private static final String RESTART = "1";
    private final BaseballViewer baseballViewer;

    public BaseballGameApplication(BaseballViewer baseballViewer) {
        this.baseballViewer = baseballViewer;
    }

    public void run() {
        baseballViewer.showStartText();
        do {
            gameProcess(new BaseballGame());
        } while (UserInputUtil.readRestartAnswer().equals(RESTART));
    }

    private void gameProcess(BaseballGame baseballGame) {
        while (true) {
            baseballViewer.showInputText();
            Score score = baseballGame.compareNumber(UserInputUtil.readUserAnswer());
            baseballViewer.showScore(score);
            if (score.isThreeStrike()) {
                baseballViewer.showWinText();
                baseballViewer.showRestartGameText();
                break;
            }
        }
    }
}
