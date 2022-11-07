package baseball.constants;

public class SystemConsole {

    public void gameResultNumberMessage(String gameResultNumber) {
        System.out.println(gameResultNumber);
    }

    public void PlayerInputMessage() {
        System.out.print(SystemMessage.SETUP_MESSAGE);
    }

    public void baseballStartMessage() {
        System.out.println(SystemMessage.INITIAL_MESSAGE);
    }

    public static void gameRestartMessage() {
        System.out.println(SystemMessage.GAME_RESTART_MESSAGE);
    }

    public static void gameWinMessage() {
        System.out.println(SystemMessage.GAME_WIN_MESSAGE);
    }
}
