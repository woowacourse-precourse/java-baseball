package baseball;

import baseball.launcher.GameLauncher;
import baseball.launcher.GameType;

public class Application {
    public static void main(String[] args) {
        GameLauncher.run(GameType.BASEBALL);
    }
}
