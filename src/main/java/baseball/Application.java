package baseball;

import baseball.gameComponents.GameManager;
import baseball.gameComponents.MainFunctions;
import baseball.gameComponents.SubUtils;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        MainFunctions mainFunctions = new MainFunctions();
        SubUtils subUtils = new SubUtils();
        GameManager gameManager = new GameManager(mainFunctions, subUtils);

        gameManager.gameStart();
    }
}
