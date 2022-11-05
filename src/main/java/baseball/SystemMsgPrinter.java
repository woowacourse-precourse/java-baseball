package baseball;

public final class SystemMsgPrinter {
    private SystemMsgPrinter() {}

    public static void printGameStartMessage() {
        System.out.println(SystemConstant.GAME_START_MESSAGE);
    }

    public static void printGameEndMessage() {
        System.out.println(SystemConstant.GAME_END_MESSAGE);
    }

    public static void printGameRestartMessage() {
        System.out.println(SystemConstant.GAME_RESTART_MESSAGE);
    }

    public static void printGameInputMessage() {
        System.out.print(SystemConstant.GAME_INPUT_MESSAGE);
    }
}
