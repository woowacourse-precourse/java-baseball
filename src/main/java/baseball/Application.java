package baseball;

public class Application {
    private static final PrintUtil printUtil = new PrintUtil();
    public static void inputGame() {
        DataProcessing dataProcessing = new DataProcessing();
        boolean end;
        dataProcessing.createRandomNumber();
        do {
            printUtil.printInputNumber();
            end = dataProcessing.printBallStrike();
        } while (!end);
    }
    public static void playGame() {
        InputUtil inputUtil = new InputUtil();
        inputGame();
        printUtil.printEndGame();
        inputUtil.restartQuestion();
    }
    public static void startApplication() {
        printUtil.printStartGame();
        playGame();
    }
    public static void main(String[] args) {
        startApplication();
    }
}
