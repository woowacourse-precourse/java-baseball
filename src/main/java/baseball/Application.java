package baseball;

public class Application {
    public static void restartGame(boolean restart) {
        if (restart)
            playGame();
    }
    public static void main(String[] args) {
        PrintUtil printUtil = new PrintUtil();
        printUtil.startApplication();
    }
}
