package baseball;

public final class SystemMsgPrinter {
    private SystemMsgPrinter() {}

    public static void printGameStartMessage() {
        System.out.println(SystemConstant.GAME_START_MESSAGE);
    }

    public static void printGameEndAndRestartMessage() {
        System.out.println(SystemConstant.GAME_END_AND_RESTART_MESSAGE);
    }

    public static void printGameInputMessage() {
        System.out.print(SystemConstant.GAME_INPUT_MESSAGE);
    }
}
