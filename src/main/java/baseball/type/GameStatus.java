package baseball.type;

public enum GameStatus {

    START("1"), // 게임 시작
    QUIT("2"), // 게임 종료
    ONGOING("3"); // 게임 진행중

    private final String command;

    GameStatus(String command) {
        this.command = command;
    }

    public static GameStatus getGameStatusByCommand(String gameCommand) {
        if (gameCommand.equals(START.command)) return START;
        if (gameCommand.equals(QUIT.command)) return QUIT;
        return ONGOING;
    }
}
