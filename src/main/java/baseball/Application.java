package baseball;

import baseball.domain.BaseballGameApplication;
import baseball.ui.BaseballViewer;

public class Application {
    public static void main(String[] args) {
        BaseballGameApplication baseBallGameUserInterface = new BaseballGameApplication(new BaseballViewer());
        baseBallGameUserInterface.run();
    }
}
