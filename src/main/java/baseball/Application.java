package baseball;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Application {

    public static void main(String[] args) {
        ElementListMaker elementListMaker = new DividedRandomNumberElementListMaker();

        BaseballGameRunner baseballGameRunner = new BaseballGameRunner(elementListMaker);
        baseballGameRunner.runGame();
    }
}
