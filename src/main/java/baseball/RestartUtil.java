package baseball;

public class RestartUtil {
    public void restartGame(boolean restart) {
        PrintUtil printUtil = new PrintUtil();
        if (restart)
            printUtil.playGame();
    }
}