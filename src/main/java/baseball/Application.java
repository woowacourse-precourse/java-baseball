package baseball;

public class Application {
    private static final int RESTART_GAME = 1;
    private static final int STOP_PROGRAM = 2;
    private static final int STOP_GAME = 3;
    private static int gameExecution = 0;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static Number restartGame(Number computer) {
        if (gameExecution == RESTART_GAME) {
            gameExecution = 0;
            return new Number();
        }
        return computer;
    }

    private static void stopProgram() {
        if (gameExecution == STOP_PROGRAM) {
            ResponseMessage.stopProgram();
        }
    }
}