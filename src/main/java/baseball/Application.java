package baseball;

public class Application {
    static final int start  = 1;
    static final int exit   = 2;
    public static void main(String[] args) {
        int gameStatus = start;
        while(gameStatus == start) {
            startNumberBaseball();
            gameStatus = askRestartOrExit();
        }
    }

    private static void startNumberBaseball() {}
    private static int askRestartOrExit() {
        int result = exit;
        return result;
    }
}
