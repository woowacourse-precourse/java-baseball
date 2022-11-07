package baseball;

public class RestartUtil {
    public void restartGame(boolean restart) {
        CountUtil countUtil = new CountUtil();
        if (restart)
            countUtil.playGame();
    }
}